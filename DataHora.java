/**
 * Classe publica DataHora
 */
public class DataHora {
    //atributos:
    /**
     * Atributos int de dia, mes e ano
     */
    private int dia, mes, ano;

    /**
     * Atributos int de hora e minuto
     */
    private int hora, minuto;

    //construtores:

    /**
     * Construtor vazio de DataHora
     */
    public DataHora(){}

    /**
     * Construtor de DataHora
     * @param dia Dia
     * @param mes Mes
     * @param ano Ano
     * @param hora Hora
     * @param minuto Minuto
     */
    public DataHora(int dia, int mes, int ano, int hora, int minuto) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.hora = hora;
        this.minuto = minuto;
    }

    //getters e setters:

    /**
     * Getter de Dia
     * @return Dia
     */
    public int getDia() {
        return dia;
    }

    /**
     * Setter de Dia
     * @param dia Dia
     */
    public void setDia(int dia) {
        this.dia = dia;
    }

    /**
     * Getter de Mes
     * @return Mes
     */
    public int getMes() {
        return mes;
    }

    /**
     * Setter de Mes
     * @param mes Mes
     */
    public void setMes(int mes) {
        this.mes = mes;
    }

    /**
     * Getter de Ano
     * @return Ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * Setter de Ano
     * @param ano Ano
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * Getter de Hora
     * @return Hora
     */
    public int getHora() {
        return hora;
    }

    /**
     * Setter de Hora
     * @param hora Hora
     */
    public void setHora(int hora) {
        this.hora = hora;
    }

    /**
     * Getter de Minuto
     * @return Minuto
     */
    public int getMinuto() {
        return minuto;
    }

    /**
     * Setter de Minuto
     * @param minuto Minuto
     */
    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }
}

