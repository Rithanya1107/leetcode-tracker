// Last updated: 7/10/2026, 8:46:31 AM
class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        PriorityQueue<Integer > pq = new PriorityQueue <>(Collections.reverseOrder());

        for(int num : nums){
            pq.offer(num);
        }
        long sum = 0;

        while(k >0 && !pq.isEmpty()){
            int x= pq.poll();

            sum += Math.max((long)x, (long)x * mul);
            mul--;
            k--;
        }
        return sum;
    }
}