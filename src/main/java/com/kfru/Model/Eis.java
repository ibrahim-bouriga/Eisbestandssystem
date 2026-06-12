package com.kfru.Model;

/**
 * @author Ibrahim Bouriga on 12.06.26
 */
public class Eis {
    private Long id;
    private Sorte sorte;
    private Long preis;

    public Eis() {
    }

    public Eis(Long id, Sorte sorte, Long preis) {
        this.id = id;
        this.sorte = sorte;
        this.preis = preis;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setSorte(Sorte sorte) {
        this.sorte = sorte;
    }

       public Sorte getSorte() {
        return sorte;
    }

    public void setPreis(Long preis) {
        this.preis = preis;
    }

        public Long getPreis() {
        return preis;
    }
    
}
