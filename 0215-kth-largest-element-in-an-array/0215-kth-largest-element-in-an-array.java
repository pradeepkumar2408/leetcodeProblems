class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>((a, b) -> b.compareTo(a));
        for (int i : nums)
            maxheap.add(i);
        while (k-- > 1) {
            maxheap.poll();
        }
        return maxheap.peek();
    }
}