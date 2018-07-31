import java.io.File;
import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

public class Test {

    public static void main(String[] args) {

        File file = new File("numbers.txt");
        Scanner scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.err.println("Błąd odczytu pliku");
            e.printStackTrace();
        }

        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        while (scan.hasNextInt()) {
            numbers.add(scan.nextInt());
        }

        System.out.println("Liczby wczytane z pliku: " + numbers);


        TreeMap<Integer, Integer> uniqueNumbers = new TreeMap<>();
        Integer key;
        Integer value;
        for (Integer number : numbers) {
            key = number;
            if (uniqueNumbers.containsKey(key)) {
                value = uniqueNumbers.get(key);
                uniqueNumbers.put(key, value + 1);
            } else uniqueNumbers.put(key, 1);
        }

        for (Integer tmp : uniqueNumbers.keySet()) {
            System.out.println(tmp + " liczba wystąpień " + uniqueNumbers.get(tmp));
        }
    }
}
