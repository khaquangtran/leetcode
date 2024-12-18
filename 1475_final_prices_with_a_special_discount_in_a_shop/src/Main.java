import java.util.Stack;

public class Main {
    public static int[] finalPricesWithStack(int[] prices) {
        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        for (int i = 1; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int index = stack.pop();
                prices[index] -= prices[i];
            }

            stack.push(i);
        }

        return prices;
    }

    public static void main(String[] args) {
        int[] prices = {8,4,6,2,3};
        int[] fPrices = finalPricesWithStack(prices);

        for (int price: fPrices) {
            System.out.printf("%4d", price);
        }
    }
}