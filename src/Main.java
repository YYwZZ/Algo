import java.util.InputMismatchException;
import java.util.Stack;


public class Main {

    public static void main(String[] args)
    {
        int[] a = RandomGen.randomIntArray(1000);
        int[] b = {3,10,1,2,3,4,5,6,8,9,10,11,12,13};
        int[] c = {5,3};
        int[] mergeArray = {110,9,22,1,3,5,7,11,2,4,6,8,10,12,14,16,17,1,2,13,4,530};

        //merge(mergeArray, 2, 7, 16);
        partition(c,0, 1);
        printArray(c);

//        printArray(a);
//        StopWatch stopWatch = new StopWatch();
//        mergeSortFor(a);
//        System.out.println("Time is: " + stopWatch.elapsedTime());
//        System.out.print("-----------");
//        printArray(a);
//        assert  isSorted(a);

        // A very simple test of recursive to warm up
        //System.out.println("sum 100 is: " + sum(100));



        /*for (int i = 0;i < mergeArray.length; i++)
        {
            System.out.println(mergeArray[i]);
        }*/



        System.out.println("---------------");
        //selectSort(a);
        //insertSort(a);
        //isSorted(a);
        //exchange(b, 3,4);




        //assert isSorted(a);


    }

    public static boolean isSorted(int[] a)
    {
        boolean sort = true;
        if(a.length <= 1 )
        {
            sort = true;
        }

        for (int i = 0; i < a.length - 1; i++)
        {
            if (a[i] > a[i+1]) {
                sort = false;
            }
        }
        return sort;
    }

    public static void exchange(int[] array, int indexF, int indexS)
    {
        //if (indexF >= array.length || indexS >= array.length)
           // throw new IndexOutOfBoundsException("Wrong Index");

        int a = array[indexF];
        array[indexF] = array[indexS];
        array[indexS] = a;
    }

    public static int[] selectSort(int[] inputA)
    {

        //Select the smallest from inputA
        for (int i = 0; i < inputA.length; i++)
        {
            for (int j = i; j < inputA.length; j++)
            {
                if (inputA[j] < inputA[i])
                {
                    exchange(inputA, i, j);
                }
            }

        }
        return inputA;
    }

    public static int[] insertSort(int[] inputA)
    {
        for (int i = 0; i < inputA.length; i++)
        {
            int a = inputA[i];
            //i is also the index where a come from
            //aindex is the final index that a will go to
            //System.out.println("Now a is: " + a);
            for (int j = 0; j < i; j++)
            {
                if (a >= inputA[j] && a <= inputA[j+1])
                {
                    //System.out.println("Situation 1");
                    shiftRight(inputA, j+1, i);
                    /*for (int l = 0; l < inputA.length ; l++)
                    {
                        System.out.print(inputA[l] + " ");
                    }*/
                    break;
                }
                if (a < inputA[j]){
                    //System.out.println("Situation 2");
                    shiftRight(inputA, 0, i);
                    /*for (int l = 0; l < inputA.length ; l++)
                    {
                        System.out.print(inputA[l] + " ");
                    }*/
                    break;
                }
            }
        }
        return inputA;
    }

    public static void merge(int[] inputA, int lo, int mi, int hi)
    {
        int i = lo;
        int j = mi+1;

        int[] aux = new int[hi - lo + 1];

        // Copy an auxiliary array of input Array.
        for (int k = 0; k < aux.length; k++)
        {
            aux[k] = inputA[lo + k];
        }



        for (int k = 0; k < aux.length; k++)
        {
            // if the left part is gone, use the rest of right
            if (i > mi)
            {
                inputA[lo + k] = aux[j - lo];
                j++;
            }
            // if the right part is gone, use the rest of left
            else if (j > hi)
            {
                inputA[lo + k] = aux[i - lo];
                i++;
            }
            // if current lo is less than current mi, use current lo
            else if (aux[i - lo] < aux[j - lo])
            {
                inputA[lo + k] = aux[i - lo];
                i++;
            }
            // if current mi is less than current lo, use current mi
            else
            {
                inputA[lo + k] = aux[j-lo];
                j++;
            }
        }
    }


    // merge method that write use right shift, which is a kind of
    // that do not really need parameter mi
    public static int[] merge1(int[] inputA, int lo, int mi, int hi)
    {
        for (int i = mi + 1; i < hi; i++)
        {
            int a = inputA[i];
            for (int j = lo; j < i; j++)
            {
                if (a >= inputA[j] && a <= inputA[j+1])
                {
                    System.out.println("Situation 1 and a is: " + a);
                    shiftRight(inputA, j + 1, i);
                    for (int k = 0; k< inputA.length; k++)
                    {
                        System.out.print(inputA[k] + " ");
                    }
                    System.out.println("------------------");
                    break;
                }
                if (a < inputA[j])
                {
                    System.out.println("Situation 2 and a is: " + a);
                    shiftRight(inputA, 0, i);
                    for (int k = 0; k< inputA.length; k++)
                    {
                        System.out.print(inputA[k] + " ");
                    }
                    System.out.println("------------------");
                    break;
                }

            }
        }
        return inputA;
    }

    public static int[] mergeSortFor(int[] inputA)
    {
        int length = inputA.length;
        for (int i = 1; i < length; i = 2 * i)
        {
            //System.out.println("Current i is: " + i);
            for (int j = 0; j < length; j = j + 2*i)
            {
                // current j represent the lo in merge
                int hi = min(length - 1, j + 2*i - 1);
                int mid = j + (2*i - 1)/2;
                merge(inputA, j, mid, hi);
                //System.out.println("current merge result is: ");
                /*for (int k = 0; k < inputA.length; k++)
                {
                    System.out.print(inputA[k] + " ");
                }
                System.out.println("");
                System.out.println("----------------");*/
            }
        }


        return inputA;
    }

    // We will discuss this method later
    public static int[] mergeSortRec(int[] inputA)
    {


        return inputA;
    }

    public static int min(int a, int b)
    {
        int min;
        if (a <= b)
        {
            min = a;
        }
        else min = b;

        return min;
    }

    public static int partition(int[] inputA, int lo, int hi)
    {
        int resultIndex;
        int i = lo + 1;
        //int i = 0;
        int j = hi;
        if (hi <= lo)
        {
            resultIndex = lo;
        }
        while ( i < j )
        {
            while (inputA[i] < inputA[lo] && i < j )
            {
                i++;
            }
            while (inputA[j] > inputA[lo] && j > i)
            {
                j--;
            }
            exchange(inputA, i, j);
        }
        if (inputA[i] > inputA[lo])
        {
            exchange(inputA, lo, i - 1);
            resultIndex = i - 1;
        }
        else
        {
            exchange(inputA, lo, i);
            resultIndex = i;
        }

        return resultIndex;
    }

    public static void printArray(int[] inputA)
    {
        for (int i = 0; i < inputA.length; i++)
        {
            System.out.println(inputA[i]);
        }
    }

    //See you tomorrow quick sort
    public static int[] quickSort(int[] inputA)
    {
        int lo = 0;
        int hi = inputA.length - 1;
        Stack<Integer> indexStack = new Stack<>();
        int flag = partition(inputA, lo, hi);
        indexStack.push(lo);
        indexStack.push(flag);
        indexStack.push(flag+1);
        indexStack.push(hi);

        while (!indexStack.isEmpty())
        {
            int j = partition(inputA, lo, hi);
            if (j == lo)
            {
                j = partition(inputA, lo + 1, hi);
            }
            else if (j == hi)
            {
                j = partition(inputA, lo, hi - 1);
            }
            else
            {
                //j = partition(inputA, )
            }
        }


        return inputA;
    }

    public static int[] shiftRight(int[] inputA, int start, int end)
    {
        //start is the index of start point
        //and is also the index of where end point will be
        //end point is the point where the number need to be operation
        //come from

        int a = inputA[end];
        if (start > end)
            throw new InputMismatchException("start should le dest");


        for (int i = end - 1; i >= start; i--)
        {
            inputA[i+1] = inputA[i];
        }

        inputA[start] = a;
        return inputA;
    }

    public static int[] shellSort(int[] inputA)
    {
        //Not yet

        return inputA;
    }

    public static int sum(int a)
    {
        if (a==1)
        {
            return a;
        }
        else
        {
            return a + sum(a - 1);
        }
    }


}
