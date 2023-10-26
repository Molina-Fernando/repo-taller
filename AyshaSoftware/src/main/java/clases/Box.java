
package clases;


/**
 * La clase Box representa una sala de atención médica.
 * Cada sala tiene un número y un estado de disponibilidad.
 */
public class Box {
    private boolean disponible; // Indica si la sala está disponible
    private int numero; // El número de la sala
    private Datos dato; // Los datos asociados a la sala

    /**
     * Constructor para la clase Box.
     * @param disponible El estado inicial de disponibilidad de la sala.
     * @param numero El número de la sala.
     */
    public Box(boolean disponible, int numero) {
        setDisponible(disponible);
        setNumero(numero);
    }

    /**
     * Devuelve el estado de disponibilidad de la sala.
     * @return true si la sala está disponible, false en caso contrario.
     */
    public boolean isDisponible() {
        return disponible;
    }

    /**
     * Devuelve el número de la sala.
     * @return El número de la sala.
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Establece el estado de disponibilidad de la sala.
     * @param disponible El nuevo estado de disponibilidad.
     */
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    /**
     * Establece el número de la sala.
     * @param numero El nuevo número de la sala.
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     * Establece los datos asociados a la sala.
     * @param dato Los nuevos datos a asociar a la sala.
     */
    public void setDato(Datos dato) {
        this.dato = dato;
    }
}

