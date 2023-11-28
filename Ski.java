public class Ski extends Desporto{

    public Ski() {}

    public Ski(String enunciado, String resposta) {
        super(enunciado, resposta);
    }

    @Override
    public String[] getOpcoesFacil() {
        return super.opcoes;
    }

    @Override
    public String[] getOpcoesDificil() {
        return super.opcoes;
    }

    @Override
    public int valorPergunta() {
        return super.valorPergunta() * 2;
    }
}
