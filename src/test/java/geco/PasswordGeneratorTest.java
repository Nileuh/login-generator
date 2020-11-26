package geco;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PasswordGeneratorTest {

    @Test
    public void Test1(){
        //GIVEN on souhaite générer un mot de passe aléatoire
        //WHEN on instancie PasswordGenerator
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String motDePasseGeneré = passwordGenerator.generate();
        //THEN on devrait avoir un mot de passe généré
        assertNotNull("Il n'y a pas de mot de passe généré", motDePasseGeneré);
    }


}
