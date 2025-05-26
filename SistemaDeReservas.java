import java.util.List;
import java.util.Scanner;

// Clase principal para probar la funcionalidad y proporcionar un punto de entrada al sistema
public class SistemaDeReservas {

    public static void main(String[] args) {
        // Crear un hotel nuevo
        Hotel hotel = new Hotel();
        
        // Agregar habitaciones al hotel
        hotel.agregarHabitacion(new Habitacion(101));
        hotel.agregarHabitacion(new Habitacion(102));
        hotel.agregarHabitacion(new Habitacion(103));

        // Crear un escáner para la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        // Ciclo para el menú principal de la aplicación
        while (!salir) {
            System.out.println("Bienvenido al sistema de reservas del hotel.");
            System.out.println("1. Consultar habitaciones disponibles");
            System.out.println("2. Crear una nueva reserva");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            // Lee la opción ingresada por el usuario
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    // Listar habitaciones disponibles
                    System.out.println("Habitaciones disponibles:");
                    List<Habitacion> disponibles = hotel.getHabitacionesDisponibles();
                    for (Habitacion hab : disponibles) {
                        System.out.println("Habitación " + hab.getNumero());
                    }
                    if (disponibles.isEmpty()) {
                        System.out.println("No hay habitaciones disponibles.");
                    }
                    break;

                case 2:
                    // Crear una nueva reserva
                    try {
                        System.out.print("Ingrese el número de habitación a reservar: ");
                        int numeroHabitacion = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer

                        // Verificar disponibilidad
                        Habitacion habitacionSeleccionada = null;
                        for (Habitacion hab : hotel.getHabitacionesDisponibles()) {
                            if (hab.getNumero() == numeroHabitacion) {
                                habitacionSeleccionada = hab;
                                break;
                            }
                        }

                        if (habitacionSeleccionada != null) {
                            // Pedir datos del cliente
                            System.out.print("Ingrese el nombre del cliente: ");
                            String cliente = scanner.nextLine();
                            System.out.print("Ingrese la fecha de la reserva (YYYY-MM-DD): ");
                            String fecha = scanner.nextLine();

                            // Crear y confirmar la reserva
                            Reserva reserva = new Reserva(habitacionSeleccionada, cliente, fecha);
                            System.out.println("Reserva creada exitosamente para la habitación " +
                                    reserva.getHabitacion().getNumero() +
                                    " a nombre de " + reserva.getCliente() +
                                    " para la fecha " + reserva.getFechaReserva());
                        } else {
                            System.out.println("La habitación no está disponible o no existe.");
                        }
                    } catch (Exception e) {
                        System.out.println("Error al crear la reserva: " + e.getMessage());
                    }
                    break;

                case 3:
                    // Salir de la aplicación
                    salir = true;
                    System.out.println("Gracias por usar el sistema de reservas del hotel.");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }

        // Cerrar el escáner
        scanner.close();
    }
}