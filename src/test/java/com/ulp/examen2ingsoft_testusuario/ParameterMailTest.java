package com.ulp.examen2ingsoft_testusuario;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class ParameterMailTest {

    Usuario usuario = new Usuario();

    @ParameterizedTest
    @ValueSource(strings = {
        "juanjo@ulp.edu.ar",
        "test@gmail.com",
        "alumno@universidad.com"
    })
    public void testEmailsValidos(String email) {

        assertTrue(usuario.validarEmail(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "juanjoulp.edu.ar",
        "testgmailcom",
        "alumno@.com"
    })
    public void testEmailsInvalidos(String email) {

        assertFalse(usuario.validarEmail(email));
    }
}