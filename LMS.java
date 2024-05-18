/*
 * Author: Mauricio Lopez Alvarez
 * Course: CEN 3024C
 * Date Written: May 15, 2023
 * Class: Software Development I
 * Purpose & main method:...I have been asked to create a simple Library Management System(LMS). Features
 *                          that will be implemented in the software are adding a book, removing a book in
 *                          the list, and displaying all current books in the system. In this class it will
 *                          display a menu system. Also, it will handle the choice entered by the user to
 *                          determine which feature to execute. In the main method, FileHandle object is created
 *                          to read the text file before reaching the switch statement. Also, it will create all
 *                          necessary objects in its appropriate cases in its switch statement. Those objects call
 *                          their associating constructors to execute the feature of the system chosen by the user.
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

    /*
     * Method name: getOption()
     * Purpose:...This method build the menu options and stored into a string.
     * Arguments: Zero arguments for this method.
     * Return value: The return value is an integer. To obtain the return value it will
     *               call the getInput(option) method with variable option as its pasing argument.
     */
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
    } // end getOption method

    /*
     * Method name: getInput(String option)
     * Purpose:...This method prompts the user to enter their choice of feature.
     * Arguments: String option; the menu is displayed from the arguement String option.
     * Return value: The return value is the result from choice entered by the user of type int.
     */
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
} // end LMS class