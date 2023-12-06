import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Classe publica POOTrivia
 */
public class POOTrivia {
    /**
     * ArrayList com todas as perguntas
     */
    private ArrayList<Pergunta> perguntas;


    public POOTrivia(){
        Ficheiro f = new Ficheiro();
        this.perguntas = f.lerPerguntas();
    }

    public int getNumeroDePerguntas(){
        return perguntas.size();
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
