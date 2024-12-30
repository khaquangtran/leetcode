import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public int minimumRoundsImproved(int[] tasks) {
        Arrays.sort(tasks);

        int minWays = 0;
        int count = 1;
        int target = tasks[0];

        for (int i = 1; i < tasks.length; i++) {
            if (tasks[i] == target) {
                count++;
            } else {
                minWays += (int)Math.ceil(count / 3.);

                target = tasks[i];
                count = 1;
            }
        }

        minWays += (int)Math.ceil(count / 3.);

        return minWays;
    }

    public int minimumRounds(int[] tasks) {
        HashMap<Integer, Integer> numTasks = new HashMap<>();

        for (int task : tasks) {
            if (!numTasks.containsKey(task)) {
                numTasks.put(task, 1);
            } else {
                numTasks.put(task, numTasks.get(task) + 1);
            }
        }

        int minWays = 0;

        for (int numTask : numTasks.keySet()) {
            int numValue = numTasks.get(numTask);
            if (numValue == 1) return -1;

            minWays += (int)Math.ceil(numValue / 3.);
        }

        return minWays;
    }

    public static void main(String[] args) {
        Main main = new Main();

        int[] tasks = new int[]{2,2,3,3,2,5,5,5,4,4,4,4};

        System.out.println(main.minimumRoundsImproved(tasks));
    }
}