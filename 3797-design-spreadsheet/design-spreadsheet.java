class Spreadsheet {

    private Map<String, Integer> cells = new HashMap<>();

    public Spreadsheet(int rows) {
        
    }
    
    public void setCell(String cell, int value) {
        cells.put(cell, value);
    }
    
    public void resetCell(String cell) {
        cells.remove(cell);
    }
    
    public int getValue(String formula) {
        int idx = formula.indexOf('+');
        String left = formula.substring(1, idx);
        String right = formula.substring(idx + 1);

        int valLeft = 
            Character.isLetter(left.charAt(0)) 
            ? cells.getOrDefault(left, 0) 
            : Integer.parseInt(left);

        int valRight = 
            Character.isLetter(right.charAt(0)) 
            ? cells.getOrDefault(right, 0) 
            : Integer.parseInt(right);

        return valLeft + valRight;
    }
}