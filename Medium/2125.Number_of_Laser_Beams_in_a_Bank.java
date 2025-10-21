class Solution {
    public int numberOfBeams(String[] bank) {
        int devices = 0;
        int prev = 0 , current = 0;
        for(int i=0;i<bank.length;i++)
        {
            if(current!=0) prev=current;
            current = 0;
            for(int j=0;j<bank[i].length();j++)
            {
                if(bank[i].charAt(j) == '1') current++;
            }
            devices += (prev * current);
        }
        return devices;
    }
}

/*
class Solution {
    public int numberOfBeams(String[] bank) {
        int devices = 0;
        int prev = 0;
        
        for (String row : bank) {
            int current = 0;
            for (char c : row.toCharArray()) {
                if (c == '1') current++;
            }
            
            if (current > 0) {
                devices += prev * current;
                prev = current;
            }
        }
        
        return devices;
    }
}
*/
