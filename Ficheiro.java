import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

/**
 * Classe publica Ficheiro
 */
public class Ficheiro {

    /**
     * Constutor vazio da classe Ficheiro
     */
    public Ficheiro() {
    }

    /**
     * Metodo para ler as perguntas do ficheiro texto
     * @return
     */


    public ArrayList<Pergunta> lerPerguntas(){
        File f = new File("pootrivia.txt");
        ArrayList<Pergunta> perguntas = new ArrayList<Pergunta>();
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linha;
            while((linha = br.readLine()) != null ){
                String[] dividido = linha.split(";");
                switch (dividido[0]){
                    case "0":
                        Arte a = new Arte(dividido[1], dividido[2], dividido[3].split(","));
                        perguntas.add(a);
                        break;
                    case "1":
                        Ciencias c = new Ciencias(dividido[1], dividido[2], dividido[3].split(","), dividido[4].split(","));
                        perguntas.add(c);
                        break;
                    case "2":
                        Futebol fut = new Futebol(dividido[1], dividido[2], dividido[3], dividido[4].split(","), dividido[5].split(","));
                        perguntas.add(fut);
                        break;
                    case "3":
                        Natacao n = new Natacao(dividido[1], dividido[2]);
                        perguntas.add(n);
                        break;
                    case "4":
                        Ski s = new Ski(dividido[1], dividido[2]);
                        perguntas.add(s);
                        break;
                    default:
                        throw new ArrayIndexOutOfBoundsException();
                }
            }

        }catch (FileNotFoundException e){
            JOptionPane.showMessageDialog(null, "Ficheiro de perguntas inexistente!", "Erro", JOptionPane.ERROR_MESSAGE);
        }catch (IOException e){
            JOptionPane.showMessageDialog(null, "Erro ao ler o ficheiro de perguntas!", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, "Ficheiro de perguntas mal formatado!", "Erro", JOptionPane.ERROR_MESSAGE);
            perguntas = new ArrayList<>();
        }
        return perguntas;
    }

    public ArrayList<Jogo> lerJogos(){
        ArrayList<Jogo> jogos = new ArrayList<Jogo>();
        try{
            FileInputStream fIS;
            ObjectInputStream oIS;
            File pasta = new File("./Jogos");
            for (File f: pasta.listFiles()) {
                fIS = new FileInputStream(f); // cria leitor de ficheiro
                oIS = new ObjectInputStream(fIS); // cria leitor de objetos
                Jogo j = (Jogo) oIS.readObject(); // le o objeto e converte p jogo
                jogos.add(j); // adiciona Jogo a lista de jogos
                fIS.close(); // fecha ficheiro
                oIS.close(); // fecha objeto
            }
        }catch (Exception e){
            System.out.println("Erro ao ler ficheiro de jogo!");
        }
        return jogos;
    }

    public void escreverFicheiroJogo(Jogo j){
        DataHora d = j.getDataHora();
        File file = new File("./Jogos/%4d-%2d-%2d;%2d:%2d.dat".formatted(d.getAno(), d.getMes(), d.getDia(), d.getHora(), d.getMinuto()));
        try{
            FileOutputStream fOS = new FileOutputStream(file);
            ObjectOutputStream oOS = new ObjectOutputStream(fOS);
            oOS.writeObject(j);
            fOS.close();
            oOS.close();
        }catch (Exception e){
            System.out.println("Erro ao escrever ficheiro de jogo!!");
        }
    }

}
