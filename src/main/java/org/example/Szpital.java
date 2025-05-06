package org.example;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Szpital {
    private Administrator administrator;
    private int renoma;

    Szpital(){
        administrator = new Administrator("admin");
        renoma = 5;
    }
    void print_actions(){
        System.out.println("------------ System zarzadzania szpitalem nauropsychiatrycznym ---------------");
        login();
    }

    static IPracownik getById(int id, List<IPracownik> pracownicy){
        for(IPracownik p : pracownicy){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }
    static Pacjent getByIdP(int id, List<Pacjent> pacjenci){
        for(Pacjent p : pacjenci){
            if(p.getId() == id){
                return p;
            }
        }
        return null;
    }

    int login(){
        while(true){
            System.out.println("Zaloguj sie jako admnistrator(A)/pracownik(P)");
            Scanner scanner = new Scanner(System.in);
            String result = scanner.nextLine();
            if(Objects.equals(result, "A")){
                String password = scanner.nextLine();
                if (Objects.equals(this.administrator.getPassword(), password)){
                    return 0;
                }
            }else if(Objects.equals(result, "P")){
                int id = scanner.nextInt();
                String password = scanner.nextLine();
                if (Objects.equals(Szpital.getById(id, this.administrator.getZarzadzanie().getPracownicy()), password)){
                    return id;
                }
            }
        }
    }

    void start(){
        System.out.println("------- System zarzadzania szpitalem nauropsychiatrycznym --------");
        int id = login();
        if(id == 0){
            System.out.println("1 - Kup nowe wyposazenie");
            System.out.println("2 - Zwolnij pracownika");
            System.out.println("3 - Wypisz pacjenta");
            System.out.println("4 - Zatrudnij pracownika");
            System.out.println("5 - Zarejestruj pacjenta");
            System.out.println("6 - Pokaz statystyki szpitala");
            System.out.println("7 - Zakoncz");
        }else{
            System.out.println("1 - Wykonaj obowiazek");
            System.out.println("2 - Zbadaj stan zdrowia");
            System.out.println("3 - Sprawdz swoj profil");
            System.out.println("4 - Przegladaj raporty pracownikow");
            System.out.println("5 - Zakoncz");
        }
    }
}
