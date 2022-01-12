package be.vdab.opdracht.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class PersoonTest {
    private Persoon persoon;

    @BeforeEach
    void beforeEach() {
        persoon = new Persoon();
    }
    @ParameterizedTest
    @ValueSource(strings = {"","   ","  ","\t  \n"})
    void elkeVoornaamMinstens1NietBlancoTekenHebben(String naam) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> persoon.add(naam));
    }
    @Test
    @DisplayName("""
            Een persoon kan geen twee keer dezelfde voornaam hebben.
            De toString method moet een String teruggeven.
            Die bestaat uit alle voornamen van die persoon, gescheiden door een spatie.
            De volgorde van de voornamen in de String moet gelijk zijn aan
            de volgorde zoals ze met de add method werden toegevoegd.""")
    void persoonKanGeen2KeerDezelfdeVoornaamHebben(){
        persoon.add("Jan");
        persoon.add("Piet");
        persoon.add("$  ");
        persoon.add("Jan");
        persoon.add("Piet");
        persoon.add("Hans");
//        assertThat(persoon.voornamen).containsOnly("Jan","Piet");
        assertThat(persoon).hasToString("Jan Piet $   Hans ");
    }
    @Test
    void eenArrayElementMagNietNullBevatten() {
        assertThatNullPointerException().isThrownBy(
                () -> persoon.add(null));
    }
}
/*
 Een persoon kan geen twee keer dezelfde voornaam hebben.
 Elke voornaam moet minstens één niet-blanco teken bevatten.
 De toString method moet een String teruggeven.
Die bestaat uit alle voornamen van die persoon, gescheiden door een spatie.
De volgorde van de voornamen in de String moet gelijk zijn aan
de volgorde zoals ze met de add method werden toegevoegd.
 */