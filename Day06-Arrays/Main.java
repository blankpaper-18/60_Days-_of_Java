import java.util.Arrays;

/** Day 6 - Arrays */
public class Main {
    public static void main(String[] args) {
        // Declaration and initialisation
        int[] numbers = {42, 7, 19, 3, 88, 25};
        String[] fruits = new String[3];
        fruits[0] = "Apple"; fruits[1] = "Mango"; fruits[2] = "Banana";

        System.out.println("Length: " + numbers.length);
        System.out.println("First: " + numbers[0] + ", Last: " + numbers[numbers.length - 1]);

        // Looping
        for (int i = 0; i < fruits.length; i++) System.out.println(i + " -> " + fruits[i]);
        for (int n : numbers) System.out.print(n + " ");   // enhanced for
        System.out.println();

        // Max, min and sum
        int max = numbers[0], min = numbers[0], sum = 0;
        for (int n : numbers) {
            if (n > max) max = n;
            if (n < min) min = n;
            sum += n;
        }
        System.out.println("max=" + max + ", min=" + min + ", avg=" + (double) sum / numbers.length);

        // Arrays utility class
        int[] copy = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(copy);
        System.out.println("Original: " + Arrays.toString(numbers));
        System.out.println("Sorted:   " + Arrays.toString(copy));
        System.out.println("Index of 19 in sorted: " + Arrays.binarySearch(copy, 19));
        System.out.println("Equal? " + Arrays.equals(numbers, copy));

        // Reverse in place
        int[] rev = numbers.clone();
        for (int i = 0, j = rev.length - 1; i < j; i++, j--) {
            int tmp = rev[i]; rev[i] = rev[j]; rev[j] = tmp;
        }
        System.out.println("Reversed: " + Arrays.toString(rev));

        // 2D array
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        for (int[] row : matrix) System.out.println(Arrays.toString(row));
        int diagonal = 0;
        for (int i = 0; i < matrix.length; i++) diagonal += matrix[i][i];
        System.out.println("Diagonal sum: " + diagonal);

        // Jagged array
        int[][] jagged = new int[3][];
        for (int i = 0; i < jagged.length; i++) {
            jagged[i] = new int[i + 1];
            Arrays.fill(jagged[i], i + 1);
        }
        System.out.println(Arrays.deepToString(jagged));
    }
}
