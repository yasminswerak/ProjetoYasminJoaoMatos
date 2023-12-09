import java.io.Serializable;

/**
 * Classe abstrata Pergunta que implementa Serializable
 */
public abstract class Pergunta implements Serializable {
    //atributos:
    /**
     * Atributos String enunciado e resposta
     */
    protected String enunciado, resposta;
    /**
     * Atributo int pontos
     */
    protected int pontos;
    /**
     * Atributo array opcoes
     */
    protected String[] opcoes;

    //construtores:
    /**
     * Contrutor vazio de Pergunta
     */
    public Pergunta() {}

    /**
     * Construtor de Pergunta
     * @param enunciado Enunciado da pergunta
     */
    public Pergunta(String enunciado) {
        this.enunciado = enunciado;
        this.pontos = 5;
    }

    /**
     * Construtor de Pergunta
     * @param enunciado Enunciado da pergunta
     * @param resposta Resposta da pergunta
     * @param opcoes Opcoes
     */
    public Pergunta(String enunciado, String resposta, String[] opcoes) {
        this.enunciado = enunciado;
        this.pontos = 5;
        this.resposta = resposta;
        this.opcoes = opcoes;
    }

    /**
     * Construor de Pergunta
     * @param enunciado enunciado da pergunta
     * @param resposta resposta da pergunta
     */
    public Pergunta(String enunciado, String resposta) {
        this.enunciado = enunciado;
        this.pontos = 5;
        this.resposta = resposta;
    }

    //getters e setters:

    /**
     * Getter de Enunciado
     * @return Enunciado
     */
    public String getEnunciado() {
        return enunciado;
    }

    /**
     * Setter de Enunciado
     * @param enunciado Enunciado
     */
    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    /**
     * Getter de Resposta
     * @return Resposta
     */
    public String getResposta() {
        return resposta;
    }

    /**
     * Setter de Resposta
     * @param resposta Resposta
     */
    public void setResposta(String resposta) {
        this.resposta = resposta;
    }

    //Metodos
    /**
     * Funcao abstrata
     * @return opcoes de perguntas faceis
     */
    public abstract String[] getOpcoesFacil();

    /**
     * Funcao abstrata
     * @return opcoes de perguntas dificeis
     */
    public abstract String[] getOpcoesDificil();

    /**
     * Funcao que determina o valor de cada pergunta
     * @return valor base da pergunta (5)
     */
    public int valorPergunta(){
        return pontos; //Valor basico da pergunta
    }
}
