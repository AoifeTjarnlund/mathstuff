package problemb;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    static String stringSplitter(String str, int n) {
        int strSize = str.length();
        int partSize = strSize /n;

        for(int i = 0; i < strSize; i++){
            if(i % partSize == 0){

            }
        }
        return str;

    }


    public void GeneBuilder(String mum, String dad) {



    }


    static public void main(String[] args) {

        Scanner sc = new Scanner(System.in);
         String mumColor = sc.nextLine();
         String dadColor = sc.nextLine();

        Cat mum = new Cat(Gender.FEMALE, mumColor);
        Cat dad = new Cat(Gender.MALE, dadColor);

        System.out.println(mum);
        var mumGenes = mum.getGenes().expand();
        System.out.println(Arrays.stream(mumGenes).map(Genes::toString).collect(Collectors.joining(", ")));
        System.out.println();
        System.out.println(dad);
        var dadGenes = dad.getGenes().expand();
        System.out.println(Arrays.stream(dadGenes).map(Genes::toString).collect(Collectors.joining(", ")));
    }
}
