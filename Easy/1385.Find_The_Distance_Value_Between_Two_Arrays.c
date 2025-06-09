#include <stdlib.h>

// int compare(void const* a, void const* b) { return ((*(int*)a) - (*(int*)b)); }

// int findClosest(int* arr, int arrSize, int target) {

//     int low = 0, high = arrSize - 1, previous = 0,closest =0;
//     while (low <= high) {
//         int mid = low + (high - low) / 2;
//         int diff = abs(arr[mid] - target);
//         if (previous == 0) {
//             previous = diff;
//             if(arr[mid] == target)  return arr[mid];
//             else if (arr[mid] > target) high = mid - 1;
//             else low = mid + 1;

//         }
//         if (diff <= previous) {
//             previous = diff;
//             closest = arr[mid];
//             if(arr[mid] == target)  return arr[mid];
//             else if (arr[mid] > target) high = mid - 1;
//             else low = mid + 1;

//         }
//         else
//         {
//             if (arr[mid] > target) high = mid - 1;
//             else low = mid + 1;

//         }
//     }
//     return closest;
// }

int findTheDistanceValue(int* arr1, int arr1Size, int* arr2, int arr2Size,
                         int d) {

    // qsort(arr2, arr2Size, sizeof(int), compare);

    // int found = 0;
    // for (int i = 0; i < arr1Size; i++) {
    //     int closest = findClosest(arr2, arr2Size, arr1[i]);
    //     if (abs(arr1[i] - closest) > d) {
    //         found++;
    //     }
    // }
    // return found;

    int distance = 0,found = 0;
for(int i=0;i<arr1Size;i++){
    found = 0;
    for(int j=0;j<arr2Size;j++){
        if(arr2[j]>arr1[i]){
            if(arr2[j]-arr1[i]>d){
                found++;
            }
        }
        else{
            if(arr1[i]-arr2[j]>d){
                found++;
            }
        }
    }
    if(found == arr2Size){
        distance++;
    }
}
return distance;
}
