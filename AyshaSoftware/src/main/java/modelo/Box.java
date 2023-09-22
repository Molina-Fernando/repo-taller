
package modelo;


public class Box {

    private boolean disponible;
    private int numero;
    private Datos dato;

    public Box(boolean disponible, int numero) {
        setDisponible(disponible);
        setNumero(numero);
    }


    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    //este debe ser llamado segundo para guardar la instancia de datos 
    public void setDato(Datos dato) {
        this.dato = dato;
    }
    
}
