package org.apache.commons.p009io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: org.apache.commons.io.filefilter.AndFileFilter */
public class AndFileFilter extends AbstractFileFilter implements Serializable, ConditionalFileFilter {

    /* renamed from: a */
    private final List<IOFileFilter> f6859a;

    public AndFileFilter() {
        this.f6859a = new ArrayList();
    }

    public AndFileFilter(List<IOFileFilter> list) {
        if (list == null) {
            this.f6859a = new ArrayList();
        } else {
            this.f6859a = new ArrayList(list);
        }
    }

    public AndFileFilter(IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        if (iOFileFilter == null || iOFileFilter2 == null) {
            throw new IllegalArgumentException("The filters must not be null");
        }
        this.f6859a = new ArrayList(2);
        addFileFilter(iOFileFilter);
        addFileFilter(iOFileFilter2);
    }

    public void addFileFilter(IOFileFilter iOFileFilter) {
        this.f6859a.add(iOFileFilter);
    }

    public List<IOFileFilter> getFileFilters() {
        return Collections.unmodifiableList(this.f6859a);
    }

    public boolean removeFileFilter(IOFileFilter iOFileFilter) {
        return this.f6859a.remove(iOFileFilter);
    }

    public void setFileFilters(List<IOFileFilter> list) {
        this.f6859a.clear();
        this.f6859a.addAll(list);
    }

    public boolean accept(File file) {
        if (this.f6859a.isEmpty()) {
            return false;
        }
        for (IOFileFilter accept : this.f6859a) {
            if (!accept.accept(file)) {
                return false;
            }
        }
        return true;
    }

    public boolean accept(File file, String str) {
        if (this.f6859a.isEmpty()) {
            return false;
        }
        for (IOFileFilter accept : this.f6859a) {
            if (!accept.accept(file, str)) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        String obj;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("(");
        if (this.f6859a != null) {
            for (int i = 0; i < this.f6859a.size(); i++) {
                if (i > 0) {
                    sb.append(",");
                }
                IOFileFilter iOFileFilter = this.f6859a.get(i);
                if (iOFileFilter == null) {
                    obj = "null";
                } else {
                    obj = iOFileFilter.toString();
                }
                sb.append(obj);
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
