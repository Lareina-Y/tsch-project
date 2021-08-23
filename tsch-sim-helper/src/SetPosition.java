import java.io.*;
import java.util.Scanner;

public class SetPosition {
    public static void main(String[] args) throws IOException {
        String filename = "position.txt"; //kb.nextLine(); //input the file

        //capture file information from user and read file
        //Reads from the input file position.txt
        File file = new File(filename);
        Scanner input = new Scanner(file);

        String outName = "out.txt";
        PrintWriter outputFile = new PrintWriter(new FileWriter(outName));

        //when the input is null, stop
        while (input.hasNext())
        {
            int id = input.nextInt();
            double x = input.nextDouble();
            double y = input.nextDouble();
            outputFile.println("{\"ID\": "+id+", \"X\": "+x+", \"Y\": "+y+"},");
        }
        input.close();
        outputFile.close();

        System.out.println("Data written into file " + outName);
    }
}
