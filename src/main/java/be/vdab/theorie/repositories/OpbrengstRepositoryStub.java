package be.vdab.theorie.repositories;

import java.math.BigDecimal;

public class OpbrengstRepositoryStub implements OpbrengstRepository {
    @Override
    public BigDecimal findTotaleOpbrengst() { //  throws IOException
        return BigDecimal.valueOf(100);
    }
}