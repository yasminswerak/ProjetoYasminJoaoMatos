import java.io.Serializable;

/**
 * Classe publica Ski filha de Desporto
 */
public class Ski extends Desporto implements Serializable {

    /**
     * Construtor vazio de Ski
     */
    public Ski() {}

    /**
     * Construtor de Ski
     * @param enunciado Enunciado da Pergunta
     * @param resposta Resposta da Pergunta
     */
    public Ski(String enunciado, String resposta) {
        super(enunciado, resposta);
    }

    // em ski a dificuldade nao se altera, por isso retornamos super.opcoes nos dois:
    /**
     * Metodo Override que retorna as opcoes
     * @return opcoes
     */
    @Override
    public String[] getOpcoesFacil() {
        return super.opcoes;
    }
    /**
     * Metodo Override que retorna as opcoes
     * @return opcoes
     */
    @Override
    public String[] getOpcoesDificil() {
        return super.opcoes;
    }

    /**
     * Metodo Override para calcular o valor/pontuacao da pergunta
     * @return pontuacao da pergunta
     */
    @Override
    public int valorPergunta() {
        return super.valorPergunta() * 2;
    }
}
