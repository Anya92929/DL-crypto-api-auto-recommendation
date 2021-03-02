package p006nl.volkerinfradesign.checkandroid.tables;

/* renamed from: nl.volkerinfradesign.checkandroid.tables.ColumnEditor */
public interface ColumnEditor {

    /* renamed from: nl.volkerinfradesign.checkandroid.tables.ColumnEditor$Collating */
    public interface Collating {
        ColumnEditor binary();

        ColumnEditor noCase();

        ColumnEditor rTrim();
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.tables.ColumnEditor$ConflictClause */
    public interface ConflictClause {
        ColumnEditor abort();

        ColumnEditor fail();

        ColumnEditor ignore();

        ColumnEditor replace();

        ColumnEditor rollBack();
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.tables.ColumnEditor$LiteralValue */
    public enum LiteralValue {
        NULL,
        CURRENT_TIME,
        CURRENT_DATE,
        CURRENT_TIMESTAMP
    }

    ColumnEditor autoIncrement();

    ColumnEditor defaultValue(Boolean bool);

    ColumnEditor defaultValue(Number number);

    ColumnEditor defaultValue(String str);

    ColumnEditor defaultValue(LiteralValue literalValue);

    ColumnEditor disableImport();

    ColumnEditor notNull();

    ColumnEditor primaryKey();

    void synchronize();

    ColumnEditor unique();
}
