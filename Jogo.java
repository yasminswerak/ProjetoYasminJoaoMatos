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
    private ArrayList<Pergunta> certas;
    private ArrayList<Pergunta> erradas;

    public Jogo() { // cria jogo com a data e hora atual
        LocalDate data = LocalDate.now();
        LocalTime hora = LocalTime.now();
        this.dataHora = new DataHora(data.getDayOfMonth(), data.getMonthValue(), data.getYear(), hora.getHour(), hora.getMinute());
        this.certas = new ArrayList<Pergunta>();
        this.erradas = new ArrayList<Pergunta>();
    }

    public void acertouPergunta(Pergunta p){
        certas.add(p);
    }

    public void errouPergunta(Pergunta p){
        erradas.add(p);
    }

    public boolean jaRespondida(Pergunta p){
        return (certas.contains(p) | erradas.contains(p));
    }

    public int calculaPontuacao(){
        int pontos = 0;
        for (Pergunta p: certas){
            pontos += p.valorPergunta();
        }
        return pontos;
    }

    public int perguntasRespondidas(){
        return (certas.size() + erradas.size());
    }

    public DataHora getDataHora() {
        return dataHora;
    }

    public void setDataHora(DataHora dataHora) {
        this.dataHora = dataHora;
    }

    public String getNomeUtilizador() {
        return nomeUtilizador;
    }

    public void setNomeUtilizador(String nomeUtilizador) {
        this.nomeUtilizador = nomeUtilizador;
    }

    public ArrayList<Pergunta> getCertas() {
        return certas;
    }

    public void setCertas(ArrayList<Pergunta> certas) {
        this.certas = certas;
    }

    public ArrayList<Pergunta> getErradas() {
        return erradas;
    }

    public void setErradas(ArrayList<Pergunta> erradas) {
        this.erradas = erradas;
    }
}
