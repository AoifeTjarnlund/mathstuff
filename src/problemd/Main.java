package problemd;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger count;


        while (sc.hasNextLine()) {
            count = Factorial.noOfAnagrams(sc.nextLine());
            System.out.println(count);

        }
        sc.close();
    }

}
