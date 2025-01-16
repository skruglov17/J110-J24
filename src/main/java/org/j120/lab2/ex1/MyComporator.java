package org.j120.lab2.ex1;

import java.util.Comparator;
import java.util.Map;

public class MyComporator implements Comparator<Map.Entry<String, Integer>> {

    @Override
    public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) {
        int reverseValues = Integer.compare(m2.getValue(), m1.getValue());
        if (reverseValues == 0) {
            return m1.getKey().compareTo(m2.getKey());
        }
        return reverseValues;
    }
}
