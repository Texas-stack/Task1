import static org.junit.Assert.*;

import org.example.StreamExamples;
import org.junit.Before;
import org.junit.Test;
import java.util.*;

public class StreamExamplesTest {

    private StreamExamples streamExamples;
    private List<Integer> numbers;
    private List<String> strings;
    private int[] array;
    private List<StreamExamples.Person> people;

    @Before
    public void setUp() {
        streamExamples = new StreamExamples();
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        strings = Arrays.asList("apple", "banana", "cherry", "date");
        array = new int[]{1, 2, 3, 4, 5, 6};
        people = Arrays.asList(
                new StreamExamples.Person("Alice", 25),
                new StreamExamples.Person("Bob", 30),
                new StreamExamples.Person("Charlie", 25)
        );
    }

    @Test
    public void testFilterAndSortEvenNumbers() {
        List<Integer> expected = Arrays.asList(2, 4, 6);
        assertEquals(expected, streamExamples.filterAndSortEvenNumbers(numbers));
    }

    @Test
    public void testToUpperCase() {
        List<String> expected = Arrays.asList("APPLE", "BANANA", "CHERRY", "DATE");
        assertEquals(expected, streamExamples.toUpperCase(strings));
    }

    @Test
    public void testSumArrayElements() {
        int expected = 21;
        assertEquals(expected, streamExamples.sumArrayElements(array));
    }

    @Test
    public void testGroupByAgeAndCalculateAverage() {
        Map<Integer, Double> expected = new HashMap<>();
        expected.put(25, 25.0);
        expected.put(30, 30.0);
        assertEquals(expected, streamExamples.groupByAgeAndCalculateAverage(people));
    }

    @Test
    public void testFilterByLengthAndFindFirst() {
        Optional<String> expected = Optional.of("banana");
        assertEquals(expected, streamExamples.filterByLengthAndFindFirst(strings));
    }

    // Для тестирования параллельных стримов результаты могут варьироваться,
    // поэтому этот тест может быть нестабильным и требовать дополнительной настройки.

    // Тестирование метода readFileAndFilterLines может быть сложным без мокирования файловой системы,
    // поэтому этот тест опущен.

    // Тестирование метода filterStreamWithConversion также опущено,
    // так как он требует создания стрима с неопределенными типами данных.
}
