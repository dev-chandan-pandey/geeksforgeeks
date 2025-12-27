class Solution {
    public int kthSmallest(int[][] mat, int k) {
        // code here
         int n = mat.length;
        PriorityQueue<Integer> pq = 
            new PriorityQueue<>(Collections.reverseOrder());

        // traverse all elements in the mat
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                int curr = mat[i][j];

                // push the current element into the max-heap
                pq.offer(curr);

                // if the size of the max-heap exceeds k, 
                // remove the largest element
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }

        // the top element of the max-heap 
        // is the kth smallest element
        return pq.peek();
    }
}
