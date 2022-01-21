package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static final ArrayList<String> bookList;
    private static final File myFile = new File("myLogins.txt");
    private static final Scanner scanner = new Scanner(System.in);

    static {
        bookList = new ArrayList<>();
    }

    public static void main(String[] args) {
        createFile();

        System.out.println("Are you registering (R) or logging in (L)");
        String userOption = scanner.next();
        if (userOption.equals("R")) {
            writeToFile(("\n" + getRegisterDetails()));
            String userDetails = getRegisterDetails();
            writeToFile(userDetails);
        } else {
            checkLogin();

        }

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

    public static void createFile() {
        try {
            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static boolean checkLogin(String userData) {
        boolean registeredUser = false;
        try {
            Scanner myReader = new Scanner(myFile);
            while (!registeredUser) {
                String data = "";
                try {
                    data = myReader.nextLine();
                } catch (Exception e) {
                    return registeredUser;
                }
                if (data.equals(userData)) {
                    registeredUser = true;
                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println("a");
        return registeredUser;
    }

    public static void writeToFile(String userDetails) {
        try {
            FileWriter myWriter = new FileWriter(myFile.getName(), false);
            System.out.println("This is the contents of the file:");
            myWriter.write(userDetails);
            myWriter.close();
            System.out.println("Successfully stored details");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void readFile(String userLogin) {
        try {
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                if (data.equals(userLogin)) {


                } else {

                }

            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static String getRegisterDetails() {
        String registerLogin = getInput("What is your desired username?");
        String registerPassword = getInput("What is your desired password?");
        return (registerLogin + "," + registerPassword);
    }

    public static void storeLogin() {
        String userName = getInput("What is your username?");
        String userPassword = getInput("What is your password?");
        String userLogin = (userName + "," + userPassword);
        readFile(userLogin);
    }
}