package be.vdab.theorie.services;

import be.vdab.theorie.repositories.KostRepository;
import be.vdab.theorie.repositories.OpbrengstRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

// enkele imports
@ExtendWith(MockitoExtension.class)
class WinstServiceTest {
    private WinstService winstService;
    @Mock
    private OpbrengstRepository opbrengst;
    @Mock
    private KostRepository kosten;
    @BeforeEach
    void beforeEach() {
        winstService = new WinstService(opbrengst, kosten);
    }

    @Test
    void winstIsOpbrengstMinKost() {
        when(opbrengst.findTotaleOpbrengst()).thenReturn(BigDecimal.valueOf(200));
        when(kosten.findTotaleKost()).thenReturn(BigDecimal.valueOf(33));
        assertThat(winstService.getWinst()).isEqualByComparingTo("167");
        verify(opbrengst).findTotaleOpbrengst();
        verify (kosten).findTotaleKost();  // verify(mock).someMethod();
    }
}
