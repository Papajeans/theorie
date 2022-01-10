package be.vdab.theorie.domain;

import be.vdab.taken.domain.Veiling;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThat;

public class VeilingTest {
    @Test
    void geenBodGedaanDanHoogsteIs0() {
        var veiling = new Veiling();
//        veiling.doeBod(BigDecimal.valueOf(1_000));
        var hoogsteBod = veiling.getHoogsteBod();
        assertThat(hoogsteBod).isEqualTo(BigDecimal.ZERO);
    }
    @Test
    void eenmaligBodHoogsteIsDatBod() {
        var veiling = new Veiling();
        veiling.doeBod(BigDecimal.valueOf(1_000));
        veiling.doeBod(BigDecimal.valueOf(2_000));
        var hoogsteBod = veiling.getHoogsteBod();
        assertThat(hoogsteBod).isEqualByComparingTo("2000");
    }
    @Test
    void meerdereBiedingenHoogsteIsHetHoogsteBodBedrag() {
        var veiling = new Veiling();
        veiling.doeBod(BigDecimal.valueOf(1_000));
        veiling.doeBod(BigDecimal.valueOf(500));
        veiling.doeBod(BigDecimal.valueOf(2_000));
        var hoogsteBod = veiling.getHoogsteBod();
        assertThat(hoogsteBod).isEqualByComparingTo("2000");
    }
    @Test
    void bedragDoeBodMagNietNegatiefZijn() {
        var veiling = new Veiling();
        assertThatIllegalArgumentException().isThrownBy(
        () -> veiling.doeBod(BigDecimal.valueOf(-1)));
    }
}
/*
• Als je nog geen enkel bod uitvoert, het hoogste bod gelijk is aan 0.
• Als je een eerste bod uitvoert, het hoogste bod gelijk is aan het bedrag van dit bod.
• Als je meerdere keren een bod uitvoert, het hoogste bod gelijk is aan bedrag van het hoogste bod.
*/