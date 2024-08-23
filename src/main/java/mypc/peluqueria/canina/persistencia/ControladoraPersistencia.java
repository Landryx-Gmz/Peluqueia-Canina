package mypc.peluqueria.canina.persistencia;

import mypc.peluqueria.canina.logica.Duenio;
import mypc.peluqueria.canina.logica.Mascota;

public class ControladoraPersistencia {
    
    DuenioJpaController duenioJpa = new DuenioJpaController();
    MascotaJpaController mascotaJpa = new MascotaJpaController();

    public void guardar(Duenio duenio, Mascota masco) {
        
       //Crear en BD el duenño
       duenioJpa.create(duenio);
       
       //Crear en la BD la mascota
       mascotaJpa.create(masco);
    }
    
}
