package permutation;

import java.util.ArrayList;

public class Permutation {

    public static void main(String[] args) {
        int n, i, i1;
        String s = "ABCD";
        ArrayList<String> t = permute(s);
        for (i = 0; i < t.size(); i++) {
            i1 = i + 1;
            if (i1 < 10) {
                System.out.println("   " + i1 + " " + t.get(i));
            } else if (i1 < 100) {
                System.out.println("  " + i1 + " " + t.get(i));
            } else {
                System.out.println(" " + i1 + " " + t.get(i));
            }
        }
        System.out.println();

    }

    public static ArrayList<String> permute(String s) {
        ArrayList<String> result = new ArrayList<>();

        if (s.length() <= 1) {
            result.add(s);
            return result;
        } else {
            String first = s.substring(0, 1);
            String rest = s.substring(1, s.length());

            ArrayList<String> permutations = permute(rest);
            for (String permutation : permutations) {
                result.addAll(insertPossiblePosition(first, permutation));
            }
        }
        return result;
    }

    public static ArrayList<String> insertPossiblePosition(String first, String s) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i <= s.length(); i++) {
            result.add(s.substring(0, i) + first + s.substring(i, s.length()));
        }
        return result;
    }

}
