/*
 * Author: Mauricio Lopez Alvarez
 * Course: CEN 3024C
 * Date Written: May 15, 2023
 * Class: Software Development I
 * Purpose:...RemoveBook is a feature of the software. It enables a user to remove a book from the system
 *            by providing an existing ID number.
 */

import java.util.*;

public class RemoveBook extends FileHandler
{
    // Data fields
    private int bookID;

    public RemoveBook()
    {
        removeOption();
    } // end default constructor

    public int getBookID()
    {
        return bookID;
    } // end accessor method

    public void setBookID(int bookID)
    {
        this.bookID = bookID;
    } // end mutator method

    /*
     * Method name: removeOption()
     * Purpose:...Prompts the user to enter an existing ID number to remove the book from the system.
     * Arguments: Zero arguments
     * Return value: None; no return value for this method
     */
    public void removeOption()
    {
        // Variables
        Scanner in = new Scanner(System.in);
        String filePath = "../LibraryManagementSystem/ListOfBooks.txt";
        int size = getData().size();
        boolean badInput = true;

        do
        {
            // Input
            System.out.print("Enter ID number of book to remove from the system: ");
            bookID = in.nextInt();
            try
            {
                if(bookID <= size && bookID >= 0)
                {
                    // Mutator
                    setBookID(bookID);

                    // Remove book from records
                    removeBook(filePath, bookID);

                    // Output
                    System.out.println("***Book Removed***");
                    badInput = false;
                }
                else
                {
                    System.out.println("Error: ID number not found!");
                    badInput = true;
                }
            }
            catch (Exception e)
            {
                System.out.println("Error: " + e.getMessage());
            }
        }while(badInput);
    } // end removeBook method
} // end RemoveBook class
