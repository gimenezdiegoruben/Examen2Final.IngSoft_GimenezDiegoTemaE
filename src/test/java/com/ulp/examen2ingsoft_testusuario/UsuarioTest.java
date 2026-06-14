package com.ulp.examen2ingsoft_testusuario;

/**
 *
 * @author Gimenez
 */

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UsuarioTest {

    static Usuario usr;
    static int i = 0;

    @BeforeAll
    public static void antesDeTodo() {
        usr = new Usuario("Juanjo", 1212);
        System.out.println("TEST de usuario");
    }

    @AfterAll
    public static void despuesDeTodo() {
        System.out.println("Fin de las pruebas " + LocalDate.now().minusDays(1));
    }

    @BeforeEach
    public void beforeEach() {
        i++;
        System.out.println("Test N°: " + i);
    }

    @AfterEach
    public void afterEach() {
        System.out.println("----------------");
    }
    
    
    @Test
    @Order(1)
    public void testPasswordCorrecta(){
        assertTrue(usr.validarPassword(1212));
    }
    
    //2 pass incorrecta debe fallar
    @Test
    @Order(2)
    public void testValidarUsr() {
        assertFalse(usr.validarPassword(2222));
    }

    //3 validación de emial, debe estar ok
    @Test
    @Order(3)
    public void testValidarEmail() {
        String email = "juanjo@ulp.edu.ar";
        assertTrue(email.contains("@")
                && email.contains(".")
                && email.length() < 20);
    }

    //4 cambio de pass deber estar OK
    @Test
    @Order(4)
    public void testCambioPass() {
        usr.cambioPassword("1234");
        assertEquals(1234, usr.getPass());
    }

    //5 delay timeout (debe fallar)
    @Test
    @Order(5)
    public void testDelay() {
        assertTimeout(java.time.Duration.ofMillis(100), () -> {
            usr.delay(50);
        });
    }

    //6 usuarios diferentes. (debe estar ok)
    @Test
    @Order(6)
    public void testUsuariosDiferentes() {
        Usuario u1 = new Usuario("A", 1111);
        Usuario u2 = new Usuario("B", 2222);

        assertNotSame(u1, u2);
    }
}