
package test;

import com.mycompany.domain.Persona;
import javax.persistence.*;
import org.apache.logging.log4j.*;

public class ClienteEntidadPersona {
    static Logger log = LogManager.getRootLogger();
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersonaPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        //Inicia la transaccion
        tx.begin();
        //No se debe especificar el ID de la base de datos
        Persona persona = new Persona("Maria", "Petra", "ja.mail.com", "48948516321");
        log.debug("Objeto a persistir:" + persona);
        //Persistimos el objeto
        em.persist(persona);
        //Terminamos la transaccion
        //Hacemos un commit para guardar cambios
        tx.commit();
        log.debug("Objeto persistido" + persona);
        em.close();
    }
}
