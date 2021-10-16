package problemb;

import java.awt.geom.RectangularShape;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cat {

    private static final Map<Gender, Map<String, Genes>> GENES_BY_GENDER_AND_COLOR = Map.of(
            Gender.FEMALE, Map.of(
                    "Black", new Genes("B-", "D-", "oo"),
                    "Blue", new Genes("B-", "dd", "oo"),
                    "Chocolate", new Genes("bb", "D-", "oo"),
                    "Lilac", new Genes("bb", "dd", "oo"),

                    "Red", new Genes("--", "D-", "OO"),
                    "Cream", new Genes("--", "dd", "OO"),

                    "Black-Red Tortie", new Genes("B-", "D-", "Oo"),
                    "Chocolate-Red Tortie", new Genes("bb", "D-", "Oo"),
                    "Blue-Cream Tortie", new Genes("B-", "dd", "Oo"),
                    "Lilac-Cream Tortie", new Genes("bb", "dd", "Oo")),
            Gender.MALE, Map.of(
                    "Black", new Genes("B-", "D-", "o"),
                    "Blue", new Genes("B-", "dd", "o"),
                    "Chocolate", new Genes("bb", "D-", "o"),
                    "Lilac", new Genes("bb", "dd", "o"),

                    "Red", new Genes("--", "D-", "O"),
                    "Cream", new Genes("--", "dd", "O"))
    );

    private final Gender gender;
    private final String color;
    private final Genes genes;

    public Cat(Gender gender, String color) {
        this.gender = gender;
        this.color = color;

        Map<String, Genes> genesByColor = GENES_BY_GENDER_AND_COLOR.get(gender);
        if (!genesByColor.containsKey(color))
            throw new RuntimeException("Could not get genes for " + color + " " + gender.name());
        this.genes = genesByColor.get(color);
    }

    public Gender getGender() {
        return gender;
    }

    public String getColor(){
        return color;
    }

    public Genes getGenes() {
        return genes;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "gender=" + gender +
                ", color='" + color + '\'' +
                ", genes='" + genes + '\'' +
                '}';
    }
}
