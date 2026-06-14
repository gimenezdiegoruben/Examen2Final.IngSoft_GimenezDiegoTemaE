package com.ulp.examen2ingsoft_testusuario;

/**
 *
 * @author Gimenez
 */

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterUserTest {

    //test parametrizado, passwords válidas
    @ParameterizedTest
    @ValueSource(ints = {1212, 1111, 9999})
    public void testPasswords(int pass) {
        Usuario u = new Usuario("TestUser", pass);

        assertTrue(u.validarPassword(pass));
    }

    //passwords inválidas
    @ParameterizedTest
    @ValueSource(ints = {0000, 1234, 5555})
    public void testPasswordsInvalidas(int pass) {
        Usuario u = new Usuario("TestUser", 1212);

        assertFalse(u.validarPassword(pass));
    }
}