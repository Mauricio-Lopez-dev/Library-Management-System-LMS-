/*
 * Author: Mauricio Lopez Alvarez
 * Course: CEN 3024C
 * Date Written: May 15, 2023
 * Class: Software Development I
 * Purpose:...AppendBookList is a feature of the software. It enables a user to add books to the current text
 *            file. This class is utilized in case 1 of the switch statement.
 */

import java.util.*;

public class AppendBookList extends FileHandler
{
    // Data fields
    private int id;
    private String title;
    private String author;

    public AppendBookList()
    {
        appendBook();
    }// end default constructor

    public int getId()
    {
        return id;
    } // end accessor method

    public void setId(int id)
    {
        this.id = id;
    } // end mutator method

    public String getTitle()
    {
        return title;
    } // end accessor method

    public void setTitle(String title)
    {
        this.title = title;
    } // end mutator method

    public String getAuthor()
    {
        return author;
    } // end accessor method

    public void setAuthor(String author)
    {
        this.author = author;
    } // end mutator method

    /*
     * Method name: appendBook()
     * Purpose:...Prompts the user to enter the required data to add the book to the system.
     * Arguments: Zero arguments
     * Return value: None; no return value for this method
     */
    public void appendBook()
    {
        // Variables
        Scanner in = new Scanner(System.in);
        boolean badInput = true;
        int size = getData().size();
        StringBuilder newData = new StringBuilder();

        do
        {
            try
            {
                do
                {
                    // Adding book
                    System.out.print("Enter a unique ID of the book: ");
                    id = in.nextInt();
                    in.nextLine();

                    if(id <= size && id > 0)
                    {
                        System.out.println("Error: ID number " + id + " is already in use.");
                        badInput = true;
                    }
                    else if (id >= size)
                    {
                        System.out.print("Enter the title of the book: ");
                        title = in.nextLine();
                        System.out.print("Enter the author of the book: ");
                        author = in.nextLine();

                        // mutators
                        setId(id);
                        setTitle(title);
                        setAuthor(author);

                        // Append newData
                        newData.append("\n" + id + ", " + title + ", " + author);
                        writeFile(newData);
                        badInput = false;
                    }
                    else
                    {
                        System.out.println("ID number cannot start with a negative number");
                        badInput = true;
                    } // end if-else
                }while(badInput);
            }
            catch(InputMismatchException e)
            {
                System.out.print("Error: Invalid input. Try again. ");
                in.nextLine();
                badInput = true;
            } // end try catch
        }while(badInput);
    } // end appendBook method
} // end AppendBookList
