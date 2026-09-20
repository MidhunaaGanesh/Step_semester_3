package Array.class_programs;

import java.util.Arrays;

public class RotateArray {

    public static int[] rotateArray(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        k = k % nums.length;
        int[] newArray = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            newArray[(i + k) % nums.length] = nums[i];
        }

        System.arraycopy(newArray, 0, nums, 0, nums.length);
        return nums;
    }

    public static void main(String[] args) {
        int[] res1 = rotateArray(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        System.out.println(Arrays.toString(res1));

        int[] res2 = rotateArray(new int[]{1, 2}, 3);
        System.out.println(Arrays.toString(res2));
    }
}

