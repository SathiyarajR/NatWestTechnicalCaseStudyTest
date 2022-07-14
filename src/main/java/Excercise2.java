import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Excercise2 {

    public static void main(String[] args) {
        //Method to find number of files starting with T or  end in S from root directory

        try {
            BufferedReader bufr = null;

            File file = new File(".\\src\\main\\resources\\TestFile.dat");
//            File file = new File(System.getProperty("user.dir");+\\"TestFile.dat");


            FileReader fr = new FileReader(file);
            bufr = new BufferedReader(fr);
            String line;
            //printing the contents of file
            System.out.println("Contents of File \n");
            while ((line = bufr.readLine()) != null) {
                System.out.println(line);
            }

            Scanner scan = new Scanner(file);
            int countofStartingTEndingS = 0;

            //counting the number of files start with T or end in S
            while (scan.hasNext()) {
                String word = scan.next();
                if (((word.toLowerCase()) != word) && (word.endsWith("S") || (word.startsWith("T")))) {
                    countofStartingTEndingS++;
                }
            }
            System.out.println("\n Number of files starting with T or ending with S \t" + countofStartingTEndingS);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}