package Array.assignment_programs;

public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * right;
            right = right * nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] res1 = productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(java.util.Arrays.toString(res1));

        int[] res2 = productExceptSelf(new int[]{-1, 1, 0, -3, 3});
        System.out.println(java.util.Arrays.toString(res2));
    }
}

