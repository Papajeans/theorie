package be.vdab.opdracht.domain;

import java.text.MessageFormat;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Pattern;

public class Persoon {
    private final static Pattern MINSTENS_1_NIET_BLANCO_TEKEN =
            Pattern.compile("^.*\\S.*$");
// volgorde van ingave blijft gerespecteerd
    private Set<String> voornamen = new LinkedHashSet<>();

    public void add (String voornaam){
//        throw new UnsupportedOperationException();
        if (!MINSTENS_1_NIET_BLANCO_TEKEN.matcher(voornaam).matches()){
            throw new IllegalArgumentException("Minstens 1 niet blanco teken");
        }
        voornamen.add(voornaam);
    }
    @Override
    public String toString(){
        var lijst = "";
//        throw new UnsupportedOperationException();
        for (String voornaam:voornamen){
            lijst = MessageFormat.format("{0}{1} ", lijst, voornaam);
        }
        return lijst;
    }
}
