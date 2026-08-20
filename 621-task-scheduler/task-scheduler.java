import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {

        // Count frequency
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Max Heap
        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        for (int f : freq) {
            if (f > 0) {
                pq.add(f);
            }
        }

        int time = 0;

        while (!pq.isEmpty()) {

            // Store tasks executed in this cycle
            List<Integer> temp = new ArrayList<>();

            int cycle = n + 1;

            while (cycle > 0 && !pq.isEmpty()) {

                int current = pq.poll();

                current--;

                if (current > 0) {
                    temp.add(current);
                }

                time++;
                cycle--;
            }

            // Put remaining tasks back
            for (int f : temp) {
                pq.add(f);
            }

            // If tasks are still remaining, add idle time
            if (!pq.isEmpty()) {
                time += cycle;
            }
        }

        return time;
    }
}