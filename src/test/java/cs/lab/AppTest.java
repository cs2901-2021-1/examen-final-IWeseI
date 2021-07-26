package cs.lab;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.logging.Logger;

public class AppTest {
    @Test
    public void test00() throws IOException {

        Usuario user = new Usuario("juan");

        Centro centro1 = new Centro("centro1");
        Centro centro2 = new Centro("centro2");
        Centro centro3 = new Centro("centro3");

        Persona persona1 = new Persona("Juan", 19);
        Persona persona2 = new Persona("Pablo", 25);
        Persona persona3 = new Persona("Alexander", 60);
        Persona persona4 = new Persona("Mateo", 50);
        Persona persona5 = new Persona("Julio", 33);
        Persona persona6 = new Persona("Roberto", 20);
        Persona persona7 = new Persona("David", 70);
        Persona persona8 = new Persona("Jesus", 23);
        Persona persona9 = new Persona("Luis", 51);
        Persona persona10 = new Persona("Ignacio", 60);

        //Una persona completamente vacunada tambien esta parcialmente vacunada

        centro1.addPersonaParcialmenteVacunada(persona1);
        centro1.addPersonaParcialmenteVacunada(persona2);
        centro1.addPersonaParcialmenteVacunada(persona3);
        centro1.addPersonaVacunada(persona2);

        centro2.addPersonaParcialmenteVacunada(persona4);
        centro2.addPersonaParcialmenteVacunada(persona5);
        centro2.addPersonaParcialmenteVacunada(persona6);
        centro2.addPersonaVacunada(persona5);
        centro2.addPersonaVacunada(persona6);

        centro3.addPersonaParcialmenteVacunada(persona7);
        centro3.addPersonaParcialmenteVacunada(persona10);
        centro3.addPersonaParcialmenteVacunada(persona8);
        centro3.addPersonaParcialmenteVacunada(persona9);
        centro3.addPersonaVacunada(persona8);
        centro3.addPersonaVacunada(persona9);

        Aplicacion app = Aplicacion.getInstance();
        app.addUser(user);
        app.addCentro(centro1);app.addCentro(centro2);app.addCentro(centro3);

        app.loginUser("juan", "nauj");

        app.darAlta("centro1");
        app.darAlta("centro2");
        app.darAlta("centro3");
        app.darAlta("centro4");

        app.generalInfo();

        app.darBaja("centro1");
        app.darBaja("centro2");
        app.darBaja("centro3");
        app.darBaja("centro4");

        app.generalInfo();
    }
}