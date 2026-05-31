package main.java;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SistemaIncidentesRefactorizado {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        List<AgenteSoporte> agentes = Arrays.asList(
                new AgenteSoporte("Andre Rockstar",  NivelTecnico.JUNIOR,      0.0),
                new AgenteSoporte("Ramon Boyer",     NivelTecnico.SEMI_SENIOR, 2.0),
                new AgenteSoporte("Pepe",            NivelTecnico.SENIOR,      5.0)
        );

        MotorAsignacion motor = new MotorAsignacion(agentes);

        System.out.println("*** SISTEMA DE GESTIÓN DE TICKETS ***");

        boolean activo = true;
        while (activo) {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Registrar y asignar ticket");
            System.out.println("2. Ver reporte y salir");
            System.out.print("Opción: ");

            try {
                int opcion = teclado.nextInt();
                teclado.nextLine();

                if (opcion == 1) {
                    System.out.print("Descripción del problema: ");
                    String desc = teclado.nextLine();

                    System.out.print("Impacto operativo (1-5): ");
                    int impacto = teclado.nextInt();

                    System.out.print("Gravedad técnica (1-5): ");
                    int gravedad = teclado.nextInt();
                    teclado.nextLine();

                    TicketIncidente ticket = new TicketIncidente(desc, impacto, gravedad);
                    AgenteSoporte asignado = motor.asignar(ticket);
                    asignado.asignarTicket(ticket.getPrioridad());

                    System.out.printf("[OK] Prioridad: %.1f | Asignado a: %s%n",
                            ticket.getPrioridad(), asignado.getNombre());

                } else if (opcion == 2) {
                    activo = false;
                } else {
                    System.out.println("Opción inválida.");
                }

            } catch (ParametroIncidenteInvalidoException e) {
                System.out.println(e.getMessage());
            } catch (java.util.InputMismatchException e) {
                System.out.println("[ERROR] Ingrese un número válido.");
                teclado.nextLine();
            }
        }

        System.out.println("\n=== REPORTE FINAL ===");
        agentes.forEach(a -> System.out.printf("%-20s -> Carga: %.1f%n",
                a.getNombre(), a.getCargaAcumulada()));
        teclado.close();
    }
}
