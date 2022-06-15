class Solution {
    public int longestStrChain(String[] words) {
        
	    if (words == null || words.length == 0) {
            return 0;
        }
	
        int res = 0;
	
        Arrays.sort(words, (a,b)-> a.length() - b.length());
	    HashMap<String, Integer> map = new HashMap(); 
	    
        for(String w : words) {                            
		    map.put(w, 1);                                  
		
            for(int i=0; i< w.length(); i++) {  
                
    			StringBuilder sb = new StringBuilder(w);
	    		String next = sb.deleteCharAt(i).toString();
                
		    	if(map.containsKey(next) && map.get(next)+1 > map.get(w))
			    	map.put(w, map.get(next)+1);       
        		}
		    res = Math.max(res, map.get(w));          
	    }
	    return res;
    }
}