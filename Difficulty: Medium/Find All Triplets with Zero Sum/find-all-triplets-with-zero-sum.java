//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
// Please follow me on github and let me know if you have any doubt.

class Solution {
    public List<List<Integer>> findTriplets(int[] arr) {
        // Your code here
        Set<List<Integer>> ansSet = new HashSet();
        Map<Integer, List<int[]>> mp =new HashMap();
        
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int sum = arr[i]+arr[j];
                if(!mp.containsKey(sum))
                {
                    mp.put(sum, new ArrayList<>());
                }
                mp.get(sum).add(new int[]{i,j});
            }
        }
        
        for(int i=0;i<arr.length;i++){
            int tar = -arr[i];
            if(mp.containsKey(tar)){
                List<int[]> pairs = mp.get(tar);
                for(int[] pair: pairs){
                    if(pair[0]!=i && pair[1]!=i){
                        List<Integer> curr = Arrays.asList(i, pair[0], pair[1]);
                        Collections.sort(curr);
                        ansSet.add(curr);
                    }
                }
            }
        }
        return new ArrayList<>(ansSet);
    }
}



//{ Driver Code Starts.

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            Solution obj = new Solution();
            List<List<Integer>> res = obj.findTriplets(nums);
            Collections.sort(res, (a, b) -> {
                for (int i = 0; i < a.size(); i++) {
                    if (!a.get(i).equals(b.get(i))) {
                        return a.get(i) - b.get(i);
                    }
                }
                return 0;
            });
            if (res.size() == 0) {
                System.out.println("[]");
            }
            for (int i = 0; i < res.size(); i++) {
                for (int j = 0; j < res.get(i).size(); j++) {
                    System.out.print(res.get(i).get(j) + " ");
                }
                System.out.println();
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends