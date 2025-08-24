int binarySearchForPositive(int* nums, int size) {
    int left = 0, right = size - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] > 0) {
            right = mid - 1; // continue searching on the left side
        } else {
            left = mid + 1;
        }
    }
    return left; // index of the first positive integer
}

int binarySearchForFirstNonNegative(int* nums, int size) {
    int left = 0, right = size - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] >= 0) {
            right = mid - 1; // continue searching on the left side
        } else {
            left = mid + 1;
        }
    }
    return left; // index of the first non-negative integer
}

int maximumCount(int* nums, int numsSize) {
    int posIndex = binarySearchForPositive(nums, numsSize);
    int nonNegIndex = binarySearchForFirstNonNegative(nums, numsSize);
    
    int posCount = numsSize - posIndex; // count of positive integers
    int negCount = nonNegIndex; // count of negative integers
    
    return (posCount > negCount) ? posCount : negCount;
}
