package org.example;

public class Wyposazenie {
    private float cena;
    private String nazwa;
    private Pomieszczenie lokalizacja;
    private int stan;

    public Wyposazenie(float cena, String nazwa, int stan) {
        this.cena = cena;
        this.nazwa = nazwa;
        this.stan = stan;
    }

    public float getCena() {
        return cena;
    }

    public String getNazwa() {
        return nazwa;
    }

    public Pomieszczenie getLokalizacja() {
        return lokalizacja;
    }

    public int getStan() {
        return stan;
    }

    public void setLokalizacja(Pomieszczenie lokalizacja) {
        this.lokalizacja = lokalizacja;
    }

    public void pokazDane(){

    }

}
