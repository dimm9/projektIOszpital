package org.example;

import java.util.List;

public class Pacjent {
    private int id;
    private String imie;
    private String nazwisko;
    private int poziom_zdrowia;

    public Diagnoza getDiagnoza() {
        return diagnoza;
    }

    private Diagnoza diagnoza;
    private Lekarz lekarz;
    private List<Raport> raporty;
    private Pomieszczenie sala;

    public Pacjent(int id, String imie, String nazwisko, Lekarz lekarz, Pomieszczenie sala) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.lekarz = lekarz;
        this.sala = sala;
    }

    public List<Raport> getRaporty() {
        return raporty;
    }

    public Pomieszczenie getSala() {
        return sala;
    }
    public void setSala(Pomieszczenie sala) {
        this.sala = sala;
    }

    void przegladaj_raporty(){
        for(Raport r : raporty){
            r.pokaz_zawartosc();
        }
    }

    public int getPoziomZdrowia() {
        return poziom_zdrowia;
    }

    public int getId() {
        return id;
    }
    public String pokazDaneOsobowe(){
        return imie + " " + nazwisko;
    }
    public void przyjmijLek(){
        poziom_zdrowia += 1;
    }

    public void setDiagnoza(Diagnoza diagnoza) {
        this.diagnoza = diagnoza;
    }
}
