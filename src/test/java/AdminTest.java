import org.example.Administrator;
import org.example.IPracownik;
import org.example.Lekarz;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class AdminTest {
    Administrator administrator = new Administrator("11111");
    @Test
    public void testDodajIUsunPracownika() {
        IPracownik p = new Lekarz("Anna", 1, "Nowak", 1000, "haslo", "Kardiolog");
        administrator.dodaj_pracownika(p);
        assertTrue(administrator.getPracownicy().contains(p));

        administrator.usun_pracownika(1);
        assertFalse(administrator.getPracownicy().contains(p));
    }

}
