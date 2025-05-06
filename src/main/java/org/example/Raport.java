package org.example;

import java.time.LocalDateTime;

public class Raport {
    private Pacjent pacjent;
    private String opis;
    private LocalDateTime data;
    private int ocena_zdrowia;

    public void setLek(Wyposazenie lek) {
        this.lek = lek;
    }

    private Wyposazenie lek;

    public Raport(Pacjent pacjent, String opis, LocalDateTime data, int ocena_zdrowia) {
        this.pacjent = pacjent;
        this.opis = opis;
        this.data = data;
        this.ocena_zdrowia = ocena_zdrowia;
        lek = null;
    }


    public void pokaz_zawartosc(){
        System.out.println(data.toString());
        System.out.println(pacjent.pokazDaneOsobowe());
        System.out.println(opis);
        System.out.println("Ocena zdrowia: " + ocena_zdrowia);
        System.out.println("Lek: " + lek.getNazwa());
    }

    public Wyposazenie getLek() {
        return lek;
    }
}
