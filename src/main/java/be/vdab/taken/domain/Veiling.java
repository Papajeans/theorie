package be.vdab.taken.domain;

import java.math.BigDecimal;

public class Veiling {
    private BigDecimal hoogsteBod = BigDecimal.ZERO;

    public void doeBod (BigDecimal bedrag){
        if (bedrag.compareTo(BigDecimal.ZERO)<0) {
            throw new IllegalArgumentException("het bod is negatief.");
        }
        else if(bedrag.compareTo(hoogsteBod) > 0) {
                hoogsteBod = bedrag;
        }
        System.out.println("doeBod :" + bedrag);
    }
    public BigDecimal getHoogsteBod(){
        System.out.println("hoogsteBod: " + hoogsteBod);
        return hoogsteBod;
    }
}
