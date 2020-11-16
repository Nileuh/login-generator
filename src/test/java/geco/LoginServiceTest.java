package geco;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginServiceTest {

    private String[] loginsExistants;

    @Before
    public void setUp(){
        loginsExistants = new String[4];
        loginsExistants[0] = "Edouard";
        loginsExistants[1] = "Cecile";
        loginsExistants[2] = "Robert";
        loginsExistants[3] = "Arnaud";
    }

    @Test
    public void findAllLoginsTest(){
        //GIVEN un tableau de string comprenant Edouard Cecile Robert Arnaud
        //WHEN on instancie LoginService avec ce tableau de String
        LoginService loginService = new LoginService(loginsExistants);
        //THEN on devrait obtenir une List<String> dans l'ordre trié : Arnaud Cecile Edouard Robert
        List<String> loginsAttendus = new ArrayList<>();
        loginsAttendus.add("Arnaud");
        loginsAttendus.add("Cecile");
        loginsAttendus.add("Edouard");
        loginsAttendus.add("Robert");
        assertEquals("Le tableau de string n'est pas trié correctement", loginsAttendus, loginService.findAllLogins());
    }

    @Test
    public void loginExistsTest(){
        //GIVEN un login à rechercher
        String loginRecherche = "Edouard";
        //WHEN on instancie LoginService avec un tableau de string : Edouard Cecile Robert Arnaud
        LoginService loginService = new LoginService(loginsExistants);
        //THEN on devrait retourner true car Edouard est présent dans les logins
        assertTrue("Le login devrait être présent dans le tableau", loginService.loginExists(loginRecherche));
    }

    @Test
    public void addLoginTest(){
        //GIVEN un tableau de string comprenant Edouard Cecile Robert Arnaud
        LoginService loginService = new LoginService(loginsExistants);
        //et un login à ajouter
        String loginAjout = "Martin";
        //WHEN on ajoute loginRecherche au tableau de loginsExistants
        loginService.addLogin(loginAjout);
        //THEN on devrait avoir un tableau loginRecherche contenant loginAjout en plus
        assertTrue("Le login Martin devrait etre présent dans le tableau après un ajout", loginService.loginExists(loginAjout));
    }

    @Test
    public void findAllLoginsStartingWithTest(){
        //GIVEN à partir d'un prefixe
        LoginService loginService = new LoginService(loginsExistants);
        loginService.addLogin("Edmont");
        String prefixe="Ed";
        //WHEN on appelle findAllLoginsStartingWith avec ce prefixe en argument
        //THEN on devrait obtenir Edouard et Edmont
        List<String> loginsAttendus = new ArrayList<>();
        loginsAttendus.add("Edouard");
        loginsAttendus.add("Edmont");
        assertEquals("findAllLoginsStartingWith ne retourne pas les bons logins en fonction du prefixe", loginsAttendus, loginService.findAllLoginsStartingWith(prefixe));
    }

}
