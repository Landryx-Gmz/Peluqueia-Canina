
package mypc.peluqueria.canina.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Duenio implements Serializable {
    //Atributos 
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id_duenio;
    private String nombre;
    private String tlfDueño;
    
    //Constructores
    public Duenio() {
    }

    public Duenio(int id_duenio, String nombre, String tlfDueño) {
        this.id_duenio = id_duenio;
        this.nombre = nombre;
        this.tlfDueño = tlfDueño;
    }

    //Metodos
    public int getId_duenio() {
        return id_duenio;
    }
    
    public void setId_duenio(int id_duenio) {
        this.id_duenio = id_duenio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTlfDueño() {
        return tlfDueño;
    }

    public void setTlfDueño(String tlfDueño) {
        this.tlfDueño = tlfDueño;
    }
    
    
   
}
