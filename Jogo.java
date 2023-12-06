import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Classe publica para Jogo
 */
public class Jogo implements Serializable {
    /**
     * Objeto da classe "DataHora"
     */
    private DataHora dataHora;
    /**
     * String nomeUtilizador
     */
    private String nomeUtilizador;
    /**
     * Array list com as perguntas respondidas corretamente pelo utilizador
     */
    private ArrayList<Pergunta> certas;
    /**
     * Array list com as perguntas erradas pelo utilizador
     */
    private ArrayList<Pergunta> erradas;

    /**
     * Construtor de Jogo
     */
    public Jogo() { // cria jogo com a data e hora atual
        LocalDate data = LocalDate.now();
        LocalTime hora = LocalTime.now();
        this.dataHora = new DataHora(data.getDayOfMonth(), data.getMonthValue(), data.getYear(), hora.getHour(), hora.getMinute());
        this.certas = new ArrayList<Pergunta>();
        this.erradas = new ArrayList<Pergunta>();
    }

    /**
     * Metodo que adiciona ao ArrayList certas a pergunta
     * @param p Pergunta
     */
    public void acertouPergunta(Pergunta p){
        certas.add(p);
    }
    /**
     * Metodo que adiciona ao ArrayList erradas a pergunta
     * @param p Pergunta
     */
    public void errouPergunta(Pergunta p){
        erradas.add(p);
    }

    /**
     * Metodo que verifica se a pergunta ja foi respondida
     * @param p Pergunta
     * @return true se ja foi respondida e false caso contrario
     */
    public boolean jaRespondida(Pergunta p){
        return (certas.contains(p) | erradas.contains(p));
    }

    /**
     * Metodo que calcula a pontuacao total das perguntas respondidas
     * @return pontuacao total
     */
    public int calculaPontuacao(){
        int pontos = 0;
        for (Pergunta p: certas){
            pontos += p.valorPergunta();
        }
        return pontos;
    }

    /**
     * Metodo que retorna o numero de perguntas ja respondidas
     * @return numero de perguntas ja respondidas
     */
    public int perguntasRespondidas(){
        return (certas.size() + erradas.size());
    }

    //getters e setters:
    /**
     * Getter de DataHora
     * @return dataHora
     */
    public DataHora getDataHora() {
        return dataHora;
    }

    /**
     * Setter de DataHora
     * @param dataHora objeto DataHora
     */
    public void setDataHora(DataHora dataHora) {
        this.dataHora = dataHora;
    }

    /**
     * Getter de NomeUtilizador
     * @return String com nomeUtilizador
     */
    public String getNomeUtilizador() {
        return nomeUtilizador;
    }

    /**
     * Setter de NomeUtilizador
     * @param nomeUtilizador String nomeUtlizador
     */
    public void setNomeUtilizador(String nomeUtilizador) {
        this.nomeUtilizador = nomeUtilizador;
    }

    /**
     * Getter de Certas
     * @return ArrayLisst das perguntas certas
     */
    public ArrayList<Pergunta> getCertas() {
        return certas;
    }

    /**
     * Setter de Certas
     * @param certas ArrayList certas
     */
    public void setCertas(ArrayList<Pergunta> certas) {
        this.certas = certas;
    }

    /**
     * Getter de Erradas
     * @return ArrayList de erradas
     */
    public ArrayList<Pergunta> getErradas() {
        return erradas;
    }

    /**
     * Setter de Erradas
     * @param erradas ArrayList de erradas
     */
    public void setErradas(ArrayList<Pergunta> erradas) {
        this.erradas = erradas;
    }
}
