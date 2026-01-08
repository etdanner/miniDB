package minidb.db;

public class Column {
    // don't want the columns to change after creation
    private final String name;
    private final ColumnType type;

    public Column(String name, ColumnType type){
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public ColumnType getType() {
        return type;
    }
}
