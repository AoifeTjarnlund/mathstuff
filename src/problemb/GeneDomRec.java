package problemb;

public enum GeneDomRec {

    DOMINANT, RECESSIVE, ANY;

    static GeneDomRec fromRepresentation(char repr) {
        if (repr == '-')
            return ANY;
        if (Character.isUpperCase(repr))
            return DOMINANT;
        return RECESSIVE;
    }

}
