import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class MeuGUI extends JFrame {
    private POOTrivia app;
    private Jogo jogo;
    private Random random;
    private CardLayout cl;
    private JPanel painelPrincipal;
    private JPanel inicio;
    private JPanel pergunta;
    private JPanel topTres;
    private JMenuBar menuBar;
    private JMenu menu;
    private JLabel textoIniciar;
    private JButton iniciar;
    private JMenuItem novoJogo;
    private JMenuItem top3;
    private JMenuItem sair;
    private CertoActionListener cAL;
    private ErradoActionListener eAL;
    /**
     * Variavel para saber o índice (array de perguntas da app) da pergunta atual!
     */
    private int num;

    public MeuGUI(POOTrivia app){
        super();
        this.random = new Random();
        this.app = app;
        ButtonActionListener bAL = new ButtonActionListener();
        eAL = new ErradoActionListener();
        cAL = new CertoActionListener();

        menu = new JMenu("Menu");
        menuBar = new JMenuBar();
        //TODO adicionar ações do menu
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
        this.setMinimumSize(new Dimension(400, 400));
        this.setSize(400, 400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void mostraPergunta(Jogo j){
        if(j.perguntasRespondidas() >= 5){
            acabaJogo();
        }else{
            limpaPergunta();
            do{
                num = random.nextInt(app.getNumeroDePerguntas());
            }while (j.jaRespondida(app.getPerguntaNum(num)));
            JPanel numeroPergunta = new JPanel();
            JPanel enunciado = new JPanel();
            JPanel opcoes = new JPanel();
            numeroPergunta.setBackground(new Color(250, 207, 225));
            enunciado.setBackground(new Color(250, 207, 225));
            opcoes.setBackground(new Color(250, 207, 225));
            Pergunta p = app.getPerguntaNum(num);
            JLabel labelPergunta = new JLabel("Pergunta %d:".formatted(j.perguntasRespondidas() + 1));
            labelPergunta.setForeground(new Color(230, 14, 106));
            numeroPergunta.add(labelPergunta);
            enunciado.add(new JLabel(p.enunciado));
            if (j.perguntasRespondidas() >= 3){
                for(String s: p.getOpcoesDificil()){
                    JButton button = new JButton(s);
                    if(s.equals(p.resposta)) {
                        button.addActionListener(cAL);
                    }else{
                        button.addActionListener(eAL);
                    }
                    opcoes.add(button);
                }
            }else{
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

    public void acabaJogo(){
        String nome = "";
        do {
            nome = JOptionPane.showInputDialog(pergunta, "Tiveste %d pontos!\nInsira o seu nome:".formatted(jogo.calculaPontuacao()), "Fim de Jogo!", JOptionPane.INFORMATION_MESSAGE);
        } while (!nome.matches("[A-Za-z ]+"));
        jogo.setNomeUtilizador(nome);
        app.escreverFicheiroJogo(jogo);
        mostraTopTres();
    }

    public void mostraTopTres(){
        limpaTopTres();
        ArrayList<Jogo> top3List = app.getTop3();
        //Verificar se tem algum jogo!!
        if(top3List.get(0).calculaPontuacao() == 0){
            topTres.add(new JLabel("Nenhum jogo efetuado :("));
        }else{
            JLabel titulo = new JLabel("--- Top 3 ---", JLabel.CENTER);
            topTres.add(titulo);
            topTres.add(new JLabel("1º Lugar: %s - %d pontos (%s)".formatted(top3List.get(0).getNomeUtilizador(), top3List.get(0).calculaPontuacao(), top3List.get(0).getDataHora().toStringApp()), JLabel.CENTER));
            if (top3List.get(1).calculaPontuacao() != 0) {
                topTres.add(new JLabel("2º Lugar: %s - %d pontos (%s)".formatted(top3List.get(1).getNomeUtilizador(), top3List.get(1).calculaPontuacao(), top3List.get(1).getDataHora().toStringApp()), JLabel.CENTER));
            }
            if (top3List.get(2).calculaPontuacao() != 0) {
                topTres.add(new JLabel("3º Lugar: %s - %d pontos (%s)".formatted(top3List.get(2).getNomeUtilizador(), top3List.get(2).calculaPontuacao(), top3List.get(2).getDataHora().toStringApp()), JLabel.CENTER));
            }
        }

        cl.show(painelPrincipal, "topTres");
    }

    public void limpaTopTres(){
        topTres.removeAll();
        topTres.revalidate();
        topTres.repaint();
    }
    public void limpaPergunta(){
        pergunta.removeAll();
        pergunta.revalidate();
        pergunta.repaint();
    }

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
    private class CertoActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(pergunta,"Boa! Ganhaste %d pontos!".formatted(app.getPerguntaNum(num).valorPergunta()));
            jogo.acertouPergunta(app.getPerguntaNum(num));
            mostraPergunta(jogo);
        }
    }
    private class ErradoActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(pergunta,"Erraste ;(");
            jogo.errouPergunta(app.getPerguntaNum(num));
            mostraPergunta(jogo);
        }
    }
}
