class Solution {
    public int kthSmallest(int[][] matrix, int k) {
     PriorityQueue<Integer> pq = new PriorityQueue<>();
     for(int[] row:matrix){
        for(int n : row){
            pq.add(n);
        }
     }       
     for(int i=1;i<k;i++){
        pq.poll();
     }
     return pq.peek();
    }
}