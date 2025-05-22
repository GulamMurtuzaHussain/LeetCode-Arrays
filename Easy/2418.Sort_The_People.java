/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
char** sortPeople(char** names, int namesSize, int* heights, int heightsSize, int* returnSize) {
       for (int i = 0; i < heightsSize - 1; i++) {
        for (int j = i + 1; j < heightsSize; j++) {
            if (heights[i] < heights[j]) {
                // Swap heights
                int tempHeight = heights[i];
                heights[i] = heights[j];
                heights[j] = tempHeight;
                
                // Swap corresponding names (just swap the pointers)
                char* tempName = names[i];
                names[i] = names[j];
                names[j] = tempName;
            }
        }
    }

    *returnSize = namesSize;
    return names;  // Return the sorted names array
}
