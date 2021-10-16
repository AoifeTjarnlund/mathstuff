package problemd;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;

public class Anagrams {

    public static void main(String[] args) {
        try (var sc = new Scanner(System.in)) {
            while (sc.hasNextLine()) {
                System.out.println(countAnagrams(sc.nextLine()));
            }
        }
    }

    public static BigInteger countAnagrams(String input) {
        if (input.isEmpty())
            return BigInteger.ZERO;

        var map = new HashMap<String, Integer>();
        for (var c : input.split(""))
            map.put(c, map.getOrDefault(c, 0) + 1);

        // Multinomonial coefficients
        BigInteger count = factorial(input.length());
        for (var uniqueCount : map.values())
            count = count.divide(factorial(uniqueCount));

        return count;
    }

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (; n > 1; n--)
            result = result.multiply(BigInteger.valueOf(n));
        return result;
    }

}