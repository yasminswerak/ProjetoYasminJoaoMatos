/**
 * Classe publica Futebol filha de desporto
 */
public class Futebol extends Desporto{
    /**
     * Atributos String para as respostas que sao nomes (respostaNome) e para as respostas que sao numeros das camisas (respostaCamisa)
     */
    private String respostaNome, respostaCamisa;
    /**
     * Arrays que vao conter os nomes e os numeros das camisas
     */
    private String[] nomes, camisas;

    /**
     * Construtor de Desporto
     * @param enunciado Enunciado da pergunta
     * @param respostaNome Resposta nome
     * @param respostaCamisa Resposta camisa
     * @param nomes Nomes
     * @param camisas Camisas
     */
    public Futebol(String enunciado, String respostaNome, String respostaCamisa, String[] nomes, String[] camisas) {
        super(enunciado);
        this.respostaNome = respostaNome;
        this.respostaCamisa = respostaCamisa;
        this.nomes = nomes;
        this.camisas = camisas;
    }

    /**
     * Metodo Override que pega as opcoes faceis
     * @return nomes (opcoes faceis)
     */
    @Override
    public String[] getOpcoesFacil() {
        super.resposta = respostaNome;
        return nomes;
    }

    /**
     * Metodo Override que pega as opcoes dificeis
     * @return numero das camisas (opcoes dificeis)
     */
    @Override
    public String[] getOpcoesDificil() {
        super.resposta = respostaCamisa;
        return camisas;
    }
    /**
     * Override para obter o valor/pontuacao da pergunta
     * @return pontuacao da pergunta
     */
    @Override
    public int valorPergunta() {
        return super.valorPergunta() + 1;
    }
}
