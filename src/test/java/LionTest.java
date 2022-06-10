import com.example.Animal;
import com.example.Feline;
import com.example.Lion;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionTest {

    private final String lionSex;
    private final boolean hasMane;

    public LionTest(String lionSex, boolean hasMane) {
        this.lionSex = lionSex;
        this.hasMane = hasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getManeForLion() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Mock
    Feline feline;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void shouldReturnLionsMane() throws Exception {
        Lion lion = new Lion(lionSex, feline);
        boolean expected = hasMane;
        assertEquals(expected, lion.doesHaveMane());
    }

    @Test
    public void shouldCallGetKittens() throws Exception {
        Lion lion = new Lion(lionSex, feline);
        lion.getKittens();
        Mockito.verify(feline).getKittens();
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowExceptionForIncorrectAnimalKind() throws Exception {
        thrown.expect(Exception.class);
        thrown.expectMessage("Используйте допустимые значения пола животного - самец или самка");
        Lion lion = new Lion("other", feline);
    }

    @Test
    public void shouldCallGetFood() throws Exception {
        Lion lion = new Lion(lionSex, feline);
        lion.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }
}
