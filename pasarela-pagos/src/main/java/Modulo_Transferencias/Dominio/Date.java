package main.java.Modulo_Transferencias.Dominio;

public class Date {
    private int dia;
    private int mes;
    private int ano;

    public Date(int ano, int dia, int mes) {
        this.ano = ano;
        this.dia = dia;
        this.mes = mes;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }
}
