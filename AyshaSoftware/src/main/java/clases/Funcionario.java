/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author joaqu
 */
import clases.Persona;
import clases.Rol;
import java.util.ArrayList;

public abstract class Funcionario extends Persona {

    private String usuario;
    private String contrasenia;
    private ArrayList<Rol> roles;

}