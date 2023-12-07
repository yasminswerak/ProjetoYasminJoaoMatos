import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

/**
 * Classe publica MeuGUi
 */
public class MeuGUI extends JFrame {
    /**
     * Objeto da classe POOTrivia
     */
    private POOTrivia app;
    /**
     * Objeto da classe Jogo
     */
    private Jogo jogo;
    /**
     * Objeto da classe Random
     */
    private Random random;
    /**
     * Objeto para possibilitar a troca de paineis
     */
    private CardLayout cl;
    /**
     * Objeto painel principal (com CardLayout)
     */
    private JPanel painelPrincipal;
    /**
     * Objeto painel inicial: bem vindo/botao de iniciar
     */
    private JPanel inicio;
    /**
     * Objeto painel com o numero da pergunta, enunciado e opcoes
     */
    private JPanel pergunta;
    /**
     * Objeto painel com os top 3
     */
    private JPanel topTres;
    /**
     * Objeto para a barra de menu
     */
    private JMenuBar menuBar;
    /**
     * Objeto menu
     */
    private JMenu menu;
    /**
     * Texto iniciar POOTrivia
     */
    private JLabel textoIniciar;
    /**
     * Botao para iniciar o jogo
     */
    private JButton iniciar;
    /**
     * Item novo jogo do menu
     */
    private JMenuItem novoJogo;
    /**
     * Item top3 do menu
     */
    private JMenuItem top3;
    /**
     * Item sair do menu
     */
    private JMenuItem sair;
    /**
     * Classe privada para realizar acoes com o botao da resposta certa
     */
    private CertoActionListener cAL;
    /**
     * Classe privada para realizar acoes com o botao da resposta errada
     */
    private ErradoActionListener eAL;
    /**
     * Variavel para saber o índice (array de perguntas da app) da pergunta atual
     */
    private int num;

    /**
     * Construtor de GUI
     * @param app app
     */
    public MeuGUI(POOTrivia app){
        super();
        this.random = new Random();
        this.app = app;
        ButtonActionListener bAL = new ButtonActionListener();
        eAL = new ErradoActionListener();
        cAL = new CertoActionListener();

        menu = new JMenu("Menu");
        menuBar = new JMenuBar();
        novoJogo = new JMenuItem("Novo Jogo");
        top3 = new JMenuItem("Top 3");
        sair = new JMenuItem("Sair");
        novoJogo.addActionListener(bAL);
        top3.addActionListener(bAL);
        sair.addActionListener(bAL);
        menu.add(novoJogo);
        menu.add(top3);
        menu.add(sair);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        inicio = new JPanel();
        inicio.setLayout(new GridLayout(2,1));
        iniciar = new JButton("Iniciar");
        textoIniciar = new JLabel("POOTrivia");
        textoIniciar.setHorizontalAlignment(JLabel.CENTER);
        iniciar.addActionListener(bAL);
        inicio.add(textoIniciar);
        inicio.add(iniciar);
        inicio.setBackground(new Color(250, 207, 225));


        pergunta = new JPanel();
        topTres = new JPanel();
        pergunta.setLayout(new BoxLayout(pergunta, BoxLayout.Y_AXIS));
        topTres.setLayout(new GridLayout(4,1));
        topTres.setBackground(new Color(250, 207, 225));

        cl = new CardLayout();
        painelPrincipal = new JPanel(cl);
        painelPrincipal.add(inicio, "inicio");
        painelPrincipal.add(pergunta, "pergunta");
        painelPrincipal.add(topTres, "topTres");

        this.add(painelPrincipal);
        cl.show(painelPrincipal, "inicio");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(700, 500));
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    /**
     * Metodo para mostrar as perguntas
     * @param j Jogo
     */
    public void mostraPergunta(Jogo j){
        if(j.perguntasRespondidas() >= 5){
            acabaJogo();
        }else{
            limpaPergunta();
            do{
                num = random.nextInt(app.getNumeroDePerguntas()); //escolher um numero random
            }while (j.jaRespondida(app.getPerguntaNum(num))); //ate que a pergunta ainda nao tiver sido respondida
            JPanel numeroPergunta = new JPanel();
            JPanel enunciado = new JPanel();
            JPanel opcoes = new JPanel();
            numeroPergunta.setBackground(new Color(250, 207, 225));
            enunciado.setBackground(new Color(250, 207, 225));
            opcoes.setBackground(new Color(250, 207, 225));
            Pergunta p = app.getPerguntaNum(num); //pegamos a pergunta
            JLabel labelPergunta = new JLabel("Pergunta %d:".formatted(j.perguntasRespondidas() + 1));
            labelPergunta.setForeground(new Color(230, 14, 106));
            numeroPergunta.add(labelPergunta);
            enunciado.add(new JLabel(p.enunciado));
            if (j.perguntasRespondidas() >= 3){ //quando chegarmos na terceira pergunta
                for(String s: p.getOpcoesDificil()){ //perguntas dificeis
                    JButton button = new JButton(s);
                    if(s.equals(p.resposta)) {
                        button.addActionListener(cAL);
                    }else{
                        button.addActionListener(eAL);
                    }
                    opcoes.add(button);
                }
            }else{ //perguntas faceis
                for(String s: p.getOpcoesFacil()){
                    JButton button = new JButton(s);
                    if(s.equals(p.resposta)) {
                        button.addActionListener(cAL);
                    }else{
                        button.addActionListener(eAL);
                    }
                    opcoes.add(button);
                }
            }
            pergunta.add(numeroPergunta);
            pergunta.add(enunciado);
            pergunta.add(opcoes);
            cl.show(painelPrincipal, "pergunta");
        }
    }

    /**
     * Metodo usado quando o jogo termina: ela indica quantos pontos o utilizador teve, pede o seu nome e mostra o top 3
     */
    public void acabaJogo(){
        String nome = "";
        do {
            nome = JOptionPane.showInputDialog(pergunta, "Tiveste %d pontos!\nInsira o seu nome:".formatted(jogo.calculaPontuacao()), "Fim de Jogo!", JOptionPane.INFORMATION_MESSAGE);
        } while (!nome.matches("[A-Za-z ]+"));
        jogo.setNomeUtilizador(nome);
        app.escreverFicheiroJogo(jogo);
        mostraTopTres();
    }

    /**
     * Metodo para mostrar o Top 3: ele limpa o top 3, cria um novo array top 3, e faz as verificacoes necessarias com a spontuacoes
     */
    public void mostraTopTres(){
        limpaTopTres();
        ArrayList<Jogo> top3List = app.getTop3();
        if(top3List.get(0).calculaPontuacao() == 0){
            topTres.add(new JLabel("Nenhum jogo com pontuação > 0 efetuado :(", JLabel.CENTER));
        }else{
            JLabel titulo = new JLabel("--- Top 3 ---", JLabel.CENTER);
            topTres.add(titulo);
            topTres.add(new JLabel("1º Lugar: %s - %d pontos (%s)".formatted(top3List.get(0).getNomeUtilizador(), top3List.get(0).calculaPontuacao(), top3List.get(0).getDataHora().toStringApp()), JLabel.CENTER));
            if (top3List.get(1).calculaPontuacao() != 0) { //se houver segundo lugar
                topTres.add(new JLabel("2º Lugar: %s - %d pontos (%s)".formatted(top3List.get(1).getNomeUtilizador(), top3List.get(1).calculaPontuacao(), top3List.get(1).getDataHora().toStringApp()), JLabel.CENTER));
            }
            if (top3List.get(2).calculaPontuacao() != 0) { //se houver terceiro lugar
                topTres.add(new JLabel("3º Lugar: %s - %d pontos (%s)".formatted(top3List.get(2).getNomeUtilizador(), top3List.get(2).calculaPontuacao(), top3List.get(2).getDataHora().toStringApp()), JLabel.CENTER));
            }
        }

        cl.show(painelPrincipal, "topTres");
    }

    /**
     * Metodo que limpa o top 3: tira todos os elementos do painel, e da reset
     */
    public void limpaTopTres(){
        topTres.removeAll();
        topTres.revalidate();
        topTres.repaint();
    }

    /**
     * Metodo que limpa as perguntas: tira a pergunta do painel e da reset
     */
    public void limpaPergunta(){
        pergunta.removeAll();
        pergunta.revalidate();
        pergunta.repaint();
    }

    /**
     *Classe privada que realiza acoes quando o utilizador clica em iniciar, novo jogo, top3, ou sair
     */
    private class ButtonActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == iniciar | e.getSource() == novoJogo){
                jogo = new Jogo();
                mostraPergunta(jogo);
            } else if (e.getSource() == top3) {
                mostraTopTres();
            } else if (e.getSource() == sair) {
                setVisible(false);
                dispose();
            }
        }
    }

    /**
     * Classe privada que realiza acoes quando o utilizador escolhe o botao certo (acerta a pergunta)
     */
    private class CertoActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(pergunta,"Boa! Ganhaste %d pontos!".formatted(app.getPerguntaNum(num).valorPergunta()));
            jogo.acertouPergunta(app.getPerguntaNum(num));
            mostraPergunta(jogo);
        }
    }
    /**
     * Classe privada que realiza acoes quando o utilizador escolhe um dos botoes errados (erra a pergunta)
     */
    private class ErradoActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(pergunta,"Erraste ;(");
            jogo.errouPergunta(app.getPerguntaNum(num));
            mostraPergunta(jogo);
        }
    }
}
