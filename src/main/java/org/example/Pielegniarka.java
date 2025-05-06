package org.example;

public class Pielegniarka implements IPracownik {
    private int id;
    private String imie;
    private String nazwisko;
    private double zarobki;
    private String password;

    @Override
    public void drukuj_dane() {
        System.out.println("==== DANE PRACOWNIKA: PIELĘGNIARKA ====");
        System.out.println("ID: " + id);
        System.out.println("Imię: " + imie);
        System.out.println("Nazwisko: " + nazwisko);
        System.out.printf("Zarobki: %.2f PLN%n", zarobki);
        System.out.println("========================================");
    }

    @Override
    public void wykonajObowiazek(Pacjent pacjent) {
        for(Raport r : pacjent.getRaporty()){
            Wyposazenie lek = r.getLek();
            if(lek != null){
                Pomieszczenie pomieszczenie = Administrator.pomieszczenia.getFirst();
                if(pomieszczenie != null){
                    pomieszczenie.usun_wyposazenie(lek);
                    System.out.println("Pacjent " + pacjent.pokazDaneOsobowe() + " przyjal lek " + r.getLek().getNazwa());
                    pacjent.przyjmijLek();
                }else{
                    System.out.println("Nie ma takiego leku");
                }
            }else{
                System.out.println("Pacjent nie ma przypisanych lekow");
            }
        }
    }

    @Override
    public int zbadajStanZdrowia(Pacjent pacjent) {
        return pacjent.getPoziomZdrowia();
    }

    @Override
    public String getPassword() {
        return password;
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

    public String getImie() {
        return imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public double getZarobki() {
        return zarobki;
    }

}
