package org.example;

public interface IPracownik {
    void drukuj_dane();
    void wykonajObowiazek(Pacjent pacjent); //pielegniarka - podaj lek => polepsza stan zdrowia, lekarz => postawDiagnoze
    int zbadajStanZdrowia(Pacjent pacjent);
    String getPassword();
    Raport stworzRaport(Pacjent pacjent);
    int getId();
    void zmienZarobki(double nowe_zarobki);
}
