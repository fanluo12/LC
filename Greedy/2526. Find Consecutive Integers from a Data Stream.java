class DataStream {

    private int count = 0;
    private int value;
    private int k;

    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
    }
    
    public boolean consec(int num) {
        if (num == value) {
            count ++;
        }
        else {
            count = 0;
        }
        return count >= k;
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */
