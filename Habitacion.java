class Habitacion {
    private int numero;
    private boolean disponible;

    public Habitacion(int numero) {
        this.numero = numero;
        this.disponible = true;
    }

    public int getNumero() {
        return numero;
    }

    public boolean estaDisponible() {
        return disponible;
    }

    public void reservar() throws Exception {
        if (!disponible) {
            throw new Exception("La habitación ya está reservada.");
        }
        this.disponible = false;
    }

    public void liberar() {
        this.disponible = true;
    }

    public String toString() {
        return "Habitación " + numero + " (Disponible: " + disponible + ")";
    }
}