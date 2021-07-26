package cs.lab;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class Aplicacion {
    static final Logger logger = Logger.getLogger(Aplicacion.class.getName());
    Scanner in = new Scanner(System.in);
    private static Aplicacion instance;
    boolean loggedIn = false;
    ArrayList<Usuario> usuarios = new ArrayList<>();
    ArrayList<Centro> centros = new ArrayList<>();

    private Aplicacion(){

    }

    static Aplicacion getInstance(){
        if(instance == null){
            instance = new Aplicacion();
        }
        return instance;
    }

    void addUser(Usuario u){
        usuarios.add(u);
    }

    void addCentro(Centro c) {
        centros.add(c);
    }

    void loginUser(String u, String c){
        for(Usuario usuario : usuarios){
            var input = new StringBuilder();
            input.append(u);
            input.reverse();
            if(usuario.username == u && input.toString() == c){
                loggedIn = true;
                break;
            }
        }
    }

    void generalInfo(){
        long personasV = 0;
        long personasPV = 0;
        String texto = "Numero de Centros de vacunación: " + centros.size();
        logger.log(Level.INFO, texto);

        for(Centro centro : centros){
            if(centro.operando) {
                personasV = personasV + centro.personasV.size();
                personasPV = personasPV + centro.personasPv.size();
            }
        }

        texto = "Numero de Personas vacunadas parcialmente: " + personasPV;
        logger.log(Level.INFO, texto);

        texto = "Numero de Personas vacunadas completamente: " + personasV;
        logger.log(Level.INFO, texto);

        texto = "Avance de la Vacunación: " + personasPV/22935533 + "%";
        logger.log(Level.INFO, texto);

        texto = "Cobertura de la Vacunación: " + personasV/22935533 + "%";
        logger.log(Level.INFO, texto);
    }

    void darAlta(){
        String texto = "Nombre de centro:\n ";
        logger.log(Level.INFO, texto);
        String c = in.nextLine();
        for(Centro centro : centros){
            if(c.equals(centro.name)){
                centro.operando = true;
                texto = "Centro se dio de alta\n ";
                logger.log(Level.INFO, texto);
                return;
            }
        }
        texto = "Centro no se dio de alta, no existe\n ";
        logger.log(Level.INFO, texto);
    }

    void darBaja(){
        String texto = "Nombre de centro:\n ";
        logger.log(Level.INFO, texto);
        String c = in.nextLine();
        for(Centro centro : centros){
            if(c.equals(centro.name)){
                centro.operando = false;
                texto = "Centro se dio de baja\n ";
                logger.log(Level.INFO, texto);
                return;
            }
        }
        texto = "Centro no se dio de baja, no existe\n ";
        logger.log(Level.INFO, texto);
    }

    void startApp(){
        String texto = "Usuario: \n";
        logger.log(Level.INFO, texto);
        String u = in.nextLine();
        texto = "Contraseña: \n";
        logger.log(Level.INFO, texto);
        String c = in.nextLine();
        loginUser(u,c);
        while (loggedIn) {
            texto = "Si desea ver informacion general inserte 1\n" +
                    "Si desea dar de Alta un centro inserte 2\n" +
                    "Si desea dar de Baja un centro inserte 3\n" +
                    "Si desea cerrar sesión inserte 4\n";
            logger.log(Level.INFO, texto);
            String r = in.nextLine();
            switch (r) {
                case "4" -> {
                    loggedIn = false;
                    texto = "Se cerro la sesión\n";
                    logger.log(Level.INFO, texto);
                    return;
                }
                case "1" -> generalInfo();
                case "2" -> darAlta();
                case "3" -> darBaja();
            }

        }
    }


}
