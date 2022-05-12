import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

@RunWith(Parameterized.class)
public class ParameterizedAnimalTest {

    private final String animalKind;
    private final List<String> expected;

    public ParameterizedAnimalTest(String animalKind, List<String> expected) {
        this.animalKind = animalKind;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getAnimalKind() {
        List<String> predatorsList = List.of("Животные", "Птицы", "Рыба");
        List<String> herbivoreList = List.of("Трава", "Различные растения");
        return new Object[][] {
                {"Хищник", predatorsList},
                {"Травоядное", herbivoreList},
        };
    }

    @Test
    public void shouldReturnFoodListForAnimalKind() throws Exception {
        Animal animal = new Animal();
        List<String> actual = animal.getFood(animalKind);
        Assert.assertEquals(expected, actual);
    }

}
