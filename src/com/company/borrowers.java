package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class borrowers {

    private static final File newFile = new File("myBorrowers.txt");
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        createFile();

        System.out.println("Would you like to borrow a file? 'yes' or 'no'");
        String response = scanner.next();
        if (response.equals("yes")) {

            writeToFile();
        } else {

        }
    }


    public static void createFile() {
        try {
            if (newFile.createNewFile()) {
                System.out.println("File created: " + newFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeToFile(String borrowDetails) {
        try {
            FileWriter myWriter = new FileWriter(newFile.getName(), false);
            System.out.println("This is the contents of the file:");
            myWriter.write(borrowDetails);
            myWriter.close();
            System.out.println("Successfully stored borrow details");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
