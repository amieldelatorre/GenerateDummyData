import org.classes.User;
import org.classes.Weight;
import org.randomobjects.GenerateRandom;

public class Main {
    public static void main(String[] args) {
        GenerateRandom random = new GenerateRandom();
        User randomUser = random.generateRandomUser();
        //Weight randomWeight = random.generateRandomWeight();
    }
}