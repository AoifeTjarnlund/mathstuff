package problemd;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Factorial {

    public static BigInteger noOfAnagrams(String input) {
        BigInteger n2 = BigInteger.ONE;
        int total = input.length();

        HashMap<String, Integer> hm = new HashMap<>();
        for (String c : input.split("")) {
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        for (var kv : hm.entrySet()) {
            System.out.println(kv.getKey() + ": " + kv.getValue());
        }
        ArrayList<Integer> l = new ArrayList<>(hm.values());

        //sort in descending order
        l.sort(Collections.reverseOrder());

        for (int i = 0; i < total; i++) {
            n2 = n2.multiply(BigInteger.valueOf(l.size()));
            System.out.println(l.size());
            if (l.get(0) == 1) {
                l.remove(0);

            } else {
                int x = l.remove(0);
                l.add(0, x - 1);
            }

        }
        return n2;

    }

}

