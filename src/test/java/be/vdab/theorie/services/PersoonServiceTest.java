package be.vdab.theorie.services;

import be.vdab.theorie.repositories.CSVPersoonRepositoryStub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
class PersoonServiceTest {
    private PersoonService service;
    @BeforeEach
    void beforeEach() {
        service = new PersoonService(new CSVPersoonRepositoryStub());
    }
    @Test
    void deWeddeStandaardAfwijkingIs2Positief() throws IOException {
        assertThat(service.standaardAfwijkingWeddes()).isEqualByComparingTo("2");
    }
}