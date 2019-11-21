import javax.swing.*;

public class EnumTest {

    private enum Season{Spring, Summer, Autumn, Winter}

    public EnumTest(){
        testMethod1(Season.Spring);
    }

    public static void main(String[] args)
    {
        EnumTest enumTest = new EnumTest();
    }

    public void testMethod1(Season season)
    {
        if (season == Season.Spring)
        {
            System.out.println("This is Spring");
        }
    }

}
