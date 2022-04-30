class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> ans = new ArrayList<>();
		// Collections.sort(curr);
        Arrays.sort(nums);
        
		solve(0, nums, ans);
		return ans;
	}

	private static void solve(int idx, int[] a, List<List<Integer>> ans) {

		if (idx == a.length) {
            List<Integer> curr = new ArrayList<>();
            for (int ele : a) {
                curr.add(ele);
            }
			if (!ans.contains(curr)) {
				ans.add(curr);
			}
			return;
		}

		for (int i = idx; i < a.length; i++) {
			swap(a, i, idx);
			solve(idx + 1, a, ans);
			swap(a, i, idx);
		}

	}

	private static void swap(int[] curr, int i, int idx) {
		int temp = curr[i];
        curr[i] = curr[idx];
        curr[idx] = temp;
	}
}