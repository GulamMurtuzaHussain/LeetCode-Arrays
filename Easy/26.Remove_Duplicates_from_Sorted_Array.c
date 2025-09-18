int removeDuplicates(int* nums, int numsSize) {
 if (numsSize == 0) return 0;

    int k = 1;  // Start from the second element

    for (int i = 1; i < numsSize; i++) {
        if (nums[i] != nums[i - 1]) {
            nums[k++] = nums[i];
        }
    }

    return k;  // New length of the array without duplicates
}
