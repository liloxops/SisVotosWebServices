package model;

public class CandidatoSelect {
    private String id;
    private String nombre;
    private String rut;
    private String fk_Partido;

    public CandidatoSelect(String id, String nombre, String rut, String fk_Partido) {
        this.id = id;
        this.nombre = nombre;
        this.rut = rut;
        this.fk_Partido = fk_Partido;
    }

    public CandidatoSelect() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getFk_Partido() {
        return fk_Partido;
    }

    public void setFk_Partido(String fk_Partido) {
        this.fk_Partido = fk_Partido;
    }
    
    
}
