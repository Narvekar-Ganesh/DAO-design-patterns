package org.example;

import home.pratice.domain.LibraryCard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CollectionExample {
    public static void main(String[] args) {
        Integer integerObject1 = new Integer("2");
        Integer integerObject2 = new Integer("2");

        System.out.println(integerObject1.hashCode());
        System.out.println(integerObject2.hashCode());

        String s1 = "ASDF";
        String s2 = "ASDF";

        System.out.println("s1.hashCode() : " + s1.hashCode());
        System.out.println("s2.hashCode() : " + s2.hashCode());
        System.out.println("s1 == s2 : " + s1 == s2);
        System.out.println("s1.equals(s2) : " + s1.equals(s2));

//        hashSetExample();
//        System.out.println("---------------------------");
//        hashSetExampleWithLibrary();
        checkDuplicateWithHastSet();
    }

    private static void hashMapExample() {
        Map<Integer, String> integerStringMap = new HashMap<>();
        integerStringMap.put(2, "XYZ");
        integerStringMap.put(3, "PQR");
        integerStringMap.put(2, "XYZ");
    }

    private static void hashSetExample() {
        Set<Integer> integerSet = new HashSet<>();
        integerSet.add(45);
        integerSet.add(45);
        System.out.println("number of elements present in hash-set : " + integerSet.size());
    }

    private static void hashSetExampleWithLibrary() {
        LibraryCard libraryCard1 = new LibraryCard();
        libraryCard1.setCardName("Swapnil");
        libraryCard1.setCardNumber(7895);
        libraryCard1.setId(1L);

        LibraryCard libraryCard2 = new LibraryCard();
        libraryCard2.setCardName("Swapnil");
        libraryCard2.setCardNumber(7895);
        libraryCard2.setId(1L);

        Set<LibraryCard> libraryCardSet = new HashSet<>();
        libraryCardSet.add(libraryCard1);
        libraryCardSet.add(libraryCard2);

        System.out.println("number of library  card  present in hash-set : " + libraryCardSet.size());
    }

    private static void checkDuplicateWithHastSet() {
        String inputSting = "My name is sahil and My hobby is playing and dancing ";

        String[] splitWords = inputSting.split(" ");
        Set<String> stringSet = new HashSet<>();
        System.out.println("Duplicate words are : ");
        for (String eachSplitWord : splitWords) {
            boolean result = stringSet.add(eachSplitWord);
            if (result == false) {
                System.out.println(eachSplitWord);
            }
        }
    }
}
