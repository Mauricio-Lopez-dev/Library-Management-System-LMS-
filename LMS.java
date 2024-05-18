/*
 * Author: Mauricio Lopez Alvarez
 * Date Written: May 15, 2023
 * Purpose:... I have been asked to create a simple Library Management System(LMS). Features that will be
 *             implemented in the software are adding a book, removing a book in the list, and displaying
 *             all current books in the system.
 */

import java.util.*;

public class LMS
{
    // Global Variable
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args)
    {
        // Variable and Objects
        FileHandler fileHandler = new FileHandler();
        int choice = 0;

        do
        {
            choice = getOption();
            switch(choice)
            {
                case 1: // Add books
                    AppendBookList appendList = new AppendBookList(); // Continue here - validate the the ID
                    break;

                case 2: //Remove books
                    RemoveBook removeBook = new RemoveBook();
                    break;

                case 3: // Display all books
                    fileHandler.readFile();
                    System.out.println(fileHandler.toString());
                    break;

                case 4: // Exit system
                    System.out.print("Thank you for using LMS! Have a good day.\n");
                    break;

                default: // Invalid selection
                    System.out.println("Invalid selection, try again...");
                    break;
            }
        }while(choice != 4); // end switch
    } // end main

    public static int getOption()
    {
        // Output - Welcoming Message
        System.out.println("\t\tWelcome to Library Management System");
        System.out.println(" **************************************************");

        String option = "";

        option += "[1] Add a book to the inventory\n";
        option += "[2] Remove a book from the inventory\n";
        option += "[3] Display all current books\n";
        option += "[4] Exit system\n";

        return getInput(option);
    } // end geOption method

    public static int getInput(String option)
    {
        int choice = 0;
        boolean badInput = true;

        do
        {
            try
            {
             System.out.print(option + "Enter your choice: ");
             choice = in.nextInt();
             badInput = false;
            }
            catch(InputMismatchException e)
            {
                System.out.println("Error: Invaild input. Try again\n");
                badInput = true;
                in.nextLine();
            }
        }while(badInput);
        return choice;
    } // end getInput method

    public static void displayMessage(String message)
    {
        System.out.println(message);
    } // end displayMessage method
} // end LMS class