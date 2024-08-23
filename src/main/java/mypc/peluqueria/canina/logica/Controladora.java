package mypc.peluqueria.canina.logica;

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
    
    

    
}
