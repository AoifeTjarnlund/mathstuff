package problemd;

import java.util.Set;
import java.util.TreeSet;

public class Permute {
    public static Set<String> permute(String chars) {
        Set<String> set = new TreeSet<String>();
        if (chars.length() == 1) {
            set.add(chars);
        } else {
            for (int i = 0; i < chars.length(); i++) {
                String pre = chars.substring(0, i);
                String post = chars.substring(i + 1);
                String remaining = pre + post;

                for (String permutation : permute(remaining)) {
                    set.add(chars.charAt(i) + permutation);
                }


            }
        }
        return set;
    }
}
