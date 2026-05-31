package main.java;

public class ParametroIncidenteInvalidoException extends RuntimeException {

    private final String campo;
    private final int valorRecibido;

    public ParametroIncidenteInvalidoException(String campo, int valorRecibido) {
        super(String.format(
                "[ERROR DE VALIDACIÓN] El campo '%s' recibió el valor '%d'. " +
                        "Solo se aceptan valores entre 1 y 5.", campo, valorRecibido));
        this.campo = campo;
        this.valorRecibido = valorRecibido;
    }

    public String getCampo() { return campo; }
    public int getValorRecibido() { return valorRecibido; }
}
