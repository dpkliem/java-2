package Helper_Functions;

public class Hashing
{
    public static void main(String[] args)
    {
        int[] input = {1,2,3,4,5,6,7};
        int[] indizes = new int[input.length];

        for (int i : input)
        {
            int value = (i % 3) + (i % 4); // Hash Funktion
            indizes[value] += 1;
        }

        System.out.println("Index: \tWert:");

        for (int i = 0; i < indizes.length; ++i)
        {
            System.out.println(i + "\t\t" + indizes[i]);
        }
    }
}
