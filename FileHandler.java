/*
 * Author: Mauricio Lopez Alvarez
 * Course: CEN 3024C
 * Date Written: May 15, 2023
 * Class: Software Development I
 * Purpose:...FileHandler class handles the file created for the user. It will open, read, write, and replace
 *            current text file associated with this software. The data captured from the text file is stored
 *            in a ArrayList to provide a dynamic array. This creates a mutable array and has no constraints
 *            of size from the text file.
 */

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;

public class FileHandler
{
    // Data fields
    private ArrayList<String> data;
    private Path path = Paths.get("../LibraryManagementSystem/ListOfBooks.txt");

    public FileHandler()
    {
        readFile();
    } // end default constructor

    public ArrayList<String> getData()
    {
        return data;
    } // end accessor method

    public void setData(ArrayList<String> data)
    {
        this.data = data;
    } // end mutator method

    /*
     * Method name: toString()
     * Purpose:...This method will store all the current information from the variable data. Also, will allow
     *            to display all current content from the file.
     * Arguments: Zero arguements
     * Return value: Returns value of type String.
     */
    @Override
    public String toString()
    {
        String result = "";
        result += " **************************************************\n";
        result += "Current books in the system";

        for(String line: data)
        {
            result += "\n" + line;
        } // end for loop
        return result;
    } // end toString method

    /*
     * Method name: ArrayList<String> readFile()
     * Purpose:...This method will open and read the file provided from the path variable.
     *            Its contents are then stored into the variable data to modify and/or view it's content.
     * Arguments: Zero arguments
     * Return value: The return value is data of type ArrayList<String>
     */
    public ArrayList<String> readFile()
    {
       data = new ArrayList<>();

        try
        {
            // Opens file
            BufferedReader br = Files.newBufferedReader(path, Charset.defaultCharset());
            String line = br.readLine();

            while(line != null)
            {
                data.add(line);
                line = br.readLine();
            } // end while loop

            setData(data);
            // Close stream
            br.close();
        }
        catch(IOException e)
        {
            System.out.println("Error: File not found");
        } // end try catch

        return data;
    } // end readFile method

    /*
     * Method name: writeFile()
     * Purpose:...Provides function to enable a user to add book in the switch statement in the main().
     *            The data is received by its argument.
     * Arguments: StringBuilder newInfo
     * Return value: None; no return value for this method.
     */
    public void writeFile(StringBuilder newInfo)
    {
        // Variables
        boolean badInput = true;
        Charset charset = Charset.defaultCharset();

        try(BufferedWriter bufferWriter = Files.newBufferedWriter(path, charset, StandardOpenOption.WRITE);
                PrintWriter printWriter = new PrintWriter(new FileWriter(path.toFile(), true), true))
        {
                    printWriter.append(newInfo.toString());
                    System.out.println("***File written successfully***");
        }
        catch(Exception e)
        {
            System.out.println("Error: File not writable");
        } // end try catch
    } // end writeFIle method

    /*
     * Method name: removeBook()
     * Purpose:...Provides function to enable a user to remove a book from the text file.
     *            While it iterates through the old file it determines what line not insert
     *            into the new file from the argument deleteLine.
     * Arguments: String filepath, int deleteLine
     * Return value: None: no return value for this method.
     */
    public void removeBook(String filepath, int deleteLine)
    {
        String tempFile = "temp.txt";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);

        int line = 0;
        String currentLine;

        try
        {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);

            while((currentLine = br.readLine()) != null)
            {
                line++;
                if(deleteLine != line)
                {
                    pw.println(currentLine);
                }
            }

            pw.flush();
            pw.close();
            fr.close();
            br.close();
            fw.close();

            // Delete old file
            oldFile.delete();
            File dump = new File(filepath);
            newFile.renameTo(dump);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    } // end removeBook method
} // end FileHandler class