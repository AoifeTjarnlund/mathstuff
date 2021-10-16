package problemb;

import java.util.Arrays;

public enum Gene {
    
    BLACK_DOMINANT('B', GeneType.BLACK, GeneDomRec.DOMINANT),
    BLACK_RECESSIVE('b',GeneType.BLACK, GeneDomRec.RECESSIVE),
    BLACK_ANY('-',GeneType.BLACK, GeneDomRec.ANY),

    DILUTION_DOMINANT('D',GeneType.DILUTION, GeneDomRec.DOMINANT),
    DILUTION_RECESSIVE('d',GeneType.DILUTION, GeneDomRec.RECESSIVE),
    DILUTION_ANY('-',GeneType.DILUTION, GeneDomRec.ANY),

    RED_DOMINANT('O',GeneType.RED, GeneDomRec.DOMINANT),
    RED_RECESSIVE('o',GeneType.RED, GeneDomRec.RECESSIVE),
    RED_ANY('-',GeneType.RED, GeneDomRec.ANY);

    static Gene from(GeneType type, GeneDomRec domRec) {
        return Arrays.stream(Gene.values())
                .filter(gene -> gene.type == type && gene.domRec == domRec).findAny()
                .orElseThrow(() ->
                        new RuntimeException(type.name() + " " + domRec.name() + " is not a valid gene"));
    }

    public final char repr;
    public final GeneType type;
    public final GeneDomRec domRec;

    Gene(char repr, GeneType type, GeneDomRec domRec) {
        this.repr = repr;
        this.type = type;
        this.domRec = domRec;
    }

    @Override
    public String toString() {
        return Character.toString(repr);
    }
    
}
