package model;

import java.util.Date;

public class Voto {

    private int id;
    private int fk_Persona;
    private int fk_Candidato;
    private String fechaVoto;

    public Voto(int id, int fk_Persona, int fk_Candidato, String fechaVoto) {
        this.id = id;
        this.fk_Persona = fk_Persona;
        this.fk_Candidato = fk_Candidato;
        this.fechaVoto = fechaVoto;
    }

    public Voto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFk_Persona() {
        return fk_Persona;
    }

    public void setFk_Persona(int fk_Persona) {
        this.fk_Persona = fk_Persona;
    }

    public int getFk_Candidato() {
        return fk_Candidato;
    }

    public void setFk_Candidato(int fk_Candidato) {
        this.fk_Candidato = fk_Candidato;
    }

    public String getFechaVoto() {
        return fechaVoto;
    }

    public void setFechaVoto(String fechaVoto) {
        this.fechaVoto = fechaVoto;
    }

}
