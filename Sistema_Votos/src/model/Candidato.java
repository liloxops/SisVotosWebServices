package model;

public class Candidato {

    private int id;
    private String nombre;
    private String rut;
    private int fk_Partido;

    public Candidato() {
    }

    public Candidato(String nombre, String rut, int fk_Partido) {
        this.nombre = nombre;
        this.rut = rut;
        this.fk_Partido = fk_Partido;
    }
    
    
    public Candidato(int id, String nombre, String rut, int fk_Partido) {
        this.id = id;
        this.nombre = nombre;
        this.rut = rut;
        this.fk_Partido = fk_Partido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getFk_Partido() {
        return fk_Partido;
    }

    public void setFk_Partido(int fk_Partido) {
        this.fk_Partido = fk_Partido;
    }

    @Override
    public String toString() {
        return "Candidato{" + "id=" + id + ", nombre=" + nombre + ", rut=" + rut + ", fk_Partido=" + fk_Partido + '}';
    }

    

}
