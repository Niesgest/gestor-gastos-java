package Registro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


record Gasto(String descripcion, double monto) {}

public class GastosRegistro {
    public static void main(String[] args) {
        var consola = new Scanner(System.in);
        List<Gasto> listaGasto = new ArrayList<>();
        var total = 0.0;
        var opcion = 0;

        System.out.print("Por favor, marque un presupuesto límite: ");
        var presupuesto = Double.parseDouble(consola.nextLine());

        while (opcion != 3) {
            System.out.print("""
                    \n---- GESTOR DE GASTOS ----
                    1. Registrar nuevo gasto
                    2. Ver historial y total de gastos
                    3. Salir
                    Elige una opción:\s""");
            opcion = Integer.parseInt(consola.nextLine());

            switch (opcion) {
                case 1 -> {
                    if (total >= presupuesto) {
                        System.out.println("Presupuesto límite alcanzado. Le recomendamos revisar sus gastos.");
                    } else {
                        System.out.print("Describa el nuevo gasto: ");
                        var desc = consola.nextLine();
                        System.out.print("Ingrese el monto: ");
                        var monto = Double.parseDouble(consola.nextLine());

                        listaGasto.add(new Gasto(desc, monto));
                        total += monto;
                        System.out.printf("Nuevo gasto agregado: %s - S/%.2f%n", desc, monto);
                    }
                }
                case 2 -> {
                    System.out.println("\n--- Historial de Gastos ---");
                    if (listaGasto.isEmpty()) {
                        System.out.println("\tNo hay gastos registrados aún.");
                    } else {
                        for (var g : listaGasto) {
                            System.out.printf("\t- %s: S/%.2f%n", g.descripcion(), g.monto());
                        }
                    }
                    System.out.printf("Gasto total: S/%.2f de S/%.2f presupuestados.%n", total, presupuesto);
                }
                case 3 -> System.out.println("Finalizando proceso...");
                default -> System.out.println("Opción incorrecta. Intente nuevamente.");
            }
        }
        consola.close();
    }
}


