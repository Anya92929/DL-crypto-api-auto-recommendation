package org.apache.commons.collections4.sequence;

import java.util.ArrayList;
import java.util.List;

public class EditScript<T> {

    /* renamed from: a */
    private final List<EditCommand<T>> f6740a = new ArrayList();

    /* renamed from: b */
    private int f6741b = 0;

    /* renamed from: c */
    private int f6742c = 0;

    public void append(KeepCommand<T> keepCommand) {
        this.f6740a.add(keepCommand);
        this.f6741b++;
    }

    public void append(InsertCommand<T> insertCommand) {
        this.f6740a.add(insertCommand);
        this.f6742c++;
    }

    public void append(DeleteCommand<T> deleteCommand) {
        this.f6740a.add(deleteCommand);
        this.f6742c++;
    }

    public void visit(CommandVisitor<T> commandVisitor) {
        for (EditCommand<T> accept : this.f6740a) {
            accept.accept(commandVisitor);
        }
    }

    public int getLCSLength() {
        return this.f6741b;
    }

    public int getModifications() {
        return this.f6742c;
    }
}
