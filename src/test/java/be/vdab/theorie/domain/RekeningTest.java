package be.vdab.theorie.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class RekeningTest {
    private static final BigDecimal TWEE = BigDecimal.valueOf(2);
    @Test
    void eenNieuweRekeningHeeftGeenStortingen() {
    var rekening = new Rekening();
        assertThat(rekening.getStortingen()).isEmpty();
    }
    @Test
    void nadatJe10EuroStortIsErEenStortingVan10Euro() {
    var rekening = new Rekening();
        rekening.stort(BigDecimal.TEN);
        assertThat(rekening.getStortingen()).containsOnly(BigDecimal.TEN);
    }
    @Test
    void nadatJe10EuroEn1EuroStortZijnDeStortingen10EuroEn1Euro() {
    var rekening = new Rekening();
        rekening.stort(BigDecimal.TEN);
        rekening.stort(BigDecimal.ONE);
        assertThat(rekening.getStortingen())
                .containsExactly(BigDecimal.TEN, BigDecimal.ONE);
    }
    @Test
    void nadatJe10EuroEn1EuroEn2EuroStortZijnDeStortingenGesorteerd1EuroEn2EuroEn10Euro() {
    var rekening = new Rekening();
        rekening.stort(BigDecimal.TEN);
        rekening.stort(BigDecimal.ONE);
        rekening.stort(TWEE);
        assertThat(rekening.getStortingenGesorteerd()).isSorted()
            .containsExactly(BigDecimal.ONE, TWEE, BigDecimal.TEN);
    }
    @Test
    void hetSaldoVanEenNieuweRekeningIs0Euro() {
        var rekening = new Rekening();
        assertThat(rekening.getSaldo()).isZero();
    }
    @Test
    void nadatJe10EuroStortIsHetSaldo10Euro() {
        var rekening = new Rekening();
        rekening.stort(BigDecimal.TEN);
        assertThat(rekening.getSaldo()).isEqualByComparingTo("10");
    }
    @Test
    void nadatJe10EuroEn1EuroStortIsHetSaldo11Euro() {
        var rekening = new Rekening();
        rekening.stort(BigDecimal.TEN);
        rekening.stort(BigDecimal.ONE);
        assertThat(rekening.getSaldo()).isEqualByComparingTo("11");
    }
    @Test
    void hetGestorteBedragMagNietNulZijn() {
        var rekening = new Rekening();
        assertThatIllegalArgumentException().isThrownBy(
        () -> rekening.stort(BigDecimal.ZERO));
    }
    @Test
    void hetGestortBedragMagNietNegatiefZijn() {
        var rekening = new Rekening();
        assertThatIllegalArgumentException().isThrownBy(
                () -> rekening.stort(BigDecimal.valueOf(-1)));
    }
    void stortMetNullKanNiet() {
        var rekening = new Rekening();
        assertThatNullPointerException().isThrownBy(() -> rekening.stort(null));
    }
}