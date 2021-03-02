package p000;

import p006nl.volkerinfradesign.checkandroid.tables.Column;
import p006nl.volkerinfradesign.checkandroid.tables.ColumnEditor;
import p006nl.volkerinfradesign.checkandroid.tables.Table;

/* renamed from: ih */
public class C1253ih implements Column, ColumnEditor {

    /* renamed from: a */
    private final Table f4396a;

    /* renamed from: b */
    private boolean f4397b;

    /* renamed from: c */
    private boolean f4398c;

    /* renamed from: d */
    private boolean f4399d;

    /* renamed from: e */
    private boolean f4400e = true;

    /* renamed from: f */
    private String f4401f;

    /* renamed from: g */
    private String f4402g;

    /* renamed from: h */
    private final String f4403h;

    /* renamed from: i */
    private final Column.DataType f4404i;

    public C1253ih(Table table, String str, Column.DataType dataType) {
        this.f4396a = table;
        this.f4403h = str;
        this.f4404i = dataType;
        table.mo9740c();
    }

    public ColumnEditor notNull() {
        this.f4397b = true;
        this.f4396a.mo9740c();
        return this;
    }

    public ColumnEditor unique() {
        this.f4399d = true;
        this.f4396a.mo9740c();
        return this;
    }

    public ColumnEditor defaultValue(String str) {
        this.f4401f = str;
        this.f4396a.mo9740c();
        return this;
    }

    public ColumnEditor defaultValue(Number number) {
        return defaultValue(number.toString());
    }

    public ColumnEditor defaultValue(Boolean bool) {
        return defaultValue(bool.toString());
    }

    public ColumnEditor defaultValue(ColumnEditor.LiteralValue literalValue) {
        return defaultValue(literalValue.name());
    }

    public ColumnEditor autoIncrement() {
        this.f4398c = true;
        this.f4396a.mo9740c();
        return this;
    }

    public ColumnEditor primaryKey() {
        this.f4402g = "PRIMARY KEY ";
        this.f4396a.mo9740c();
        return this;
    }

    public boolean isNotNull() {
        return this.f4397b;
    }

    public boolean isAutoIncrement() {
        return this.f4398c;
    }

    public boolean isPrimaryKey() {
        return this.f4402g != null;
    }

    public String getDefaultValue() {
        return this.f4401f;
    }

    public String getName() {
        return this.f4403h;
    }

    public Column.DataType getType() {
        return this.f4404i;
    }

    public boolean isUnique() {
        return this.f4399d;
    }

    public ColumnEditor disableImport() {
        this.f4400e = false;
        return this;
    }

    public boolean isImportable() {
        return this.f4400e;
    }

    public void synchronize() {
        this.f4396a.synchronize();
    }

    public Table getTable() {
        return this.f4396a;
    }

    public String toString() {
        return m5544a(this);
    }

    /* renamed from: a */
    public String mo8545a() {
        return m5544a(this);
    }

    /* renamed from: a */
    public static String m5544a(Column column) {
        String str = column.getName() + " " + column.getType().name() + " ";
        if (column.isPrimaryKey()) {
            str = str + "PRIMARY KEY ";
        }
        if (column.isAutoIncrement()) {
            str = str + "AUTOINCREMENT ";
        }
        if (column.isNotNull()) {
            str = str + "NOT NULL ";
        }
        if (column.isUnique()) {
            str = str + "UNIQUE ";
        }
        if (column.getDefaultValue() != null) {
            str = str + "DEFAULT " + column.getDefaultValue() + " ";
        }
        return str.trim();
    }
}
