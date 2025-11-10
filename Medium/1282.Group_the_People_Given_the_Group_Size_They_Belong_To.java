import java.util.Arrays;

class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        // TC : O(n)
        
        HashMap<Integer,ArrayList<Integer>> people = new HashMap<>();
 
        for(int i=0;i<groupSizes.length;i++){
            if(!people.containsKey(groupSizes[i])){
                people.put(groupSizes[i],new ArrayList<Integer>());
                people.get(groupSizes[i]).add(i);
            }
            else people.get(groupSizes[i]).add(i);
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(int key : people.keySet()){
            List<Integer> value_list = people.get(key);
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<value_list.size();i++){
                if(temp.size() == key){
                    ans.add(new ArrayList<>(temp));
                    temp.clear();
                    temp.add(value_list.get(i));
                }
                else{
                    temp.add(value_list.get(i));
                }
            }
            if(temp.size() !=0){
                ans.add(new ArrayList<>(temp));
            }
        }
        return ans;
    }
}

       /* List<List<Integer>> people = new ArrayList<>(); // OR new ArrayList<List<Integer>>();
        List<Integer> temp = new ArrayList<>();
        int[] visited = new int[groupSizes.length];
        for(int i=0;i<groupSizes.length;i++){
            if(visited[i] != 0) continue;
            int size = groupSizes[i];
            int temp_size = 0;
            for(int j=i;j<groupSizes.length;j++){
                if(temp_size == size) break;
                if(groupSizes[j] == size){
                    temp.add(j);
                    temp_size++;
                    visited[j] = 1;
                }
            }
            people.add(new ArrayList<>(temp));
            temp.clear();
        }
        return people; */


/* GPT

   List<List<Integer>> people = new ArrayList<>();
        boolean[] visited = new boolean[groupSizes.length];

        for (int i = 0; i < groupSizes.length; i++) {
            if (visited[i]) continue;

            List<Integer> temp = new ArrayList<>();
            temp.add(i);
            visited[i] = true;
            int size = 1;

            for (int j = i + 1; j < groupSizes.length && size < groupSizes[i]; j++) {
                if (!visited[j] && groupSizes[j] == groupSizes[i]) {
                    temp.add(j);
                    visited[j] = true;
                    size++;
                }
            }

            people.add(temp);
        }

        return people;

    *?
    */
