import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.*;

public class FileHandler
{
    // Data Field
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

    @Override
    public String toString()
    {
        String result = "";

        result += " **************************************************\n";
        result += "Current books in the system";

        for(String line: data)
        {
            result += "\n" + line;
        }

        return result;
    } // end toString method

    public ArrayList<String> readFile()
    {
        // Variables and Path
        ArrayList<String> data = new ArrayList<>();


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