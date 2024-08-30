package mypc.peluqueria.canina.logica;

import java.util.List;
import mypc.peluqueria.canina.persistencia.ControladoraPersistencia;

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color, String observaciones,
            String alergico, String atenEsp, String nombreDuenio, String tlfDuenio) {
      
        //Creamos dueño y asignamos sus valores
        Duenio duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setTlfDueño(tlfDuenio);
        
        //Creamos las mascotas y asignamos sus valores         
        Mascota masco = new Mascota();
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atenEsp);
        masco.setObservaciones(observaciones);
        masco.setUnDuenio(duenio);//Utilizamos la variable creada en la instancia para asociar la mascota con el dueño.
        
        controlPersis.guardar(duenio,masco);
        
    }

    public List<Mascota> traerMascotas() {
        return controlPersis.traerMascotas();
    }

    public void borrarMascota(int num_cliente) {
        controlPersis.borrarMascota (num_cliente);
    }

    public Mascota traerMascota(int num_cliente) {
        return controlPersis.traerMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco, String nombreMasco, String raza, String color,
            String observaciones, String alergico, String atenEsp, String nombreDuenio, String tlfDuenio) {
        //asignamos nuestros cambios o edicion al anterior contructor
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAlergico(alergico);
        masco.setAtencion_especial(atenEsp);
        
        
        //Para guardar los datos del dueño creamos un metodo en la controladora de la logica mediate los datos de la mascota        
        controlPersis.modificarMascota(masco);
        
        //identificamos el dueño creando un metodo en la controladora de persistencia y seteo de nuevos valores del dueño.
        Duenio dueno= this.buscarDuenio(masco.getUnDuenio().getId_duenio());
        dueno.setNombre(nombreDuenio);
        dueno.setTlfDueño(tlfDuenio);
        
        //Llamar al modificar Dueño.
        this.modificarDuenio(dueno);
             
       
    }

    private Duenio buscarDuenio(int id_duenio) {
        return controlPersis.trearDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio dueno) {
        controlPersis.modificarDuenio(dueno);
    }
    
    

    
}
