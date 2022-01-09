package dsa;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class mergesortdesc{
public static void sort(char[] chars, int low, int right) {
    if (low < right) {
        int middle = (low + right) / 2;
        sort(chars, low, middle);
        sort(chars, middle + 1, right);
        merge(chars, low, middle, right);
    }
}

public static void merge(char[] chars, int low, int middle, int right) {
    Queue<Character> queue1 = new LinkedList<Character>();
    Queue<Character> queue2 = new LinkedList<Character>();

    for (int i = low; i <= middle; i++) {
        queue1.add(chars[i]);
    } 

    for (int i = middle + 1; i <= right; i++) {
        queue2.add(chars[i]);
    }

    int i = low;

    while (!queue1.isEmpty() && !queue2.isEmpty()) {
        if (queue1.peek() <= queue2.peek()) {
            chars[i++] = queue1.poll();
        } else {
            chars[i++] = queue2.poll();
        }
    }

    while (!queue1.isEmpty()) {
        chars[i++] = queue1.poll();
    }

    while (!queue2.isEmpty()) {
        chars[i++] = queue2.poll();
    }
}

public static void sort(char[] chars) {
    sort(chars, 0, chars.length - 1);
}

public static void sort(String string) {
    sort(string.toCharArray());
}

public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
    String string = sc.nextLine();
    char[] chars = string.toCharArray();

    mergesortdesc.sort(chars);

    for (int i = chars.length-1; i >=0; i--) {
        
        System.out.print(chars[i]);
        if (i >= 0) { System.out.print(", "); }
    }
}
}
