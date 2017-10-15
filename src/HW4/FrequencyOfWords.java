package HW4;

import java.util.HashMap;
import java.util.Map;

public class FrequencyOfWords  {
    public static void main(String[] args) {
        String text = "One of the most alarming forms of air pollution is acid rain." +
                "It results from the release into the atmosphere of sulphur and nitrogen " +
                "oxides that react with water droplets and return to earth in the form of acid rain," +
                "mist or snow. Acid rain is killing forests in Canada, the USA, and central and northern Europe." +
                "Nearly every species of tree is affected. It has acidified lakes and streams and they can’t support " +
                "fish, wildlife, plants or insects.";
        String pattern = "\\s+|[,.!?]\\s*";
        String[] words = text.split(pattern);

        Map<String,Integer> map =  new HashMap<>();
        for (String word: words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        for (Map.Entry<String, Integer> pair: map.entrySet()) {
            System.out.println(pair.getKey() + " - " + pair.getValue());
        }
    }
}
