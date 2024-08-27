package mypc.peluqueria.canina.persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import mypc.peluqueria.canina.logica.Duenio;
import mypc.peluqueria.canina.logica.Mascota;
import mypc.peluqueria.canina.persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {
    
    DuenioJpaController duenioJpa = new DuenioJpaController();
    MascotaJpaController mascotaJpa = new MascotaJpaController();

    public void guardar(Duenio duenio, Mascota masco) {
        
       //Crear en BD el duenño
       duenioJpa.create(duenio);
       
       //Crear en la BD la mascota
       mascotaJpa.create(masco);
    }

    public List<Mascota> traerMascotas() {
        return mascotaJpa.findMascotaEntities();
    }

    public void borrarMascota(int num_cliente) {
        try {
            mascotaJpa.destroy(num_cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
