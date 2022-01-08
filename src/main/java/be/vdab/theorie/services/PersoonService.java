package be.vdab.theorie.services;

import be.vdab.theorie.repositories.PersoonRepository;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class PersoonService {
    private final PersoonRepository repository;
//  private final CSVPersoonRepository repository = new CSVPersoonRepository(); vroeger nu zoals als volgt:
    public PersoonService(PersoonRepository repository){
        this.repository=repository;
    }

    public BigDecimal standaardAfwijkingWeddes() throws IOException {
        List<BigDecimal> weddes = List.of(repository.findAllWeddes());

    BigDecimal totaal = weddes.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
/*
        var totaal = BigDecimal.ZERO;
        for (var wedde : weddes) {
            totaal = totaal.add(wedde);
        }
 */
        var gemiddelde =
                totaal.divide(BigDecimal.valueOf(weddes.size()), 2, RoundingMode.HALF_UP);
        totaal = BigDecimal.ZERO;
        for (var wedde : weddes) {
            var verschil = wedde.subtract(gemiddelde);
            var kwadraat = verschil.pow(2);
            totaal = totaal.add(kwadraat);
        }
        var variantie =  // standaard afwijking
                totaal.divide(BigDecimal.valueOf(weddes.size()), 2, RoundingMode.HALF_UP);
        return BigDecimal.valueOf(Math.sqrt(variantie.doubleValue()));
    }
}
