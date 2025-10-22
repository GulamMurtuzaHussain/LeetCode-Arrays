class Solution {
    public int travel_cost(int prev,int current,int[] travel)
    {
        int cost = 0;
        for(int i=prev;i<(current);i++){
            cost += travel[i];
        }
        return cost;
    }
    public int garbageCollection(String[] garbage, int[] travel) {
        int p_truck = 0 , g_truck = 0 , m_truck = 0;
        int p_prev = 0 , g_prev = 0, m_prev = 0;
        for(int i=0;i<garbage.length;i++)
        {
            for(int j=0;j<garbage[i].length();j++)
            {
                if(garbage[i].charAt(j) == 'G'){
                    if(i>0) g_truck += travel_cost(g_prev,i,travel);
                    g_prev = i;
                    g_truck++; 
                }
                if(garbage[i].charAt(j) == 'P'){
                    if(i>0) p_truck += travel_cost(p_prev,i,travel);
                    p_prev = i;
                    p_truck++; 
                }
                if(garbage[i].charAt(j) == 'M'){
                    if(i>0) m_truck += travel_cost(m_prev,i,travel);
                    m_prev = i;
                    m_truck++; 
                }
            }
        }
        return p_truck+g_truck+m_truck;
    }
}

/*
  public int garbageCollection(String[] garbage, int[] travel) {
        int p_last = 0, g_last = 0, m_last = 0;
        int p_count = 0, g_count = 0, m_count = 0;

        for (int i = 0; i < garbage.length; i++) {
            String house = garbage[i];
            for (char c : house.toCharArray()) {
                if (c == 'P') {
                    p_count++;
                    p_last = i;
                } else if (c == 'G') {
                    g_count++;
                    g_last = i;
                } else if (c == 'M') {
                    m_count++;
                    m_last = i;
                }
            }
        }

        // Precompute travel prefix sum
        int[] prefix = new int[travel.length + 1];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i - 1] + travel[i - 1];
        }

        int total = 0;
        total += p_count + prefix[p_last];
        total += g_count + prefix[g_last];
        total += m_count + prefix[m_last];

        return total;
    }
*/
