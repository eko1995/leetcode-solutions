package LeetCode;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s = "tree";
        String res = frequencySort(s);
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            map.merge(character, 1, (a, b) -> a + b);
        }

        List<Character>[] bucket = new List[s.length() + 1];
        map.entrySet().stream().forEach(entry -> {
            int frequency = entry.getValue();
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(entry.getKey());
        });

        StringBuilder res = new StringBuilder();
        for(int pos = bucket.length - 1; pos > 0; pos--) {
            if(bucket[pos] != null) {
                for(char num : bucket[pos]) {
                    for(int i = 0; i < pos; i++) {
                        res.append(num);
                    }
                }
            }
        }

        return res.toString();
    }
}