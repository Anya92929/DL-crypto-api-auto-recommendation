package p006nl.volkerinfradesign.checkandroid.database;

import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursor;

/* renamed from: nl.volkerinfradesign.checkandroid.database.StackTraceCursor */
public interface StackTraceCursor extends ViTaCursor {
    String getClassName();

    String getFileName();

    int getLineNumber();

    String getMethodName();
}
