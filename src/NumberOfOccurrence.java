import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class NumberOfOccurrence {
    private static final String INPUT_FILE = "numbers.txt";

    public static void main(String[] args) {
        File file = new File(INPUT_FILE);
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new TreeSet<>();

        try(
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr)
                ){
            String line = "";
            while ((line = br.readLine())!= null){
                list.add(Integer.valueOf(line));
                set.add(Integer.valueOf(line));
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        }


        System.out.println(getOccurrenceNumbers(list, set));
    }

    private static String getOccurrenceNumbers(List<Integer> list, Set<Integer> set) {
        String occurrence = "";
        for(Integer i : set){
            occurrence += i + " - liczba wystąpień: " + Collections.frequency(list, i) + "\n";
        }
        return occurrence;
    }
}
