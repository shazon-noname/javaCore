package Collections.Map;

import java.util.HashMap;
import java.util.Map;


//Given an array of strings, return a Map<String,
// Boolean> where each different string is a key and its value is true if that string appears 2 or more times in the array.

//wordMultiple(["a", "b", "a", "c", "b"]) → {"a": true, "b": true, "c": false}
// wordMultiple(["c", "b", "a"]) → {"a": false, "b": false, "c": false}
// wordMultiple(["c", "c", "c", "c"]) → {"c": true}

public class WordMultiple {
    public Map<String, Boolean> wordMultiple(String[] strings) {
        Map<String, Integer> map = new HashMap<>();

        for (String string : strings) {
            map.put(string, map.getOrDefault(string,0) + 1);
        }

        Map<String, Boolean> resultMap = new HashMap<>();

        for (String word : map.keySet()) {
            resultMap.put(word, map.get(word) >= 2);
        }

        return resultMap;
    }
}
