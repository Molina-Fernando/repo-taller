package main;

import ventanas.Login;

/**
 * Clase principal que inicia la aplicación y muestra la ventana de inicio de
 * sesión.
 */
public class Principal {

    /**
     * Método principal que inicia la aplicación creando una instancia de la
     * ventana de inicio de sesión y la hace visible.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en
     * este caso).
     */
    public static void main(String[] args) {
        new Login().setVisible(true);
    }

}
