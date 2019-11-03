package PlayerNumber;

import java.util.LinkedList;
import java.util.List;

public class PlayerNumber {
    /*
        Sum of digits.
     */
    private int cypherSum(int x) {
        int currentsum = 0;
        for (; x > 0; x /= 10) {
            currentsum += x % 10;
        }
        return currentsum;
    }

    /*
        Generate a valid number list
     */
    public List<Integer> newCounter(int n, int m) {
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            if (cypherSum(i) == n) {
                integerLinkedList.add(i);
            } else if (cypherSum(cypherSum(i)) == n) {
                integerLinkedList.add(i);
            }
        }
        return integerLinkedList;
    }

}

