import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe publica POOTrivia
 */
public class POOTrivia {
    /**
     * ArrayList com todas as perguntas
     */
    private ArrayList<Pergunta> perguntas;

    /**
     * ArrayList com todos os jogos realizados
     */
    private ArrayList<Jogo> jogos;


    public POOTrivia(){
        Ficheiro f = new Ficheiro();
        this.perguntas = f.lerPerguntas();
        this.jogos = f.lerJogos();
    }


    public ArrayList<Pergunta> getPerguntas() {
        return perguntas;
    }

    public void setPerguntas(ArrayList<Pergunta> perguntas) {
        this.perguntas = perguntas;
    }

    public ArrayList<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(ArrayList<Jogo> jogos) {
        this.jogos = jogos;
    }

    //Main
    public static void main(String[] args) {
        POOTrivia app = new POOTrivia();
        //Scanner stdin = new Scanner(System.in);


    }
}
