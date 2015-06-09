/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;
import java.io.Serializable;//pasra los datos de una clase a un archivo; de objeto a archivos
import javax.persistence.*;

/**
 *
 * @author EST1659109
 */
//@ acciones que se van a ejecutar antes, de acuerdo al tipo de comentario

@Entity// tratar a la clase como una entidad
public class Usuario implements Serializable{
    @Id//notacion que indica que se debe tratar como identificador de la tabla
    private int id;
    
    private String nombre;
    private String apellido;
    private int edad;

    public Usuario() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    @Override//redefinicion de un metodo
    public String toString(){
        return "usuario "+nombre+" "+apellido;
    }
}
        