package minidb.db;
import java.util.HashMap;
import java.util.Map;

public class Schema {
    private final Column[] columns;
    private final Map<String, Integer> nameToIndex;
    private int size = 0;

    public Schema(Column[] columns) {
        if (columns == null || columns.length == 0) {
            throw new IllegalArgumentException("Schema must have at least one column");
        }

        this.columns = new Column[columns.length];
        this.nameToIndex = new HashMap<>();

        for (int i = 0; i < columns.length; i++) {
            Column c = columns[i];
            if (c == null) {
                throw new IllegalArgumentException("Column at index " + i + " is null");
            }

            String name = c.getName();
            if (name == null) {
                throw new IllegalArgumentException("Column name at index " + i + " is null");
            }

            if (nameToIndex.containsKey(name)) {
                throw new IllegalArgumentException("Duplicate column name: " + name);
            }

            this.columns[i] = c;
            this.nameToIndex.put(name, i);
            this.size++;
        }
    }

    public int getSize(){
        return size;
    }

    public int getIndex(String name){
        return nameToIndex.get(name);
    }

    public Column getColumn(int index){
        return columns[index];
    }

}
