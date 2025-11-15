class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        List<String> foods = new ArrayList<>();
        for(int i=0;i<orders.size();i++){
            if(foods.indexOf(orders.get(i).get(2)) == -1) foods.add(orders.get(i).get(2));
        } 
        Collections.sort(foods);
        // System.out.println(foods);
        
        Map<Integer,List<String>> map = new TreeMap<>();
        for(int i=0;i<orders.size();i++){
            int num = Integer.parseInt(orders.get(i).get(1));
            if(!map.containsKey(num)){
                map.put(num,new ArrayList<>());
            }
            map.get(num).add(orders.get(i).get(2));
        }
        // System.out.println(map);
        
        List<List<String>> display_table = new ArrayList<>();
        int table = 0;
        display_table.add(new ArrayList<>());
        display_table.get(table).add("Table");
        for(int i=0;i<foods.size();i++){
            display_table.get(table).add(foods.get(i));
        }
        table++;

        for(int key : map.keySet()){
            List<String> temp = map.get(key);
            display_table.add(new ArrayList<>());
            display_table.get(table).add(String.valueOf(key));
            for(int i=0;i<foods.size();i++){
                if(temp.indexOf(foods.get(i)) != -1){
                    int frequency = Collections.frequency(temp,foods.get(i));
                    display_table.get(table).add(String.valueOf(frequency));
                }
                else{
                    display_table.get(table).add(String.valueOf(0));
                }
            }
            table++;
        }

        return display_table;
    }
}

/*
Sure — here's a short, clean revision-ready summary.

Notation: N = number of orders, m = # distinct foods, k = # distinct tables.

Time (final):
O(N*m + N log k + m log m) → ≈ O(N * m) (dominant).
Why: building/counting repeats causes work proportional to total orders × foods.

Space (final):
O(N + m + k*m)

k*m = size of returned display_table (answer).

Aux (extra) space = O(N + m).
If you only count the output, space ≈ O(k*m).

*/
