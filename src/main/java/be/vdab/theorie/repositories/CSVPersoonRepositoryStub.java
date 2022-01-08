package be.vdab.theorie.repositories;

import java.math.BigDecimal;

public class CSVPersoonRepositoryStub implements PersoonRepository {
    @Override
    public BigDecimal[] findAllWeddes()  { //  throws IOException
        return new BigDecimal[] {BigDecimal.valueOf(2), BigDecimal.valueOf(4),
        BigDecimal.valueOf(4), BigDecimal.valueOf(4), BigDecimal.valueOf(5),
                BigDecimal.valueOf(5), BigDecimal.valueOf(7), BigDecimal.valueOf(9)};
    }
}