package me.puneetsingh.basics.arrays;



public class ArrayJump {
    public boolean canJump(int[] nums) {
        int currMax =0;
        int len = nums.length;
        int len1 = nums.length-1;
        // Two lines on top of this is for optimizations
        for (int i = 0; i < len; i++) {
            if(currMax>=len1)
                return true;
            else
            {
                currMax = (nums[i]+i>currMax)?nums[i]+i:currMax;
            }
            if(i>=currMax)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayJump aj = new ArrayJump();
        int[] a = {2,5,0,0};
        System.out.println(aj.canJump(a));

    }


}
