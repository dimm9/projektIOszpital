package org.example;

import java.util.List;

public class Pomieszczenie {
    private int nr_sali;
    private List<Wyposazenie> wyposazenia;
    public void dodaj_wyposazenie(Wyposazenie wyposazenie){
        wyposazenia.add(wyposazenie);
    }
    public void usun_wyposazenie(Wyposazenie wyposazenie){
        wyposazenia.remove(wyposazenie);
    }
    //0 - pokoj z lekami xd
    public List<Wyposazenie> getWyposazenia() {
        return wyposazenia;
    }

}
