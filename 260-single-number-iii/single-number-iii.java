class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        int setBit = -1;
        for (int i = 0; i < 32; i++) {
            if ((xor & (1 << i)) != 0) {
                setBit = i;
            }
        }

        int num1 = 0;
        int num2 = 0;
        for (int num : nums) {
            if ((num & ( 1 << setBit)) != 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }

        return new int[] {num1, num2};


    }
}