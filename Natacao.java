import java.io.Serializable;

/**
 * Classe publica Natacao filha de Desporto e que implementa Serializable
 */
public class Natacao extends Desporto implements Serializable {
    /**
     * Construtor vazio de Natacao
     */
    public Natacao() {}

    /**
     * Construtor de Natacao
     * @param enunciado Enunciado da pergunta
     * @param resposta Resposta da pergunta
     */
    public Natacao(String enunciado, String resposta) {
        super(enunciado, resposta);
    }

    //em natacao a dificuldade nao se altera ao longo do jogo, por isso as duas retornam super.opcpes:
    /**
     * Metodo Override que retorna as opcoes
     * @return  opcoes
     */
    @Override
    public String[] getOpcoesFacil() {
        return super.opcoes;
    }

    /**
     * MetodoOverride que retorna as opcoes
     * @return opcoes
     */
    @Override
    public String[] getOpcoesDificil() {
        return super.opcoes;
    }

    /**
     * Override para obter o valor/pontuacao da pergunta
     * @return Pontuacao da pergunta
     */
    @Override
    public int valorPergunta() {
        return super.valorPergunta() + 10;
    }
}
