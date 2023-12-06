import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        menu.add(novoJogo);
        menu.add(top3);
        menu.add(sair);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        inicio = new JPanel();
        inicio.setLayout(new GridLayout(2,1));
        iniciar = new JButton("Iniciar");
        textoIniciar = new JLabel("Jogo Super Fixe de Perguntas");
        textoIniciar.setHorizontalAlignment(JLabel.CENTER);
        iniciar.addActionListener(bAL);
        inicio.add(textoIniciar);
        inicio.add(iniciar);


        pergunta = new JPanel();
        topTres = new JPanel();

        cl = new CardLayout();
        painelPrincipal = new JPanel(cl);
        painelPrincipal.add(inicio, "inicio");
        painelPrincipal.add(pergunta, "pergunta");
        painelPrincipal.add(topTres, "topTres");

        this.add(painelPrincipal);
        cl.show(painelPrincipal, "inicio");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(300, 300));
        this.setSize(300, 300);
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
            Pergunta p = app.getPerguntaNum(num);
            pergunta.add(new JLabel("Pergunta %d:".formatted(j.perguntasRespondidas() + 1)));
            pergunta.add(new JLabel(p.enunciado));
            if (j.perguntasRespondidas() >= 3){
                for(String s: p.getOpcoesDificil()){
                    JButton button = new JButton(s);
                    if(s.equals(p.resposta)) {
                        button.addActionListener(cAL);
                    }else{
                        button.addActionListener(eAL);
                    }
                    pergunta.add(button);
                }
            }else{
                for(String s: p.getOpcoesFacil()){
                    JButton button = new JButton(s);
                    if(s.equals(p.resposta)) {
                        button.addActionListener(cAL);
                    }else{
                        button.addActionListener(eAL);
                    }
                    pergunta.add(button);
                }
            }
            cl.show(painelPrincipal, "pergunta");
        }
    }

    public void acabaJogo(){
        //TODO pedir nome no final e guardar ficheiro
        JOptionPane.showMessageDialog(null, "Tiveste %d pontos!".formatted(jogo.calculaPontuacao()), "Fim de Jogo!", JOptionPane.INFORMATION_MESSAGE);
        //TODO mudar para Top3
        cl.show(painelPrincipal, "inicio");
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
            if (e.getSource() == iniciar){
                jogo = new Jogo();
                mostraPergunta(jogo);
            }
        }
    }
    private class CertoActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null,"Boa! Ganhaste %d pontos!".formatted(app.getPerguntaNum(num).valorPergunta()));
            jogo.acertouPergunta(app.getPerguntaNum(num));
            mostraPergunta(jogo);
        }
    }
    private class ErradoActionListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null,"Erraste ;(");
            jogo.errouPergunta(app.getPerguntaNum(num));
            mostraPergunta(jogo);
        }
    }
}
