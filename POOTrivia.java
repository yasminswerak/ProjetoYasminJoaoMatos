import javax.swing.*;
import java.util.ArrayList;


/**
 * Classe publica POOTrivia
 */
public class POOTrivia {
    /**
     * ArrayList com todas as perguntas
     */
    private ArrayList<Pergunta> perguntas;
    private Ficheiro ficheiro;


    public POOTrivia(){
        this.ficheiro = new Ficheiro();
        this.perguntas = ficheiro.lerPerguntas();
    }

    public int getNumeroDePerguntas(){
        return perguntas.size();
    }

    public ArrayList<Jogo> getTop3(){
        ArrayList<Jogo> top3 = new ArrayList<Jogo>();
        //adicionar 3 jogos vazios para possibilitar comparações
        top3.add(new Jogo());
        top3.add(new Jogo());
        top3.add(new Jogo());
        for (Jogo j: ficheiro.lerJogos()){
            if(j.calculaPontuacao() > top3.get(0).calculaPontuacao()){
                top3.set(2,top3.get(1));
                top3.set(1,top3.get(0));
                top3.set(0, j);
            } else if (j.calculaPontuacao() > top3.get(1).calculaPontuacao()) {
                top3.set(2,top3.get(1));
                top3.set(1, j);
            } else if (j.calculaPontuacao() > top3.get(2).calculaPontuacao()) {
                top3.set(2,j);
            }
        }
        return top3;
    }

    public void escreverFicheiroJogo(Jogo j){
        ficheiro.escreverFicheiroJogo(j);
    }

    public Pergunta getPerguntaNum(int num){
        return perguntas.get(num);
    }

    public ArrayList<Pergunta> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(ArrayList<Pergunta> perguntas) {
        this.perguntas = perguntas;
    }


    //Main
    public static void main(String[] args) {
        POOTrivia app = new POOTrivia();
        if (app.getNumeroDePerguntas() >= 5) {
            new MeuGUI(app);
        }else{
            JOptionPane.showMessageDialog(null, "O Ficheiro de perguntas possiu menos de 5 perguntas!", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }
}
