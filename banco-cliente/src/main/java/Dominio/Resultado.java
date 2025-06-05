package Dominio;

public class Resultado {
    private String codigo;
    private String mensaje;
    private String referencia;

    public Resultado(){}

    public Resultado(String referencia, String codigo, String mensaje) {
        this.referencia = referencia;
        this.codigo = codigo;
        this.mensaje = mensaje;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }
    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }
    public String getReferencia() { return referencia; }
    public void setReferencia(String referencia) { this.referencia = referencia; }
}
