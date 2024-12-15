import java.util.Comparator;
import java.util.PriorityQueue;

class Record {
    int pass, total;
    double maxChange;

    Record(int pass, int total, double maxChange) {
        this.pass = pass;
        this.total = total;
        this.maxChange = maxChange;
    }

    public int compareTo(Record o) {
        if (this.maxChange > o.maxChange) {
            return -1;
        } else if (this.maxChange < o.maxChange) {
            return 1;
        }

        return 0;
    }
}

public class Main {
    public static double maxAverageRatio(int[][] classes, int extraStudents) {
        double ans = 0;

        PriorityQueue<Record> pq = new PriorityQueue<>(new Comparator<Record>() {
            @Override
            public int compare(Record o1, Record o2) {
                return o1.compareTo(o2);
            }
        });

        for (int[] c: classes) {
            double maxChange = ((double)(c[0] + 1) / (c[1] + 1)) - (double)c[0]/c[1];
            pq.offer(new Record(c[0], c[1], maxChange));
        }

        while (extraStudents-- > 0) {
            Record record = pq.poll();

            record.pass += 1;
            record.total += 1;
            record.maxChange = ((double)(record.pass + 1) / (record.total + 1)) - ((double)record.pass / record.total);

            pq.offer(record);
        }

        while (!pq.isEmpty()) {
            Record record = pq.poll();

            ans += (double)record.pass / record.total;
        }

        return ans / classes.length;
    }

    public static void main(String[] args) {
        int[][] classes = {{2,4}, {3,9}, {4,5}, {2,10}};
        int extraStudents = 4;

        System.out.println(maxAverageRatio(classes, extraStudents));
    }
}