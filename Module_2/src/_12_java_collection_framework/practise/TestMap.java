package _12_java_collection_framework.practise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Smith",30);
        hashMap.put("Anderson",31);
        hashMap.put("Lewis",29);
        hashMap.put("Cook",29);
        hashMap.put("Andy",32);
        System.out.println("Display entries in HasMap");
        System.out.println(hashMap);
        //
        Map<String, Integer> treeMap = new TreeMap<>(hashMap);
        System.out.println("Display entries in treeMap");
        System.out.println(treeMap);
        //
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>(16,0.75f,true);
        linkedHashMap.put("Smith", 30);
        linkedHashMap.put("Anderson", 30);
        linkedHashMap.put("Lewis", 30);
        linkedHashMap.put("Cook", 30);
        System.out.println("\nThe age for "+" Lewis is "+ linkedHashMap.get("Lewis"));
    }
}
