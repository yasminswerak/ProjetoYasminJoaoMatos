public class Ciencia extends Pergunta{
    private String[] opcoesFaceis, opcoesDificeis;


    @Override
    public String[] getOpcoesFacil() {
        return opcoesDificeis;
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
