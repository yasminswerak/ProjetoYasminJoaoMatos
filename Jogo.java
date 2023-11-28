import java.util.ArrayList;

public class Jogo {
    private DataHora dataHora;
    private String nomeUtilizador;
    private ArrayList<Pergunta> certas;
    private ArrayList<Pergunta> erradas;

    public boolean jaRespondida(Pergunta p){
        if (certas.contains(p) | erradas.contains(p)){
            return true;
        }else{
            return false;
        }
    }
}
