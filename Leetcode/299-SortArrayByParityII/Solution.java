class Solution {
  public int[] sortArrayByParityII(int[] A) {
    int n = A.length;
    int[] ans = new int[n];

    // For even numbers
    int i = 0;
    for (int x : A) {
      if (x % 2 == 0) {
        ans[i] = x;
        i += 2;
      }
    }

    // For odd numbers
    i = 1;
    for (int x : A) {
      if (x % 2 == 1) {
        ans[i] = x;
        i += 2;
      }
    }

    return ans;
  }
}
