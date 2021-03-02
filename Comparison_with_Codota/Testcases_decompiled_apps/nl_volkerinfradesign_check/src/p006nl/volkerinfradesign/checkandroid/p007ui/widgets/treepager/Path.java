package p006nl.volkerinfradesign.checkandroid.p007ui.widgets.treepager;

import java.util.Collection;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.widgets.treepager.Path */
public interface Path<T> extends Collection<T> {
    void append(int i, T t);

    void append(T t, T t2);

    T get(int i);

    int indexOf(Object obj);

    boolean isEmpty();

    void setContent(Collection<T> collection);

    void setRoot(T t);

    int size();
}
