package problemb;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Genes {

    private final Gene[] black, dilution, red;

    public Genes(String black, String dilution, String red) {
        this.black = black.chars().mapToObj(c -> (char)c)
                .map(GeneDomRec::fromRepresentation)
                .map(domRec -> Gene.from(GeneType.BLACK, domRec))
                .toArray(Gene[]::new);
        this.dilution = dilution.chars().mapToObj(c -> (char)c)
                .map(GeneDomRec::fromRepresentation)
                .map(domRec -> Gene.from(GeneType.DILUTION, domRec))
                .toArray(Gene[]::new);
        this.red = red.chars().mapToObj(c -> (char)c)
                .map(GeneDomRec::fromRepresentation)
                .map(domRec -> Gene.from(GeneType.RED, domRec))
                .toArray(Gene[]::new);
    }

    private Genes(Gene[] genes) {
        this.black = Arrays.stream(genes)
                .filter(gene -> gene.type == GeneType.BLACK)
                .toArray(Gene[]::new);
        this.dilution = Arrays.stream(genes)
                .filter(gene -> gene.type == GeneType.DILUTION)
                .toArray(Gene[]::new);
        this.red = Arrays.stream(genes)
                .filter(gene -> gene.type == GeneType.RED)
                .toArray(Gene[]::new);
    }

    public Genes[] expand() {
        var newBlacks = permutations(black);
        var newDilutions = permutations(dilution);
        var newReds = permutations(red);

        var newBlackDilutions = permutations(new Gene[][][] {newBlacks, newDilutions});
        var newBlackDilutionReds = permutations(new Gene[][][] {newBlackDilutions, newReds});

        return Arrays.stream(newBlackDilutionReds)
                .map(Genes::new)
                .toArray(Genes[]::new);
    }

    private Gene[][] permutations(Gene[] genes) {
        return Arrays.stream(genes)
                .map(gene -> {
                    if (gene.domRec == GeneDomRec.ANY)
                        return new Gene[] {
                                Gene.from(gene.type, GeneDomRec.DOMINANT),
                                Gene.from(gene.type, GeneDomRec.RECESSIVE)};
                    return new Gene[] {gene};
                })
                .reduce(new Gene[0][0],
                        (left, right) -> {
                            if (left.length == 0)
                                return new Gene[][] {right};
                            if (right.length == 0)
                                return left;
                            return Arrays.stream(left)
                                    .flatMap(ls -> Arrays.stream(ls)
                                            .flatMap(l -> Arrays.stream(right)
                                                    .map(r -> new Gene[] {l, r})))
                                    .toArray(Gene[][]::new);
                            },
                        (left, right) -> Stream.concat(Arrays.stream(left), Arrays.stream(right))
                                .toArray(Gene[][]::new)
                );
    }

    private Gene[][] permutations(Gene[][][] genes) {
        var perms = Arrays.stream(genes)
                .reduce(new Gene[0][0][0],
                        (left, right) -> {
                            if (left.length == 0)
                                return new Gene[][][] {right};
                            if (right.length == 0)
                                return left;
                            return Arrays.stream(left)
                                    .flatMap(ls -> Arrays.stream(ls)
                                            .flatMap(l -> Arrays.stream(right)
                                                    .map(r -> new Gene[][] {l, r})))
                                    .toArray(Gene[][][]::new);
                        },
                        (left, right) -> Stream.concat(Arrays.stream(left), Arrays.stream(right))
                                .toArray(Gene[][][]::new));
        return Arrays.stream(perms)
                .map(perm -> Arrays.stream(perm)
                        .flatMap(Arrays::stream)
                .toArray(Gene[]::new))
                .toArray(Gene[][]::new);
    }

    @Override
    public String toString() {
        return Stream.concat(Stream.concat(Arrays.stream(black), Arrays.stream(dilution)), Arrays.stream(red))
                .map(Gene::toString)
                .collect(Collectors.joining());
    }

}
