import java.io.*;
import java.util.Scanner;

public class PdrFind {
    public static void main(String[] args) throws IOException {
        String filename;

        String outName = "outList.txt";
        PrintWriter outputFile = new PrintWriter(new FileWriter(outName));
        outputFile.println("PDR Links# latency collision slotCycle slotCycleRatio");

        for (int i=0; i<100; i++) {
            if(i == 0){
                filename = "log.txt";
            } else {
                filename = "log_" + (i) + ".txt";
            }

            System.out.println(filename);

            //capture file information from user and read file
            //Reads from the input file position.txt
            File file = new File(filename);
            Scanner input = new Scanner(file);

            int n, m;
            String pdr = "PDR=";
            String latency = "latency=";
            String slotCycle = "slot cycle=";
            String slotCycleRatio = "slot cycle ratio=";
            String links = "Links#=";
            String collision = "collision=";

            while (input.hasNextLine()) {
                String line = input.nextLine();
                if (line.contains(pdr)) {
                    n = line.indexOf(pdr);
                    m = line.indexOf(" ", n);
                    outputFile.print(line.substring(n + pdr.length(), m) + " ");
                }

                if (line.contains(links)) {
                    n = line.indexOf(links);
                    m = line.indexOf(" ", n);
                    outputFile.print(line.substring(n + links.length(), m) + " ");
                }

                if (line.contains(latency)) {
                    n = line.indexOf(latency);
                    m = line.indexOf(" ", n);
                    outputFile.print(line.substring(n + latency.length(), m) + " ");

                    n = line.indexOf(collision);
                    m = line.indexOf(" ", n);
                    outputFile.print(line.substring(n + collision.length(), m) + " ");

                    n = line.indexOf(slotCycle);
                    m = line.indexOf(" ", n + slotCycle.length());
                    outputFile.print(line.substring(n + slotCycle.length(), m) + " ");

                    n = line.indexOf(slotCycleRatio);
                    outputFile.println(line.substring(n + slotCycleRatio.length()));
                }
            }

            input.close();
        }

        outputFile.close();
        System.out.println("Data written into file " + outName);
    }
}
