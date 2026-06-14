package com.ulp.examen2ingsoft_testusuario;

/**
 *
 * @author Gimenez
 */

public class Usuario {

    private String user;
    private int pass;

    public Usuario(String user, int pass) {
        this.user = user;
        this.pass = pass;
    }

    public Usuario() {}

    public boolean validarPassword(int contra) {
        return this.pass == contra;
    }

    public void cambioPassword(String newPass) {
        this.pass = Integer.parseInt(newPass);
    }

    public void delay(int mili) {
        try {
            Thread.sleep(mili);
        } catch (InterruptedException e) {
            System.out.println("Delay de " + mili + " milisegundos");
            Thread.currentThread().interrupt();
        }
    }

    public boolean usuariosDiferentes(Usuario u2) {
        return !this.user.equals(u2.user);
    }
    
    public boolean validarEmail(String email) {

        if (email == null) return false;

        return email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
    }

    public int getPass() {
        return pass;
    }
    
    public String getUser() {
        return user;
    }
}