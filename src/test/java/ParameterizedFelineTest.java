import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ParameterizedFelineTest {

    private final int kittenCount;
    private final int expected;

    public ParameterizedFelineTest(int kittenCount, int expected) {
        this.kittenCount = kittenCount;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getKittensCount() {
        return new Object[][] {
                {0, 0},
                {1, 1},
                {3, 3},
        };
    }

    @Test
    public void shouldReturnKittensCount() {
        Feline feline = new Feline();
        int actual = feline.getKittens(kittenCount);
        assertEquals(expected, actual);
    }
}
