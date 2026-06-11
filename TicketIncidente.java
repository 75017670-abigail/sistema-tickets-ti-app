
package main.java;

public final class TicketIncidente {

    private final String descripcion;
    private final int impacto;
    private final int gravedad;
    private final double prioridad;
    private final NivelTecnico nivelRequerido;

    public TicketIncidente(String descripcion, int impacto, int gravedad) {
        validarParametro("impacto", impacto);
        validarParametro("gravedad", gravedad);
        this.descripcion = descripcion;
        this.impacto = impacto;
        this.gravedad = gravedad;
        this.prioridad = evaluarHeuristica(impacto, gravedad);
        this.nivelRequerido = determinarFiltroNivel(this.prioridad);
    }

    private double evaluarHeuristica(int impacto, int gravedad) {
        return (impacto * 0.6) + (gravedad * 0.4);
    }

    private NivelTecnico determinarFiltroNivel(double prioridad) {
        if (prioridad >= 4.0) return NivelTecnico.SENIOR;
        if (prioridad >= 2.5) return NivelTecnico.SEMI_SENIOR;
        return NivelTecnico.JUNIOR;
    }

    private void validarParametro(String campo, int valor) {
        if (valor < 1 || valor > 5) {
            throw new ParametroIncidenteInvalidoException(campo, valor);
        }
    }

    public String getDescripcion()          { return descripcion; }
    public double getPrioridad()            { return prioridad; }
    public NivelTecnico getNivelRequerido() { return nivelRequerido; }
}
// FEATURE: Validacion de tickets - Jose Luis Chambilla
