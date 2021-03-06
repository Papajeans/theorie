package be.vdab.theorie.repositories;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;

public class CSVPersoonRepository implements PersoonRepository {
    @Override
    public BigDecimal[] findAllWeddes() throws IOException {
        return Files.lines(Path.of("/data/personen.csv"))
// regel splitsen in zijn onderdelen, 4° onderdeel omzetten naar BigDecimal:
                .map(regel -> new BigDecimal(regel.split(",")[3]))
                .toArray(BigDecimal[]::new);
    }
}