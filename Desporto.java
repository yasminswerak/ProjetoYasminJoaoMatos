/**
 * Classe abstrata Desporto filha de Pergunta
 */
public abstract class Desporto extends Pergunta{
    /**
     * Construtor vazio de Desporto
     */
    public Desporto() {}

    /**
     * Construtor de Desporto
     * @param enunciado enunciado da pergunta
     */
    public Desporto(String enunciado) {
        super(enunciado);
    }

    /**
     * Construtor de Desporto
     * @param enunciado enunciado da pergunta
     * @param resposta resposta da pergunta
     */
    public Desporto(String enunciado, String resposta){
        super(enunciado, resposta, new String[]{"Verdadeiro", "Falso"});
    }
    /**
     * Override para obter o valor/pontuacao da pergunta
     * @return pontuacao da pergunta
     */
    @Override
    public int valorPergunta() {
        return super.valorPergunta() + 3;
    }
}
