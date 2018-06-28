package model;

public class Usuario {

    private int id;
    private String rut_usuario;
    private int tipo;
    private String contraseña;

    public Usuario() {
    }

    public Usuario(String rut_usuario, int tipo, String contraseña) {
        this.rut_usuario = rut_usuario;
        this.tipo = tipo;
        this.contraseña = contraseña;
    }

    public Usuario(int id, String rut_usuario, int tipo, String contraseña) {
        this.id = id;
        this.rut_usuario = rut_usuario;
        this.tipo = tipo;
        this.contraseña = contraseña;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRut_usuario() {
        return rut_usuario;
    }

    public void setRut_usuario(String rut_usuario) {
        this.rut_usuario = rut_usuario;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}
