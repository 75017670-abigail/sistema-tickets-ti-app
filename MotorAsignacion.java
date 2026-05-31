package main.java;

import java.util.Comparator;
import java.util.List;

public class MotorAsignacion {

    private final List<AgenteSoporte> agentes;

    public MotorAsignacion(List<AgenteSoporte> agentes) {
        this.agentes = agentes;
    }

    public AgenteSoporte asignar(TicketIncidente ticket) {
        return agentes.stream()
                .filter(a -> a.puedeAtender(ticket.getNivelRequerido()))
                .min(Comparator.comparingDouble(AgenteSoporte::getCargaAcumulada))
                .orElseThrow(() -> new IllegalStateException(
                        "No hay agentes disponibles para el nivel requerido."));
    }
}
