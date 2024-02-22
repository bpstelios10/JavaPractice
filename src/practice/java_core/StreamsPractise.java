package practice.java_core;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamsPractise {

    public static void main(String[] args) {
        List<Integer> randomIntegers = List.of(1, 2, 3, 4, 5, 6, 1000, 1234543, 68939, Integer.MAX_VALUE, Integer.MIN_VALUE + 1);
        List<Float> randomFloats =
                List.of(1.3f, 2.01f, 3.3f, 4.0f, -5.55424f, 6.4f, 1000.001f, 1234543.1234f, 68939.343f, Float.MAX_VALUE, Float.MIN_VALUE);
        List<String> randomStrings = List.of("random text", "test", "Blah blah", "blah", "", " ", "totoi", "practise", "TestCase");
        List<Object> randomObjects = List.of(1, 2, 1, 0, "test1", "test2", "test3", 1.01f, 1.02f, 1.01d, 1.01f, false, true, true);
        List<CustomObject> randomCustomObjects = List.of(new CustomObject(1, 1), new CustomObject(2, 3), new CustomObject(3, 2), new CustomObject(4, 4));

        System.out.println("1. Find the sum of all elements in a List using streams."); // i added even to make it interesting
        q1Solution(randomIntegers);

        System.out.println("2. Given a List of integers, write a program to find the maximum element using streams.");
        q2Solution(randomIntegers);

        System.out.println("3. Given a List of strings, write a program to count the number of strings that start with a specific character using streams.");
        q3Solution(randomStrings);

        System.out.println("4. Convert a List of strings to uppercase using streams.");
        q4Solution(randomStrings);

        System.out.println("5. Given a List of integers, write a program to filter out the even numbers using streams.");
        System.out.println("   Count the number of elements in a list that satisfy a specific condition using streams.");
        q5Solution(randomIntegers);

        System.out.println("6. Write a program to find the average of a List of floating-point numbers using streams.");
        q6Solution(randomFloats);

        System.out.println("7. Given a List of strings, write a program to concatenate all the strings using streams.");
        q7Solution(randomStrings);

        System.out.println("8. Write a program to remove duplicate elements from a List using streams.");
        q8Solution(randomObjects);

        System.out.println("9. Given a List of objects, write a program to sort the objects based on a specific attribute using streams.");
        q9Solution(randomCustomObjects);

        System.out.println("10. Write a program to check if all elements in a List satisfy a given condition using streams.");
        q10Solution(randomCustomObjects);

        System.out.println("**** Extra practice questions ****");

        System.out.println("11. Given a List of integers, write a program to find the difference between the maximum and minimum elements using streams.");
        System.out.println("is there any?? IntStatistics?");

        System.out.println("12. Write a program to check if a List of strings contains at least one uppercase word using streams.");
        q12Solution(randomStrings);

        System.out.println("13. Given a List of integers, write a program to filter out the prime numbers using streams.");
        System.out.println("hard");

        System.out.println("14. Write a program to check if a List of strings contains any duplicates using streams.");
        q13Solution(randomStrings);

        System.out.println("15. Given a List of strings, write a program to count the total number of characters in all strings using streams.");
        q14Solution(randomStrings);

//        System.out.println("**** PART2 ****");
//        System.out.println("16. Given a sentence, find and print the frequency of each word.");
//        System.out.println("17. Given a list of integers, find out all the numbers starting with 1.");
//        System.out.println("18. Given a list of names, group them by their first letter, and then count the number of names in each group.");
//        System.out.println("19. Find and print duplicate numbers in an array if it contains multiple duplicates?");
//        System.out.println("20. How are duplicates removed from a given array in Java?");
//        System.out.println("21. Given a list of words, filter and print the palindromes");
//        System.out.println("22. How do you merge two sorted arrays into a single sorted array?");
//        System.out.println("23. Given two lists of strings, concatenate them and remove duplicates.");
//        System.out.println("24. Student Grade Classification - 70 and above pass (attribute 2 of customObject above 70)");
//        System.out.println("25. Given a list of strings, sort them according to increasing order of their length.");
//        System.out.println("26. Partition a list of numbers into two groups: even and odd, using a custom predicate.");
//        System.out.println("27. Find the squares of the first three even numbers in a list.");
//        System.out.println("28. Flatten a list of lists");
    }

    private static void q1Solution(List<Integer> randomIntegers) {
        int sum = randomIntegers
                .stream()
                .mapToInt(Integer::intValue)
                .filter(e -> e % 2 == 0)
                .sum();
        System.out.println("Answer is: " + sum);
    }

    private static void q2Solution(List<Integer> randomIntegers) {
        int max = randomIntegers.stream().mapToInt(Integer::intValue).max().getAsInt();
        System.out.println("Answer is: " + max);
    }

    private static void q3Solution(List<String> randomStrings) {
        List<String> startWithT = randomStrings.stream().filter(s -> s.startsWith("t")).toList();
        System.out.println("Answer is: " + startWithT);
        List<String> startWithTCaseInsensitive = randomStrings.stream().filter(s -> s.toLowerCase().startsWith("t")).toList();
        System.out.println("Answer is: " + startWithTCaseInsensitive);
    }

    private static void q4Solution(List<String> randomStrings) {
        List<String> uppecaseAll = randomStrings.stream().map(String::toUpperCase).toList();
        System.out.println("Answer is: " + uppecaseAll);
    }

    private static void q5Solution(List<Integer> randomIntegers) {
        long totalNumberOfOdds = randomIntegers.stream().filter(e -> e % 2 == 1).count();
        System.out.println("Answer is: " + totalNumberOfOdds);
    }

    private static void q6Solution(List<Float> randomFloats) {
        double averageOfFloats = randomFloats.stream().mapToDouble(Double::valueOf).average().getAsDouble();
        System.out.println("Answer is: " + averageOfFloats);
    }

    private static void q7Solution(List<String> randomStrings) {
        String concatenatedStrings = randomStrings.stream().reduce("Answer is: ", (a, b) -> a + " " + b);
        System.out.println(concatenatedStrings);
    }

    private static void q8Solution(List<Object> randomObjects) {
        Set<Object> distinctObjects = randomObjects.stream().collect(Collectors.toSet());
        System.out.println("Answer is: " + distinctObjects);
        List<Object> distinctObjects2 = randomObjects.stream().distinct().toList();
        System.out.println("Answer2 is: " + distinctObjects2);
    }

    private static void q9Solution(List<CustomObject> randomCustomObjects) {
        List<CustomObject> sortedByFirstAttribute = randomCustomObjects.stream().sorted(Comparator.comparingInt(CustomObject::firstAttribute)).toList();
        System.out.println("Answer1 is: " + sortedByFirstAttribute);
        List<CustomObject> sortedBySecondAttribute = randomCustomObjects.stream().sorted(Comparator.comparingInt(CustomObject::secondAttribute)).toList();
        System.out.println("Answer2 is: " + sortedBySecondAttribute);
    }

    private static void q10Solution(List<CustomObject> randomCustomObjects) {
        boolean allWithAttr1LargerThanOne = randomCustomObjects.stream().allMatch(e -> e.firstAttribute() > 1);
        System.out.println("Answer1 is: " + allWithAttr1LargerThanOne);
        boolean allWithAttr1Positives = randomCustomObjects.stream().allMatch(e -> e.firstAttribute() > 0);
        System.out.println("Answer2 is: " + allWithAttr1Positives);
    }

    private static void q12Solution(List<String> randomStrings) {
        boolean containsUpperCaseWord = randomStrings.stream().anyMatch(e -> e.equals(e.toUpperCase()));
        System.out.println("Answer is: " + containsUpperCaseWord);
    }

    private static void q13Solution(List<String> randomStrings) {
        boolean containsDuplicates = randomStrings.stream().anyMatch(e -> Collections.frequency(randomStrings, e) > 1);
        System.out.println("Answer is: " + containsDuplicates);
    }

    private static void q14Solution(List<String> randomStrings) {
        int totalCharacters = randomStrings.stream().mapToInt(String::length).sum();
        System.out.println("Answer is: " + totalCharacters);
    }

    private record CustomObject(int firstAttribute, int secondAttribute) {
    }
}
