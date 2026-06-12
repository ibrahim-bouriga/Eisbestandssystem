package com.kfru.Model;

public class Standort {
    private Long id;
    private String name;
    private StandortTyp typ;
    private Integer kapazitaet;
    private Integer groesse; // nur für LAGER relevant

    public Standort() {
    }

    public Standort(Long id, String name, StandortTyp typ, Integer kapazitaet, Integer groesse) {
        this.id = id;
        this.name = name;
        this.typ = typ;
        this.kapazitaet = kapazitaet;
        this.groesse = groesse;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StandortTyp getTyp() {
        return typ;
    }

    public void setTyp(StandortTyp typ) {
        this.typ = typ;
    }

    public Integer getKapazitaet() {
        return kapazitaet;
    }

    public void setKapazitaet(Integer kapazitaet) {
        this.kapazitaet = kapazitaet;
    }

    public Integer getGroesse() {
        return groesse;
    }

    public void setGroesse(Integer groesse) {
        this.groesse = groesse;
    }

    @Override
    public String toString() {
        return "Standort{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typ=" + typ +
                ", kapazitaet=" + kapazitaet +
                ", groesse=" + groesse +
                '}';
    }
}
