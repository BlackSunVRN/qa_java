import com.example.Cat;
import com.example.Feline;
import com.example.Predator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;
    Predator predator;

    @Test
    public void shouldCallGetFood() throws Exception {
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline).eatMeat();
    }

    @Test
    public void shouldSayMew() {
        Cat cat = new Cat(feline);
        String actual = cat.getSound();
        String expected = "Мяу";
        assertEquals(expected, actual);
    }
}
