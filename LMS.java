/*
 * Author: Mauricio Lopez Alvarez
 * Date Written: May 15, 2023
 * Purpose:... I have been asked to create a simple Library Management System(LMS). Features that will be
 *             implemented in the software are adding a book, removing a book in the list, and displaying
 *             all current books in the system.
 */

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;

public class LMS
{
    public static void main(String[] args)
    {
        // Variables and Paths
        int userChoice = 0;
        Path path = Paths.get("../LibraryManagementSystem/ListOfBooks.txt");
        List<String> data = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        boolean badInput = true;

        // Welcoming Message
        System.out.println("\t\tWelcome to Library Management System");
        System.out.println(" **************************************************");

        do
        {
            try
            {
                System.out.println("Please select one of the following options:");
                displayList();
                userChoice = in.nextInt();
                badInput = false;

            }
            catch(InputMismatchException e)
            {
                System.out.println("*Please select a valid option!*");
                in.nextLine();
                badInput = true;
            }

        }while(badInput);

        data = readFile(path.toString());


    } // end Main

    public static void displayList()
    {
        System.out.println("1. Add a book to the inventory");
        System.out.println("2. Remove a book from the inventory");
        System.out.println("3. Show all the books");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    } // end displayMenu method

    public static List<String> readFile(String file)
    {
        List<String> data = new ArrayList<>();
        Path path = Paths.get(file);

        try
        {
            // Opens file
            BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset());
            String line = br.readLine();

            System.out.println(" **************************************************");
            System.out.println("Current books in the system");
            while(line != null)
            {
                System.out.println(line);
                data.add(line.toString());
                line = br.readLine();

            } // end while loop

            // Close stream
            br.close();
        }
        catch(IOException e)
        {
            System.out.println("Error: File not found");
        } // end try catch
        return data;
    } // end readFile method

    public static void systemOptions(int choice)
    {
        switch(choice)
        {
            case 1:
                // Add Books
               break;

            case 2:
                //Remove books
                break;

            case 3:
                // Display list
                break;
        } // end switch

    } // end systemFeatures method



} // end LMS class