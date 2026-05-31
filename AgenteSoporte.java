package main.java;

public class AgenteSoporte {

    private final String nombre;
    private final NivelTecnico nivel;
    private double cargaAcumulada;

    public AgenteSoporte(String nombre, NivelTecnico nivel, double cargaInicial) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.cargaAcumulada = cargaInicial;
    }

    public boolean puedeAtender(NivelTecnico nivelRequerido) {
        return this.nivel.getJerarquia() >= nivelRequerido.getJerarquia();
    }

    public void asignarTicket(double prioridad) {
        this.cargaAcumulada += prioridad;
    }

    public String getNombre()          { return nombre; }
    public NivelTecnico getNivel()     { return nivel; }
    public double getCargaAcumulada()  { return cargaAcumulada; }
}
