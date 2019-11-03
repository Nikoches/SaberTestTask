package PlayerNumberTest;

import PlayerNumber.PlayerNumber;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberTest {
    @Test
    void numTest() {
        List<Integer> integerList = new PlayerNumber().newCounter(6, 17);
        List<Integer> linkedList = Arrays.asList(6,15);
        assertEquals(integerList, linkedList);

    }
}
