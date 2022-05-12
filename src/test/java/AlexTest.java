import com.example.Alex;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class AlexTest {

    @Mock
    Feline feline;

    @Test
    public void shouldSeeAlexFriendsList() throws Exception {
        Alex alex = new Alex(feline);
        List<String> actual = alex.getFriends();
        List<String> expected = Arrays.asList("Марти", "Глория", "Мелман");
        assertEquals(expected, actual);
    }

    @Test
    public void shouldSeePlaceOfLiving() throws Exception {
        Alex alex = new Alex(feline);
        String actual = alex.getPlaceOfLiving();
        assertEquals("Нью-Йоркский зоопарк", actual);
    }

    @Test
    public void shouldReturnZeroKittens() throws Exception {
        Alex alex = new Alex(feline);
        int actual = alex.getKittens();
        assertEquals(0, actual);
    }

    @Test
    public void shouldReturnTrueForMane() throws Exception {
        Alex alex = new Alex(feline);
        boolean actual = alex.doesHaveMane();
        assertTrue(actual);
    }

    @Test
    public void shouldCallPredatorFood() throws Exception {
        Alex alex = new Alex(feline);
        alex.getFood();
        Mockito.verify(feline).getFood("Хищник");
    }

}
