class Solution {
    public List<String> letterCombinations(String digits) {
        //If digits length is zero -> return empty array list
        if(digits.length()==0)    return new ArrayList<String>();
        //Create a dictionary to hold the mapping of phone number to digit.
        String[] dictionary = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        ArrayList<String> result = new ArrayList<>();
        //We will go through the digits one by one.
        for(int i=0; i<digits.length(); i++) {
            //We will use a helper function called combine.
            result = combine(dictionary[digits.charAt(i)-'0'].toCharArray(), result);
            //combine will take character array of all the letters corresponding to current digit and the result up till now.
        }
        
        return result;
    }
    
    public ArrayList<String> combine(char[] toBeAdded, ArrayList<String> result) {
        
        if (result.isEmpty()) {
            for(char tba: toBeAdded)
                result.add(String.valueOf(tba));
            return result;
        }
        
        ArrayList<String> result2 = new ArrayList<String>();
        ////We will run 2 loops - outer loop goes through each character in the char array like 'a', 'b', 'c'. and inner loop will go through already present strings in result like "ad", "ae", "af" etc.
        for(String res: result) {
            for(char tba: toBeAdded)
                //Will simply concatenate and store in new array list.
                result2.add(res+String.valueOf(tba));
        }
        //finally returing the array list
        return result2;
    }
}