package org.example;

import java.util.List;

public class Lekarz implements IPracownik{
    private int id;
    private String imie;
    private String nazwisko;
    private String stanowisko;
    private double zarobki;
    private List<Pacjent> pacjenci;
    private int reputacja;
    private String password;

    @Override
    public void drukuj_dane() {
        System.out.println("==== DANE PRACOWNIKA: LEKARZ ====");
        System.out.println("ID: " + id);
        System.out.println("Imię: " + imie);
        System.out.println("Nazwisko: " + nazwisko);
        System.out.println("Stanowisko: " + stanowisko);
        System.out.printf("Zarobki: %.2f PLN%n", zarobki);
        System.out.println("Reputacja: " + reputacja);
        System.out.println("=================================");
    }

    @Override
    public void wykonajObowiazek(Pacjent pacjent) {
        int poziom = pacjent.getPoziomZdrowia();
        Wyposazenie lek;
        if (poziom < 1) {
            pacjent.setDiagnoza(Diagnoza.OCD);
            lek = new Wyposazenie(100, "LekOcd", 5);
        } else if (poziom < 2) {
            pacjent.setDiagnoza(Diagnoza.Depresia);
            lek = new Wyposazenie(500, "LekDepresia", 6);
        } else if (poziom < 3) {
            pacjent.setDiagnoza(Diagnoza.ZaburzeniaLekowe);
            lek = new Wyposazenie(1000, "LekZaburzeniaLekowe", 4);
        } else if (poziom < 4) {
            pacjent.setDiagnoza(Diagnoza.ZaburzeniaOsobowosci);
            lek = new Wyposazenie(1200, "LekZaburzeniaOsobowosci", 7);
        } else if (poziom < 5) {
            pacjent.setDiagnoza(Diagnoza.ZaburzeniaOdzywiania);
            lek = new Wyposazenie(1500, "LekZaburzeniaOdzywiania", 3);
        } else if (poziom < 6) {
            pacjent.setDiagnoza(Diagnoza.Dwubiegunowosc);
            lek = new Wyposazenie(2000, "LekDwubiegunowosc", 6);
        } else {
            pacjent.setDiagnoza(Diagnoza.Schidzofrenia);
            lek = new Wyposazenie(2500, "LekSchidzofrenia", 2);
        }
        for(Raport r : pacjent.getRaporty()){
            if(r.getLek() == null){
                r.setLek(lek);
            }
        }
    }

    @Override
    public int zbadajStanZdrowia(Pacjent pacjent) {
        return pacjent.getPoziomZdrowia();
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public Raport stworzRaport(Pacjent pacjent) {
        return null;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void zmienZarobki(double nowe_zarobki) {

    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setZarobki(double zarobki) {
        this.zarobki = zarobki;
    }

    public double getZarobki() {
        return zarobki;
    }

}
