import java.util.Random;

public class RandomGen {

    public RandomGen(){}


    public static int[] randomIntArray(int num)
    {
        Random random = new Random();
        int[] ranArray = new int[num];
        for (int i = 0; i < num; i ++)
        {
            ranArray[i] = random.nextInt(1500);
        }

        return ranArray;

    }
}
