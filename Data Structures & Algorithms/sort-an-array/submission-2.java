class Solution {
    public int[] sortArray(int[] nums) {

        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] arr, int l, int r) {
        if (l == r) {
            return;
        }

        int m = (l + r) / 2;

        mergeSort(arr, l, m);
        mergeSort(arr, m + 1, r);

        merge(arr, l, m, r);
    }

    public void merge(int[] arr, int L, int M, int R) {
        int[] left = new int[M - L + 1];
        int[] right = new int[R - M];

        for (int i = 0; i < left.length; i++) {
            left[i] = arr[L + i];
        }

        for (int i = 0; i < right.length; i++) {
            right[i] = arr[M + 1 + i];
        }

        int i = L;
        int j = 0;
        int k = 0;

        while (j < left.length && k < right.length) {
            if (left[j] <= right[k]) {
                arr[i] = left[j];
                j++;
            } else {
                arr[i] = right[k];
                k++;
            }
            i++;
        }

        while (j < left.length) {
            arr[i] = left[j];
            j++;
            i++;
        }

        while (k < right.length) {
            arr[i] = right[k];
            k++;
            i++;
        }
    }
}
