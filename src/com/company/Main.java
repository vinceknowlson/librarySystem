package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final ArrayList<String> bookList;

    static {
        bookList = new ArrayList<>();
    }

    public static void main(String[] args) {

        int booksNumber = Integer.parseInt(getInput("How many books would you like to add?"));
        for (int i = 0; i < booksNumber; i++) {
            bookList.add(getBookDetails());
        }

        printBookDetails();

    }

    public static String getInput(String prompt) {
        System.out.println(prompt);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static String getBookDetails() {
        String bookTitle = getInput("What is the title of the book?");
        String bookGenre = getInput("What is the genre of the book?");
        String bookISBN = getInput("What is the ISBN of the book?");
        String bookAuthor = getInput("Who is the author of the book?");
        return (bookTitle + "," + bookGenre + "," + bookISBN + "," + bookAuthor);
    }

    public static void printBookDetails() {
        for (String s : bookList) {
            System.out.println(s);
        }
    }
}
