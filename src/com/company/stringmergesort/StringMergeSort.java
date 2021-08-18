package com.company.stringmergesort;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StringMergeSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> list = new LinkedList<>();
        System.out.println("Input a line of text: ");
        readInput(scanner, list);
        System.out.println("List before mergeSort: " + list);
        mergeSort(list);
        System.out.println("List after mergeSort: " + list);
    }

    public static void readInput(Scanner scanner, List<String> list){
        String line = scanner.nextLine();
        Scanner words = new Scanner(line);
        while (words.hasNext()){
            list.add(words.next());
        }
    }

    public static void mergeSort(List<String> list){
        // need base case - should be a single if statement
        if (list.size() > 1){
            List<String> left = new LinkedList<>(list.subList(0, list.size() / 2));
            List<String> right = new LinkedList<>(list.subList(list.size() / 2, list.size()));

            // recursively sort the two halves
            mergeSort(left);
            mergeSort(right);

            // merge the sorted left and right subLists together
            merge(list, left, right);
        }
    }

    public static void merge(List<String> result, List<String> left, List<String> right){
        int i1 = 0; // index for left
        int i2 = 0; // index for right

        for (int i = 0; i < result.size(); i++) {
            if (i2 >= right.size() || (i1 < left.size() && left.get(i1).compareToIgnoreCase(right.get(i2)) < 0)){
                result.remove(i);
                result.add(i, left.get(i1));
                i1++;
            } else {
                result.remove(i);
                result.add(i, right.get(i2));
                i2++;
            }
        }
    }
}
