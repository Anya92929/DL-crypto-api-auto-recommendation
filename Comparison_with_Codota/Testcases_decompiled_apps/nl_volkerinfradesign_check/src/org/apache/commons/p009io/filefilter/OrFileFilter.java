package org.apache.commons.p009io.filefilter;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: org.apache.commons.io.filefilter.OrFileFilter */
public class OrFileFilter extends AbstractFileFilter implements Serializable, ConditionalFileFilter {

    /* renamed from: a */
    private final List<IOFileFilter> f6869a;

    public OrFileFilter() {
        this.f6869a = new ArrayList();
    }

    public OrFileFilter(List<IOFileFilter> list) {
        if (list == null) {
            this.f6869a = new ArrayList();
        } else {
            this.f6869a = new ArrayList(list);
        }
    }

    public OrFileFilter(IOFileFilter iOFileFilter, IOFileFilter iOFileFilter2) {
        if (iOFileFilter == null || iOFileFilter2 == null) {
            throw new IllegalArgumentException("The filters must not be null");
        }
        this.f6869a = new ArrayList(2);
        addFileFilter(iOFileFilter);
        addFileFilter(iOFileFilter2);
    }

    public void addFileFilter(IOFileFilter iOFileFilter) {
        this.f6869a.add(iOFileFilter);
    }

    public List<IOFileFilter> getFileFilters() {
        return Collections.unmodifiableList(this.f6869a);
    }

    public boolean removeFileFilter(IOFileFilter iOFileFilter) {
        return this.f6869a.remove(iOFileFilter);
    }

    public void setFileFilters(List<IOFileFilter> list) {
        this.f6869a.clear();
        this.f6869a.addAll(list);
    }

    public boolean accept(File file) {
        for (IOFileFilter accept : this.f6869a) {
            if (accept.accept(file)) {
                return true;
            }
        }
        return false;
    }

    public boolean accept(File file, String str) {
        for (IOFileFilter accept : this.f6869a) {
            if (accept.accept(file, str)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        String obj;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("(");
        if (this.f6869a != null) {
            for (int i = 0; i < this.f6869a.size(); i++) {
                if (i > 0) {
                    sb.append(",");
                }
                IOFileFilter iOFileFilter = this.f6869a.get(i);
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
