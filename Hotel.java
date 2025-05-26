import java.util.ArrayList;
import java.util.List;

class Hotel {
    private List<Habitacion> habitaciones;

    public Hotel() {
        this.habitaciones = new ArrayList<>();
    }

    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    public List<Habitacion> getHabitacionesDisponibles() {
        List<Habitacion> disponibles = new ArrayList<>();
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.estaDisponible()) {
                disponibles.add(habitacion);
            }
        }
        return disponibles;
    }
}
