import java.util.*;

/** Day 29 - Practice Problems (classic interview warm-ups) */
public class Main {

    static boolean isPalindrome(String s) {
        String t = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        return new StringBuilder(t).reverse().toString().equals(t);
    }

    static boolean isAnagram(String a, String b) {
        char[] x = a.replace(" ", "").toLowerCase().toCharArray();
        char[] y = b.replace(" ", "").toLowerCase().toCharArray();
        Arrays.sort(x); Arrays.sort(y);
        return Arrays.equals(x, y);
    }

    static void fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) System.out.print("FizzBuzz ");
            else if (i % 3 == 0) System.out.print("Fizz ");
            else if (i % 5 == 0) System.out.print("Buzz ");
            else System.out.print(i + " ");
        }
        System.out.println();
    }

    static boolean isArmstrong(int n) {
        int original = n, sum = 0, digits = String.valueOf(n).length();
        while (n > 0) { sum += Math.pow(n % 10, digits); n /= 10; }
        return sum == original;
    }

    static int gcd(int a, int b) { return b == 0 ? a : gcd(b, a % b); }

    static int[] twoSum(int[] nums, int target) {       // O(n) using a HashMap
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer j = seen.get(target - nums[i]);
            if (j != null) return new int[]{j, i};
            seen.put(nums[i], i);
        }
        return new int[0];
    }

    static int binarySearch(int[] sorted, int key) {
        int lo = 0, hi = sorted.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (sorted[mid] == key) return mid;
            if (sorted[mid] < key) lo = mid + 1; else hi = mid - 1;
        }
        return -1;
    }

    static void bubbleSort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if (a[j] > a[j + 1]) { int t = a[j]; a[j] = a[j + 1]; a[j + 1] = t; swapped = true; }
            }
            if (!swapped) break;
        }
    }

    static char firstNonRepeating(String s) {
        Map<Character, Integer> count = new LinkedHashMap<>();
        for (char c : s.toCharArray()) count.merge(c, 1, Integer::sum);
        for (var e : count.entrySet()) if (e.getValue() == 1) return e.getKey();
        return '_';
    }

    static boolean balancedBrackets(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if ("({[".indexOf(c) >= 0) stack.push(c);
            else if (")}]".indexOf(c) >= 0) {
                if (stack.isEmpty()) return false;
                char open = stack.pop();
                if ("({[".indexOf(open) != ")}]".indexOf(c)) return false;
            }
        }
        return stack.isEmpty();
    }

    static String reverseWords(String s) {
        String[] w = s.trim().split("\\s+");
        Collections.reverse(Arrays.asList(w));
        return String.join(" ", w);
    }

    public static void main(String[] args) {
        System.out.println("Palindrome 'A man, a plan, a canal: Panama': " + isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println("Anagram 'Listen'/'Silent': " + isAnagram("Listen", "Silent"));
        fizzBuzz(15);
        System.out.println("Armstrong 153: " + isArmstrong(153) + ", 123: " + isArmstrong(123));
        System.out.println("gcd(48, 18) = " + gcd(48, 18));
        System.out.println("twoSum([2,7,11,15], 9) = " + Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println("binarySearch 23 -> index " + binarySearch(new int[]{2, 5, 8, 12, 16, 23, 38}, 23));
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(arr);
        System.out.println("bubbleSort: " + Arrays.toString(arr));
        System.out.println("First non-repeating in 'swiss': " + firstNonRepeating("swiss"));
        System.out.println("Brackets '{[()]}': " + balancedBrackets("{[()]}") + ", '{[(])}': " + balancedBrackets("{[(])}"));
        System.out.println("Reverse words: " + reverseWords("Java is really fun"));
    }
}
