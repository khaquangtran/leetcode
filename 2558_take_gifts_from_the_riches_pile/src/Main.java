import java.util.*;

public class Main {
    public static long pickGifts(int[] gifts, int k) {
        List<Integer> giftsList = new ArrayList<>();
        for (int gift : gifts) {
            giftsList.add(-gift);
        }

        PriorityQueue<Integer> giftsHeap = new PriorityQueue<>(giftsList);

        for (int i = 0; i < k; i++) {
            int maxElement = -giftsHeap.poll();

            giftsHeap.offer(-(int) Math.sqrt(maxElement));
        }

        long numberOfRemainingGifts = 0;
        while (!giftsHeap.isEmpty()) {
            numberOfRemainingGifts -= giftsHeap.poll();
        }

        return numberOfRemainingGifts;
    }

    public static void main(String[] args) {
        int[] gifts = {25,64,9,4,100};
        int k = 4;

        System.out.println(pickGifts(gifts, k));
    }
}