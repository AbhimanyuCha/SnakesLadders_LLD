import java.util.Random;

public class SquareDice implements Dice{
    int range = 6;

    public int getRandomNumer() {
        Random r = new Random();
        int result = r.nextInt(range-1) + 1;
        return result;
    }
}
