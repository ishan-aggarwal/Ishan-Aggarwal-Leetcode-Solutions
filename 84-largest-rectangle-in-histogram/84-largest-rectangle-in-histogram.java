class Solution {
    public int largestRectangleArea(int[] A) {
		if (A.length == 1) {
			return A[0];
		}

		long maxArea = Long.MIN_VALUE;
		int[] nsl = computeNearestSmallestLeft(A);
		int[] nsr = computeNearestSmallestRight(A);

		for (int i = 0; i < A.length; i++) {
			int height = A[i];
			int width = nsr[i] - nsl[i] - 1;
			maxArea = Math.max(maxArea, 1l * width * height);
		}
		return (int) maxArea;
	}

	private static int[] computeNearestSmallestRight(int[] A) {
		int[] nsr = new int[A.length];
		Stack<Integer> stack = new Stack<>();

		int idx = A.length - 1;
		for (int i = A.length - 1; i >= 0; i--) {

			while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				nsr[idx--] = A.length;
			} else {
				nsr[idx--] = stack.peek();
			}

			stack.push(i);
		}
		return nsr;

	}

	private static int[] computeNearestSmallestLeft(int[] A) {
		int[] nsl = new int[A.length];
		Stack<Integer> stack = new Stack<>();

		int idx = 0;
		for (int i = 0; i < A.length; i++) {

			while (!stack.isEmpty() && A[stack.peek()] >= A[i]) {
				stack.pop();
			}

			if (stack.isEmpty()) {
				nsl[idx++] = -1;
			} else {
				nsl[idx++] = stack.peek();
			}

			stack.push(i);
		}
		return nsl;
	}

}