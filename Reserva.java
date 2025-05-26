class Reserva {
    private Habitacion habitacion;
    private String cliente;
    private String fechaReserva;

    public Reserva(Habitacion habitacion, String cliente, String fechaReserva) throws Exception {
        this.habitacion = habitacion;
        this.cliente = cliente;
        this.fechaReserva = fechaReserva;
        habitacion.reservar();
    }

    public String getCliente() {
        return cliente;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public String toString() {
        return "Reserva: Cliente " + cliente + ", Fecha " + fechaReserva + ", " + habitacion;
    }
}