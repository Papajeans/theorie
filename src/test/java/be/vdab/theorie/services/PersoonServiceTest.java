package be.vdab.theorie.services;

import be.vdab.theorie.repositories.PersoonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PersoonServiceTest {
    private PersoonService service;
    @Mock
    private PersoonRepository repository;
    @BeforeEach
    void beforeEach() {
        service = new PersoonService(repository);  //(new CSVPersoonRepositoryStub());
    }
    @Test
    void deWeddeStandaardAfwijkingIs2Positief() throws IOException {
        when(repository.findAllWeddes()).thenReturn(new BigDecimal[] {
                BigDecimal.valueOf(2), BigDecimal.valueOf(4), BigDecimal.valueOf(4),
                BigDecimal.valueOf(4), BigDecimal.valueOf(5), BigDecimal.valueOf(5),
                BigDecimal.valueOf(7), BigDecimal.valueOf(9) });
        verify(repository).findAllWeddes();
        assertThat(service.standaardAfwijkingWeddes()).isEqualByComparingTo("2");
    }
}