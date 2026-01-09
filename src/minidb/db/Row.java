package minidb.db;

public class Row {
    private final Object[] values;

    public Row(Object[] values){
        if(values == null){
            throw new IllegalArgumentException("Rows can't be null");
        }
        // so there is no direct access to values
        this.values = new Object[values.length];
        for(int i = 0; i< values.length; i++){
            this.values[i] = values[i];
        }
    }

    public Object getValue(int idx){
        if (idx<0 || idx>=values.length){
            throw new IndexOutOfBoundsException("Index " + idx + " out of bounds for row size " +
                   values.length);
        }
        return values[idx];
    }

    public int getSize(){
        return values.length;
    }
}
