public class Ciencias extends Pergunta{
    private String[] opcoesFaceis, opcoesDificeis;

    public Ciencias(String enunciado, String resposta, String[] opcoesFaceis, String[] opcoesDificeis) {
        super(enunciado, resposta);
        this.opcoesFaceis = opcoesFaceis;
        this.opcoesDificeis = opcoesDificeis;
    }

    @Override
    public String[] getOpcoesFacil() {
        return opcoesFaceis;
    }

    @Override
    public String[] getOpcoesDificil() {
        return opcoesDificeis;
    }

    @Override
    public int valorPergunta() {
        return super.valorPergunta() + 5;
    }
}
