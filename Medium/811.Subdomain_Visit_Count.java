class Solution {
    public static int num_length(String str){
        int len = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) != ' ') len++;
            else break;
        }
        return len;
    }

    

    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String,Integer> frequencies = new HashMap<>();

        for(int i=0;i<cpdomains.length;i++){
            int len = num_length(cpdomains[i]);
            int number = Integer.parseInt(cpdomains[i].substring(0,len));
            String temp_str = cpdomains[i].substring(len+1,cpdomains[i].length());
            //----------------------------------\\
            String[] TTemp = temp_str.split("\\.");
            // System.out.println(TTemp.length);
            List<String> domains = new ArrayList<>(); int split = 2;
            domains.add(temp_str);
            for(int k=0;k<TTemp.length-1;k++){
                String[] temp = temp_str.split("\\.",split++);
                // System.out.println(temp.length);
                domains.add(temp[temp.length-1]);
                // if(split == TTemp.length-1) break;
            } 
            
            for(int j=domains.size()-1;j>=0;j--){
                frequencies.put(domains.get(j),frequencies.getOrDefault(domains.get(j),0)+number);
            }
        }
        // for(String key : frequencies.keySet()){
        //     System.out.println(key + " " + frequencies.get(key));
        // }
        List<String> Temp = new ArrayList<>();
        for(String key : frequencies.keySet()){
            String sttr = new String(frequencies.get(key) + " " + key);
            Temp.add(sttr);
        }
        return Temp;
    }
}
