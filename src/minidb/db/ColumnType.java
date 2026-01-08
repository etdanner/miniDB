package minidb.db;

public enum ColumnType {
    INT{
        @Override
        public boolean accepts(Object value){
            return value == null || value instanceof Integer;
        }
    },
    STRING{
        @Override
        public boolean accepts(Object value){
            return value == null || value instanceof String;
        }
    };

    public abstract boolean accepts(Object value);
}
