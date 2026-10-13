import java.util.ArrayList;
import java.util.Scanner;
 
public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Persona> personas = new ArrayList<>();

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Elige una opción: ");

            switch (opcion) {
                case 1:
                    registrarEstudiante();
                    break;
                case 2:
                    registrarProfesor();
                    break;
                case 3:
                    mostrarTodos();
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);

        sc.close();
    }

    static void mostrarMenu() {
        System.out.println("\n=============================");
        System.out.println("   GESTIÓN DE PERSONAS");
        System.out.println("=============================");
        System.out.println("1. Registrar estudiante");
        System.out.println("2. Registrar profesor");
        System.out.println("3. Mostrar todos");
        System.out.println("4. Salir");
    }

    static void registrarEstudiante() {
        System.out.println("\n--- Nuevo estudiante ---");
        String nombre = leerTexto("Nombre: ");
        int edad = leerEntero("Edad: ");
        String documento = leerTexto("Documento: ");
        String programa = leerTexto("Programa: ");
        double promedio = leerDouble("Promedio (0.0 - 5.0): ");

        while (promedio < 0 || promedio > 5) {
            System.out.println("El promedio debe estar entre 0.0 y 5.0.");
            promedio = leerDouble("Promedio (0.0 - 5.0): ");
        }

        personas.add(new Estudiante(nombre, edad, documento, programa, promedio));
        System.out.println("Estudiante registrado.");
    }

    static void registrarProfesor() {
        System.out.println("\n--- Nuevo profesor ---");
        String nombre = leerTexto("Nombre: ");
        int edad = leerEntero("Edad: ");
        String documento = leerTexto("Documento: ");
        String area = leerTexto("Área: ");
        double salarioBase = leerDouble("Salario base: ");
        int horas = leerEntero("Horas cátedra: ");

        personas.add(new Profesor(nombre, edad, documento, area, salarioBase, horas));
        System.out.println("Profesor registrado.");
    }

    static void mostrarTodos() {
        if (personas.isEmpty()) {
            System.out.println("\nNo hay personas registradas.");
            return;
        }
        System.out.println("\n=== LISTADO ===");
        for (Persona p : personas) {
            System.out.println("Rol:       " + p.getRol());
            p.mostrarInfo();
            System.out.println("-----------------------------");
        }
    }

    // ---------- Métodos auxiliares de lectura ----------

    static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }

    static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debes escribir un número entero.");
            }
        }
    }

    static double leerDouble(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debes escribir un número válido.");
            }
        }
    }
}