package GameStore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFileLineByLineUsingBufferedReader {

    public static ArrayList<String> readFile() {

        ArrayList<String> Strings = new ArrayList<String>();


        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "Appendix1.csv"));
            String line = reader.readLine();
            while (line != null) {
//                System.out.println(line);

                Strings.add(line);
//                System.out.println("FF F " +  line);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
//    System.out.println(sequence1);
        return Strings;

    }



    public static void main(String[] args) {
        ArrayList<String> sequence;
        sequence = readFile();
//
//
        System.out.println("--------------------------");
        String[] x = sequence.get(2).split(",");
        System.out.println(sequence.get(21));
        System.out.println(sequence.get(22));
    }


}

