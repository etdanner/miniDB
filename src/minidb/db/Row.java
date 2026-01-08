package minidb.db;

public class Row {
    private Object[] values;
    private Schema schema;

    public Row(Schema schema, Object[] values){
        this.values = new Object[values.length];
        if( schema == null){
            throw new IllegalArgumentException("Schema can't be null");
        }
        if(values == null || values.length == 0){
            throw new IllegalArgumentException("Rows must have values");
        }
        if(schema.getSize()!=values.length){
            throw new IllegalArgumentException("Number of values must match the schema");
        }

        for(int i = 0; i<values.length; i++){
            if(schema.getColumn(i).getType().accepts(values[i])){
                this.values[i] = values[i];
            } else {
                throw new IllegalArgumentException("Value at index "+i+" doesn't match the schema type");
            }
        }
        this.schema = schema;
    }

    public Schema getSchema(){
        return schema;
    }

    public Object getValue(int index){
        return values[index];
    }

    public Object getValue(String columnName){
        return values[schema.getIndex(columnName)];
    }
}
