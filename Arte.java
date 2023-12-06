import java.io.Serializable;
import java.util.Arrays;

/**
 * Classe publica Arte filha de Pergunta
 */
public class Arte extends Pergunta implements Serializable {
    /**
     * Construtor vazio de Arte
     */
    public Arte() {}

    /**
     * Construtor de Arte
     * @param enunciado Enunciado da pergunta
     * @param resposta Resposta da pergunta
     * @param opcoes Opcoes de resposta
     */
    public Arte(String enunciado, String resposta, String[] opcoes) {
        super(enunciado, resposta, opcoes);
    }

    /**
     * Funcao para retornar as opcoes da pergunta antes da terceira pergunta (facil)
     * @return Array de strings com as opcoes de resposta
     */
    @Override
    public String[] getOpcoesFacil() {
        boolean temResposta = false;
        String[] substring = new String[3]; //substring que contera as 3 opcoes
        for(int i = 0; i < 3; ++i){
            substring[i] = super.opcoes[i];
            if (!temResposta & substring[i].equals(super.resposta)){ // se a resposta ja estiver entre as tres primeiras:
                temResposta = true;
            }
        }
        if(!temResposta){ //se a resposta nao estiver na substring:
            substring[1] = super.resposta; // coloca a resposta no meio
        }
        return substring;
    }

    /**
     * Funcao para retornar as opcoes da pergunta depois da terceira pergunta
     * @return Array de strings com as opcoes de resposta
     */
    @Override
    public String[] getOpcoesDificil() {
        return super.opcoes;
    }

    /**
     * Override para obter o valor/pontuacao da pergunta
     * @return pontuacao da pergunta
     */
    @Override
    public int valorPergunta() {
        return super.valorPergunta() * 10;
    }
}
