class Solution {
    public int kthMissing(int[] arr, int k) {
        // code here
         // insert all array elements into a set
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int count = 0, curr = 0;

        // loop until we find the k-th missing number
        while (count < k) {
            curr++;
            
            // increment missing count if current 
            // element is missing
            if (!set.contains(curr)) {
                count++;
            }
        }
        return curr;
    }
}