package org.example;

import java.util.ArrayList;
import java.util.List;

public class Administrator {
    private Zarzadzanie zarzadzanie;
    private String password;
    public static List<Pomieszczenie> pomieszczenia;

    public Administrator(String password){
        this.password = password;
        zarzadzanie = new Zarzadzanie();
    }
    public String getPassword() {
        return password;
    }
    public Zarzadzanie getZarzadzanie() {
        return zarzadzanie;
    }

    public List<IPracownik> getPracownicy() {
        return zarzadzanie.getPracownicy();
    }

    public class Zarzadzanie {
        private double budzet;
        private List<Pacjent> pacjenci;
        private List<IPracownik> pracownicy;


        public List<IPracownik> getPracownicy() {
            return pracownicy;
        }

        public Zarzadzanie() {
            Administrator.pomieszczenia = new ArrayList<>();
            this.pacjenci = new ArrayList<>();
            this.pracownicy = new ArrayList<>();
            this.budzet = 1000;
        }

        public boolean kup_wyposazenie(Wyposazenie wyposazenie, int nr_sali){
            if (wyposazenie.getCena() <= budzet){
                budzet -= wyposazenie.getCena();
                pomieszczenia.get(nr_sali).dodaj_wyposazenie(wyposazenie);
                return true;
            }else{
                return false;
            }
        }
        void kup_nowa_sale(Pomieszczenie pomieszczenie){
            pomieszczenia.add(pomieszczenie);
        }
    }
    public void usun_pracownika(int id){
        zarzadzanie.pracownicy.remove(Szpital.getById(id, zarzadzanie.pracownicy));
    }
    public void dodaj_pracownika(IPracownik pracownik){
        zarzadzanie.pracownicy.add(pracownik);
    }
    public void dodaj_pracownika(String imie, int id, String nazwisko, String password, String stanowisko, int LP){
        IPracownik pracownik;
        if (LP == 'L') {
            pracownik = new Lekarz(imie, id, nazwisko, 1000, password, stanowisko);
        }else{
            pracownik = new Pielegniarka(id, imie, nazwisko, 500, password);
        }
        zarzadzanie.pracownicy.add(pracownik);
    }
    public void dodaj_pacjenta(Pacjent pacjent, Pomieszczenie pomieszczenie){
        zarzadzanie.pacjenci.add(pacjent);
        pacjent.setSala(pomieszczenie);
    }
    public void usun_pacjenta(int id){
        zarzadzanie.pacjenci.remove(Szpital.getByIdP(id, zarzadzanie.pacjenci));
    }
}
