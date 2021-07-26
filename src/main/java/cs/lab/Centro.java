package cs.lab;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Centro {
    String name;

    Boolean operando = false;

    ArrayList<Persona> personasPv = new ArrayList<>();
    ArrayList<Persona> personasV = new ArrayList<>();


    public Centro(String n){
        name = n;
    }

    void addPersonaVacunada(Persona p){
        personasV.add(p);
        String notificacion = "Felicidades, " + p.name + " usted ha sido completamente vacunado.";
        final Logger logger = Logger.getLogger(Aplicacion.class.getName());
        logger.log(Level.INFO, notificacion);
    }

    void addPersonaParcialmenteVacunada(Persona p){
        personasPv.add(p);
        String notificacion = "Felicidades, " + p.name + " usted ha sido parcialmente vacunado.";
        final Logger logger = Logger.getLogger(Aplicacion.class.getName());
        logger.log(Level.INFO, notificacion);

    }

}
