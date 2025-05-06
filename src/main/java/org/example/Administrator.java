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
        void usun_pracownika(int id){
            pracownicy.remove(Szpital.getById(id, this.pracownicy));
        }
        void dodaj_pracownika(IPracownik pracownik){
            pracownicy.add(pracownik);
        }
        void dodaj_pacjenta(Pacjent pacjent, Pomieszczenie pomieszczenie){
            pacjenci.add(pacjent);
            pacjent.setSala(pomieszczenie);
        }
        void usun_pacjenta(int id){
            pacjenci.remove(Szpital.getByIdP(id, pacjenci));
        }
        void kup_nowa_sale(Pomieszczenie pomieszczenie){
            pomieszczenia.add(pomieszczenie);
        }
    }
}
