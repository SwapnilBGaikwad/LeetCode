package com.github;

class CanJump {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) {
            return true;
        }
        boolean[] reach = new boolean[nums.length];
        boolean zeroIndex = false;
        reach[nums.length - 1] = true;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] == 0) {
                reach[i] = false;
                zeroIndex = true;
            } else {
                reach[i] = !zeroIndex || canReach(nums, reach, i);
            }
        }
        return reach[0];
    }

    private boolean canReach(int[] nums, boolean[] reach, int index) {
        int pow = nums[index];
        int i = index + 1;
        while(pow > 0) {
            if(reach[i]) {
                return true;
            }
            i++;
            pow--;
        }
        return false;
    }
}