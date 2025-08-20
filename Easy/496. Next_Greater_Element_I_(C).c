/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* nextGreaterElement(int* nums1, int nums1Size, int* nums2, int nums2Size, int* returnSize) {
    int *Arr = (int*)malloc(nums1Size * sizeof(int));
    int size = 0; // Initialize size to 0

    for (int i = 0; i < nums1Size; i++) {
        for (int j = 0; j < nums2Size; j++) {
            if (nums1[i] == nums2[j]) {
                if(j+1<nums2Size){
                for(int k=j+1;k<nums2Size;k++){
                    if(nums2[k]>nums2[j]){
                        Arr[i]=nums2[k];
                        break;
                    }
                    else{
                        Arr[i]=-1;
                    }
                }
                size++;
                break; // Exit inner loop since element is found
            }
            else{
                Arr[i]=-1;
                size++;
                break;
            }
            }
        }
    }

    *returnSize = size; // Update returnSize with the actual size
    return Arr; 
}
