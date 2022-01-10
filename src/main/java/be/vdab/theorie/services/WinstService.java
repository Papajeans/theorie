package be.vdab.theorie.services;

import be.vdab.theorie.repositories.KostRepository;
import be.vdab.theorie.repositories.OpbrengstRepository;

import java.math.BigDecimal;

public class WinstService {
    private final OpbrengstRepository opbrengst;
    private final KostRepository kosten;

    public WinstService(OpbrengstRepository opbrengst, KostRepository kosten) {
        this.kosten = kosten;
        this.opbrengst = opbrengst;
    }

        public BigDecimal getWinst () {
            return opbrengst.findTotaleOpbrengst().subtract(kosten.findTotaleKost());

        }
    }