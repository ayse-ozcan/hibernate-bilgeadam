package com.ayseozcan.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class BAUtils {
    private static Scanner scan = new Scanner(System.in);
    public static int menu(HashMap<Integer, String> menuItems) {
        boolean correctAnswer = false;
        int selection = -1;
        do {
            showMenuItems(menuItems);
            selection = getUserSelection();
            correctAnswer = evaluateAnswer(menuItems, selection);
        } while (!correctAnswer);
        return selection;
    }

    private static boolean evaluateAnswer(HashMap<Integer, String> menuItems, int selection) {
        return menuItems.containsKey(selection);
    }

    private static int getUserSelection() {
        return readInt("Lutfen seciminizi yapin");
    }

    private static void showMenuItems(HashMap<Integer, String> menuItems) {
        ArrayList<Integer> keys = new ArrayList<Integer>(menuItems.keySet());
        Collections.sort(keys);
        for (Integer key : keys) {
            System.out.println("\t(" + key + ") .... " + menuItems.get(key).trim());
        }
        System.out.println();
    }

    public static void header(String title) {

        int len = title.length();
        StringBuilder row = new StringBuilder("");
        for (int i = 0; i < (len + 6); i++) {
            row.append("=");
        }
        System.err.println("\n\n\t\t" + row);
        System.err.println("\t\t** " + title.toUpperCase() + " **");
        System.err.println("\t\t" + row + "\n");
    }

    public static String readString(String query) {
        showQuery(query);
        String retVal = scan.nextLine();
        return retVal;
    }

    private static void showQuery(String query) {
        System.out.print("\t" + query + ": ");
    }

    public static int readInt(String query) {
        int retVal = Integer.MIN_VALUE;
        showQuery(query);
        try {
            retVal = scan.nextInt();
        } catch (Exception e) {
            System.out.println("Lutfen sayi giriniz: ");
        } finally {
            scan.nextLine();
        }
        return retVal;
    }

    public static int[] readInt(String start, String query, int numElements) {
        showQuery(start + " " + numElements + " " + query + "\n");
        int[] retVal = new int[numElements];
        for (int i = 0; i < numElements; i++) {
            System.out.print((i + 1) + ". degeri giriniz: ");
            retVal[i] = scan.nextInt();
        }
        scan.nextLine();
        return retVal;
    }

    public static double readDouble(String query) {
        double retVal = Double.NEGATIVE_INFINITY;
        showQuery(query);
        retVal = scan.nextDouble();
        scan.nextLine();
        return retVal;
    }
}
