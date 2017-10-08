package HW3.Lists;

import java.util.*;

public class MarkLength4 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("qwer");
        stringList.add("qwee");
        stringList.add("ig");
        stringList.add("");
        stringList.add("123w4");
        markLength4(stringList);
        for (String string: stringList) {
            System.out.println(string);
        }
    }

    public static void markLength4(List<String> stringList) {
        int cnt = 0;
        List<String> copy = new ArrayList<>(stringList.size());
        copy.addAll(stringList);

        for (String next : copy) {
            if (next.length() == 4) {
                stringList.add(cnt, "****");
                cnt++;
            }
            cnt++;
        }
    }
}
