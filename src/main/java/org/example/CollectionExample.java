package org.example;

import home.pratice.domain.Batsman;
import home.pratice.domain.LibraryCard;
import home.pratice.comparator.BatsmanComparator;
import home.pratice.comparator.SixerComparator;

import java.util.*;

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
//        checkDuplicateWithHastSet();
//        checkOccurrenceOfPalyerOfMatchHashMap();
//        amountCalculateWithHashMap();
//        demonstrateComparatorExample();
//        demonstrateComparatorExampleForSixes();
//        demonstrateComparatorExample();
        demonstrateTreeMap();
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

    public static void checkOccurrenceOfWordsUsingHashMap() {
        String inputString = "Java is very difficult in programming language Java is mother of all programming language ";

        String[] splitWords = inputString.split(" ");
        Map<String, Integer> stringInteger = new HashMap<>();
        for (String eachWord : splitWords) {
            Integer value = stringInteger.get(eachWord);
            if (value == null) {
                stringInteger.put(eachWord, 1);
            } else {
                value += 1;
                stringInteger.put(eachWord, value);
            }
        }
        System.out.println("Occurrence of words " + stringInteger);
    }

    /**
     * inputString = "Sachin , Sehwag , Steve , Kohli , Gibbs, Raza , Duplesis , Sharma , Sachin , Kohli , Sachin , Yuvraj";
     * calculate number of MoM for each player
     * End of the problem - print all MoM players
     */

    public static void checkOccurrenceOfPalyerOfMatchHashMap() {
        String inputPlayer = "Sachin Rohit Kohali Rahul Sachin Kohali Rahul Rohit Devid";

        String[] splitPlayers = inputPlayer.split(" ");
        Map<String, Integer> playerToManOfMatch = new HashMap<>();
        for (String eachPlayer : splitPlayers) {
            Integer value = playerToManOfMatch.get(eachPlayer);
            if (value == null) {
                playerToManOfMatch.put(eachPlayer, 1);
            } else {
                value += 1;
                playerToManOfMatch.put(eachPlayer, value);
            }
        }
        System.out.println(" Occurrence of Player of the Match" + playerToManOfMatch);
    }


    public static void amountCalculateWithHashMap() {
        String inputName = ("Siddhu=200;Sahil=200;Vira=450;Manish=440;Siddhu=450;Sahil=880");
        Map<String, Integer> studentNameToAmount = new HashMap<>();
        String[] splitData = inputName.split(";");
        for (String eachStudent : splitData) {
            String[] arrayOfStudentDetails = eachStudent.split("=");
            String studentName = arrayOfStudentDetails[0];
            Integer amount = studentNameToAmount.get(studentName);
            if (amount == null) {
                studentNameToAmount.put(studentName, Integer.parseInt(arrayOfStudentDetails[1]));
            } else {
                amount += Integer.parseInt(arrayOfStudentDetails[1]);
                studentNameToAmount.put(studentName, amount);
            }
        }
        System.out.println("studentNameToAmount : " + studentNameToAmount);
    }

    public static void demonstrateComparatorExample(){
        List<Batsman> batsmen = new ArrayList<>();
        Batsman batsman = new Batsman("Sachin", 100);
        batsmen.add(batsman);

        batsman = new Batsman("Yuvraj" , 29);
        batsmen.add(batsman);

        batsman = new Batsman("Kohli" , 78);
        batsmen.add(batsman);

        System.out.println("before sorting : " + batsmen);

        batsmen.sort(new BatsmanComparator());
//        Collections.sort(batsmen);
        System.out.println("after sorting : " + batsmen);

    }
    public static void demonstrateComparatorExampleForSixes(){
        List<Batsman> batsmen = new ArrayList<>();
        Batsman batsman = new Batsman();
        batsman.setName("Sahin");
        batsman.setNumberOfSixes(45);
        batsmen.add(batsman);

        batsman = new Batsman();
        batsman.setName("Rohit");
        batsman.setNumberOfSixes(86);
        batsmen.add(batsman);

        batsman = new Batsman();
        batsman.setName("Virat");
        batsman.setNumberOfSixes(98);
        batsmen.add(batsman);

        Collections.sort(batsmen ,new SixerComparator());
        System.out.println("List of batsmen"+batsmen);
    }


    private static void demonstrateTreeMap(){
        Map<Batsman , String> batsmanToLeagueMatch = new TreeMap<>();
//        Comparator<Batsman> batsmanComparator = new SixerComparator();
//        Map<Batsman , String> batsmanToLeagueMatch = new TreeMap<>(batsmanComparator);

        Batsman batsman = new Batsman();
        batsman.setName("Sahin");
        batsman.setNumberOfSixes(45);
        batsmanToLeagueMatch.put(batsman , "IPL3");

        batsman = new Batsman();
        batsman.setName("Rohit");
        batsman.setNumberOfSixes(60);
        batsmanToLeagueMatch.put(batsman , "IPL3");

        batsman = new Batsman();
        batsman.setName("Virat");
        batsman.setNumberOfSixes(52);
        batsmanToLeagueMatch.put(batsman , "IPL3");

        batsman = new Batsman();
        batsman.setName("Rahane");
        batsman.setNumberOfSixes(24);
        batsmanToLeagueMatch.put(batsman , "IPL3");

        System.out.println("Sorted batsmen : " + batsmanToLeagueMatch);
    }
}