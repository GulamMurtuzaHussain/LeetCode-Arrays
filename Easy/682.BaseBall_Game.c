#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int calPoints(char** operations, int operationsSize) {
    int *Final = (int*)malloc(operationsSize * sizeof(int)); // Array to store valid scores
    int finalSize = 0; // Counter for the valid scores

    for(int j = 0; j < operationsSize; j++) {
        if(strcmp(operations[j], "C") == 0) { // 'C'
            if (finalSize > 0) {
                finalSize--; // Remove the last valid score
            }
        } else if(strcmp(operations[j], "D") == 0) { // 'D'
            if (finalSize > 0) {
                Final[finalSize] = Final[finalSize - 1] * 2;
                finalSize++;
            }
        } else if(strcmp(operations[j], "+") == 0) { // '+'
            if (finalSize > 1) {
                Final[finalSize] = Final[finalSize - 1] + Final[finalSize - 2];
                finalSize++;
            }
        } else {
            Final[finalSize] = atoi(operations[j]);
            finalSize++;
        }
    }

    // Step 3: Sum up the final points
    int sum = 0;
    for(int k = 0; k < finalSize; k++) {
        sum += Final[k];
    }

    free(Final);
    return sum;
}
