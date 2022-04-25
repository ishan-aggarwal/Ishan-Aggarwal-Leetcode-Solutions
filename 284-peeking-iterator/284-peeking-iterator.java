// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    private List<Integer> list = null;
    
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
        this.list = new LinkedList<>();
        while (iterator.hasNext()) {
            list.add(iterator.next());
        }
	    
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        int ret = -1;
        if (list.size() > 0) {
            ret = list.get(0);
        }
        return ret;        
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    int ret = -1;
        if (list.size() > 0) {
            ret = list.remove(0);
        }
        return ret;
	}
	
	@Override
	public boolean hasNext() {
	    return list.size() > 0;
	}
}