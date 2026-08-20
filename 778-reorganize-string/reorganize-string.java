import java.util.*;

class Solution {
    public String reorganizeString(String s) {

        // Count frequency
        int[] freq = new int[26];

        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Max Heap: [character, frequency]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[1] - a[1]
        );

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.add(new int[]{i, freq[i]});
            }
        }

        StringBuilder result = new StringBuilder();

        while (pq.size() >= 2) {

            int[] first = pq.poll();
            int[] second = pq.poll();

            result.append((char) (first[0] + 'a'));
            result.append((char) (second[0] + 'a'));

            first[1]--;
            second[1]--;

            if (first[1] > 0) {
                pq.add(first);
            }

            if (second[1] > 0) {
                pq.add(second);
            }
        }

        // One character remaining
        if (!pq.isEmpty()) {
            int[] last = pq.poll();

            if (last[1] > 1) {
                return "";
            }
            result.append((char) (last[0] + 'a'));
        }
        return result.toString();
    }
}