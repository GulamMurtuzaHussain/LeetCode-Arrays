/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
#include<stdlib.h>

int compare(const void *a,const void *b){
    return (*(int*)a-*(int*)b);
}

int* targetIndices(int* nums, int numsSize, int target, int* returnSize) {
    qsort(nums,numsSize,sizeof(int),compare);

    int *arr=(int*)malloc(100*sizeof(int));
    int k = 0;

    for(int i = 0 ;i<numsSize ; i++){
        if(nums[i]==target){
            arr[k++]=i;
        }
    }
    *returnSize = k;
    return arr;
}
