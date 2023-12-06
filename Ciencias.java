/**
 * Classe Ciencias filha de Pergunta
 */
public class Ciencias extends Pergunta{
    /**
     * Arrays opcoesFaceis e opcoesDificeis de Strings
     */
    private String[] opcoesFaceis, opcoesDificeis;

    /**
     * Construtor de Ciencias
     * @param enunciado Enunciado da pergunta
     * @param resposta Resposta da pergunta
     * @param opcoesFaceis Opcoes faceis
     * @param opcoesDificeis Opcoes dificeis
     */
    public Ciencias(String enunciado, String resposta, String[] opcoesFaceis, String[] opcoesDificeis) {
        super(enunciado, resposta);
        this.opcoesFaceis = opcoesFaceis;
        this.opcoesDificeis = opcoesDificeis;
    }

    /**
     * Metodo Override que pega as opcoes faceis da pergunta
     * @return Opcoes faceis
     */
    @Override
    public String[] getOpcoesFacil() {
        return opcoesFaceis;
    }

    /**
     * Metodo Override que pega as opcoes dificeis da pergunta
     * @return Opcoes faceis
     */
    @Override
    public String[] getOpcoesDificil() {
        return opcoesDificeis;
    }

    /**
     * Metodo Override para calcular o valor/pontos ganhos na pergunta
     * @return pontuacao da pergunta
     */
    @Override
    public int valorPergunta() {
        return super.valorPergunta() + 5;
    }
}
