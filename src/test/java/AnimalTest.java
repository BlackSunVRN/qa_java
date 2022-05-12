import com.example.Animal;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AnimalTest {

    @Mock
    Animal animal;

    @Test
    public void shouldCallGetFoodWithPredatorKind() throws Exception {
        animal.getFood("Хищник");
        Mockito.verify(animal).getFood("Хищник");
    }

    @Test
    public void shouldCallGetFamily() {
        animal.getFamily();
        Mockito.verify(animal).getFamily();
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void shouldThrowExceptionForIncorrectAnimalKind() throws Exception {
        Animal animal = new Animal();
        thrown.expect(Exception.class);
        thrown.expectMessage("Неизвестный вид животного, используйте значение Травоядное или Хищник");
        animal.getFood("Other");
    }

    @Test
    public void shouldGetCorrectAnswerForGetFood() {
        Animal animal = new Animal();
        String actual = animal.getFamily();
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        assertEquals(expected, actual);
    }

}
