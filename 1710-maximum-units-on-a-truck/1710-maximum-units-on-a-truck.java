class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        
        int answer = 0;
        
        Arrays.sort(boxTypes, (int[] first, int[] second) -> {
            if(first[1] <= second[1]) {
                return 1;
            } else {
                return -1;
            }
        });
        
        
        for (int[] current : boxTypes) {
            int numberOfBoxes = current[0];
            int numberOfUnitsPerBox = current[1];
            
            if (truckSize <= 0) {
                break;
            }
            
            if (numberOfBoxes <= truckSize) {
                truckSize = truckSize - numberOfBoxes;
                answer = answer + (numberOfBoxes * numberOfUnitsPerBox);
            } else {
                answer = answer + (truckSize * numberOfUnitsPerBox);
                truckSize = 0;
                break;
            }
        }
        
        return answer;
    }
}