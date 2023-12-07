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
    /**
     * Objeto da classe Ficheiro
     */
    private Ficheiro ficheiro;

    // construtor:
    /**
     * Construtor da classe POOTrivia
     */
    public POOTrivia(){
        this.ficheiro = new Ficheiro();
        this.perguntas = ficheiro.lerPerguntas();
    }

    /**
     * Metodo que retorna quantas perguntas temos no total
     * @return tamanho de perguntas (quantas temos)
     */
    public int getNumeroDePerguntas(){
        return perguntas.size();
    }

    /**
     * Metodo que "calcula" o top3: ela percorre os ficheiros de objetos e troca os top3 de lugar se for necessario
     * @return top3
     */
    public ArrayList<Jogo> getTop3(){
        ArrayList<Jogo> top3 = new ArrayList<Jogo>();
        //adicionar 3 jogos vazios para possibilitar comparações
        top3.add(new Jogo());
        top3.add(new Jogo());
        top3.add(new Jogo());
        for (Jogo j: ficheiro.lerJogos()){ //vai a cada jogo
            if(j.calculaPontuacao() > top3.get(0).calculaPontuacao()){ // se ele se tornar o novo PRIMEIRO lugar
                top3.set(2,top3.get(1)); //pega o que ERA o segundo na coloca em terceiro lugar
                top3.set(1,top3.get(0)); //pega o que ERA o primiero e coloca ele em segundo lugar
                top3.set(0, j); //mete o jogo na primeira posicao
            } else if (j.calculaPontuacao() > top3.get(1).calculaPontuacao()) { // se ele se tornar o novo SEGUNDO lugar
                top3.set(2,top3.get(1));
                top3.set(1, j);
            } else if (j.calculaPontuacao() > top3.get(2).calculaPontuacao()) { // se ele se tornar o novo TERCEIRO lugar
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
        if (app.getNumeroDePerguntas() >= 10) {
            new MeuGUI(app);
        }else{
            JOptionPane.showMessageDialog(null, "O Ficheiro de perguntas possiu menos de 10 perguntas!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
