class Solution {
    public String firstNonRepeating(String s) {
        // code here
          StringBuilder ans = new StringBuilder();
        int[] count = new int[26];
    
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            
            // if non-repeating element found push it in queue
            if (count[s.charAt(i) - 'a'] == 0) {
                q.add(s.charAt(i));
            }
            count[s.charAt(i) - 'a']++;

            // if front element is repeating pop it from the queue
            while (!q.isEmpty() && count[q.peek() - 'a'] > 1) {
                q.poll();
            }

            // if queue is not empty append front 
            // element else append "#" in ans string.
            if (!q.isEmpty()) {
                ans.append(q.peek());
            } else {
                ans.append('#');
            }
        }

        return ans.toString();
    }
}