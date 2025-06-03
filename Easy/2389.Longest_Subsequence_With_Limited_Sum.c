/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
#include<stdlib.h>

int compare(const void *a,const void *b){
    return (*(int*)a - *(int*)b);
}
int* answerQueries(int* nums, int numsSize, int* queries, int queriesSize, int* returnSize) {

   qsort(nums,numsSize,sizeof(int),compare);

   int *result=(int*)malloc(queriesSize * sizeof(int));
   (*returnSize) = 0;
   for(int i=0;i<queriesSize;i++){
    int sum = 0,size = 0;
    for(int j=0;j<numsSize;j++){
        if (sum < queries[i]){
            sum += nums[j]; size++;
            if((j+1 <=numsSize-1) && (sum + nums[j+1] > queries[i])){
                break;
            }
        }
    }
    if(sum <= queries[i]){
        result[(*returnSize)++]= size;
    } 
    else{
        result[(*returnSize)++]= 0;
    }
   }   
    return result;
}

/*
#include <stdlib.h>

int compare(const void* a, const void* b) {
    return (*(int*)a - *(int*)b);
}

// Binary search to find the maximum index with sum <= query
int binarySearch(int* prefixSum, int numsSize, int query) {
    int low = 0, high = numsSize - 1;

    // Perform binary search on prefix sum
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (prefixSum[mid] <= query) {
            low = mid + 1;
        } else {
            high = mid - 1;
        }
    }
    // 'high' will be the maximum index such that prefixSum[high] <= query
    return high;
}

int* answerQueries(int* nums, int numsSize, int* queries, int queriesSize, int* returnSize) {
    // Sort nums array
    qsort(nums, numsSize, sizeof(int), compare);

    // Create a prefix sum array
    int* prefixSum = (int*)malloc(numsSize * sizeof(int));
    prefixSum[0] = nums[0];
    for (int i = 1; i < numsSize; i++) {
        prefixSum[i] = prefixSum[i - 1] + nums[i];
    }

    // Allocate memory for result array
    int* result = (int*)malloc(queriesSize * sizeof(int));
    *returnSize = 0;

    // For each query, use binary search to find the answer
    for (int i = 0; i < queriesSize; i++) {
        int maxIndex = binarySearch(prefixSum, numsSize, queries[i]);
        result[(*returnSize)++] = maxIndex + 1;  // maxIndex + 1 gives the count of elements
    }

    // Free the prefix sum array
    free(prefixSum);

    return result;
}
*/
