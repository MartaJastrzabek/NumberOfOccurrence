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
                Integer x = Integer.valueOf(line);
                list.add(x);
                set.add(x);
            }
        } catch (IOException e){
            System.out.println(e.getMessage());
        } catch (NumberFormatException e){
            System.out.println("Program natrafił na nie prawidłowy format w pliku.");
        }

        if(set.isEmpty()){
            System.out.println("Error!");
        } else {
            System.out.println(getOccurrenceNumbers(list, set));
        }
    }

    private static String getOccurrenceNumbers(List<Integer> list, Set<Integer> set) {
        String occurrence = "";
        for(Integer i : set){
            occurrence += i + " - liczba wystąpień: " + Collections.frequency(list, i) + "\n";
        }
        return occurrence;
    }
}
