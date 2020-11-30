package geco;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class LoginGeneratorTest {

    private LoginService loginService;
    private LoginGenerator loginGenerator;

    @Before
    public void setUp(){
        loginService = new LoginService (new String [] {"JROL","BPER", "CGUR", "JDU", "JRAL", "JRAL1"});
        loginGenerator = new LoginGenerator(loginService);
    }



    @Test
    public void CT1(){
        //GIVEN un prénom et un nom
        String prenom ="Paul";
        String nom = "Durand";
        //WHEN on génère un login Paul Durand
        //THEN on devrait avoir PDUR
        assertEquals("Mauvaise génération de login", "PDUR", loginGenerator.generateLoginForNomAndPrenom(nom, prenom));
    }

    @Test
    public void CT2(){
        //GIVEN un prénom et un nom
        String prenom ="John";
        String nom = "Ralling";
        //WHEN on génère un login
        //THEN on devrait avoir JRAL2
        assertEquals("Mauvaise génération de login", "JRAL2", loginGenerator.generateLoginForNomAndPrenom(nom, prenom));

    }

    @Test
    public void CT3(){
        //GIVEN un prénom et un nom
        String prenom ="Jean";
        String nom = "Rolling";
        //WHEN on génère un login
        //THEN on devrait avoir JROL1
        assertEquals("Mauvaise génération de login", "JROL1", loginGenerator.generateLoginForNomAndPrenom(nom, prenom));
    }

    @Test
    public void CT4(){
        //GIVEN un prénom et un nom
        String prenom ="Paul";
        String nom = "Durand";
        //WHEN on génère un login
        //THEN on devrait avoir PDUR
        assertEquals("Mauvaise génération de login", "PDUR", loginGenerator.generateLoginForNomAndPrenom(nom, prenom));
    }

    @Test
    public void CT5(){
        //GIVEN un prénom et un nom
        String prenom ="Paul";
        String nom = "Du";
        //WHEN on génère un login
        //THEN on devrait avoir PDU
        assertEquals("Mauvaise génération de login", "PDU", loginGenerator.generateLoginForNomAndPrenom(nom, prenom));
    }
}
