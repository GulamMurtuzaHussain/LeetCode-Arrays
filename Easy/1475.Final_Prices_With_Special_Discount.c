/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* finalPrices(int* prices, int pricesSize, int* returnSize) {
        int* brr=(int*)malloc(pricesSize*sizeof(int));
    for(int i=0; i<pricesSize; i++)
    {
        brr[i]=prices[i];
        for(int j=i+1;j<pricesSize;j++){
            if(prices[j]<=prices[i]){
                brr[i]=prices[i]-prices[j];
                break;
            }
        }
    }
    *returnSize=pricesSize;
    return brr;
}
