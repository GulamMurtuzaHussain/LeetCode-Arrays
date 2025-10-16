class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) 
    {
        HashSet<Integer> uniques = new HashSet<>();
        int count = 0;
        int[] ans = new int[A.length];
        int a = 0;
        for(int i=0;i<A.length;i++){
            if(uniques.contains(A[i])) count++;
            if(uniques.contains(B[i])) count++;
            if(A[i] == B[i]) count++;
            // below if can be removed but no improvement tho`
            if(!uniques.contains(A[i])) uniques.add(A[i]);
            if(!uniques.contains(B[i])) uniques.add(B[i]);
            ans[a++] = count;
        }
        return ans;
    }
}

/*
        int common =0 ;
        for(int i=pos;i>=0;i--)
        {
            for(int j=pos;j>=0;j--)
            {
                if(A[i] == B[j]) common++;
            }
        }
        return common;
    }
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] ans = new int[A.length];
        
        int common = 0;
        for(int i=0;i<A.length;i++)
        {
            common = common(A,B,i);
            ans[i] = common;
        }
        return ans;
*/

/* GPT

boolean[] seen = new boolean[A.length];

for(int i=0;i<A.length;i++)
{
    if(seen[A[i]]) commonCount++;
    if(seen[B[i]]) commonCount++;
    if(A[i] == B[i]) commonCount++;

    seen[A[i]] = true;
    seen[B[i]] = true;

    ans[i] = commonCount;
}

*/
