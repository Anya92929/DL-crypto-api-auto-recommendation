package org.apache.commons.collections4.sequence;

import java.util.ArrayList;
import java.util.List;

public class ReplacementsFinder<T> implements CommandVisitor<T> {

    /* renamed from: a */
    private final List<T> f6743a = new ArrayList();

    /* renamed from: b */
    private final List<T> f6744b = new ArrayList();

    /* renamed from: c */
    private int f6745c = 0;

    /* renamed from: d */
    private final ReplacementsHandler<T> f6746d;

    public ReplacementsFinder(ReplacementsHandler<T> replacementsHandler) {
        this.f6746d = replacementsHandler;
    }

    public void visitInsertCommand(T t) {
        this.f6743a.add(t);
    }

    public void visitKeepCommand(T t) {
        if (!this.f6744b.isEmpty() || !this.f6743a.isEmpty()) {
            this.f6746d.handleReplacement(this.f6745c, this.f6744b, this.f6743a);
            this.f6744b.clear();
            this.f6743a.clear();
            this.f6745c = 1;
            return;
        }
        this.f6745c++;
    }

    public void visitDeleteCommand(T t) {
        this.f6744b.add(t);
    }
}
