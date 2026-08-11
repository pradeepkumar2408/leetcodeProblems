class Solution {
    public int totalFruit(int[] fruits) {

        Map<Integer, Integer> mp = new HashMap<>();
        int left = 0, max = 0;
        for (int right = 0; right < fruits.length; right++) {
            mp.put(fruits[right], mp.getOrDefault(fruits[right], 0) + 1);

            while (mp.size() > 2) {
                if (mp.get(fruits[left]) == 1)
                    mp.remove(fruits[left]);
                else
                    mp.put(fruits[left], mp.get(fruits[left]) - 1);
                left++;
            }
            max = Math.max(right - left + 1, max);
        }
        return max;
    }
}