package org.apache.commons.lang3.exception;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class DefaultExceptionContext implements Serializable, ExceptionContext {
    private static final long serialVersionUID = 20110706;

    /* renamed from: a */
    private final List<Pair<String, Object>> f7136a = new ArrayList();

    public DefaultExceptionContext addContextValue(String str, Object obj) {
        this.f7136a.add(new ImmutablePair(str, obj));
        return this;
    }

    public DefaultExceptionContext setContextValue(String str, Object obj) {
        Iterator<Pair<String, Object>> it = this.f7136a.iterator();
        while (it.hasNext()) {
            if (StringUtils.equals(str, (CharSequence) it.next().getKey())) {
                it.remove();
            }
        }
        addContextValue(str, obj);
        return this;
    }

    public List<Object> getContextValues(String str) {
        ArrayList arrayList = new ArrayList();
        for (Pair next : this.f7136a) {
            if (StringUtils.equals(str, (CharSequence) next.getKey())) {
                arrayList.add(next.getValue());
            }
        }
        return arrayList;
    }

    public Object getFirstContextValue(String str) {
        for (Pair next : this.f7136a) {
            if (StringUtils.equals(str, (CharSequence) next.getKey())) {
                return next.getValue();
            }
        }
        return null;
    }

    public Set<String> getContextLabels() {
        HashSet hashSet = new HashSet();
        for (Pair<String, Object> key : this.f7136a) {
            hashSet.add(key.getKey());
        }
        return hashSet;
    }

    public List<Pair<String, Object>> getContextEntries() {
        return this.f7136a;
    }

    public String getFormattedExceptionMessage(String str) {
        String str2;
        StringBuilder sb = new StringBuilder(256);
        if (str != null) {
            sb.append(str);
        }
        if (this.f7136a.size() > 0) {
            if (sb.length() > 0) {
                sb.append(10);
            }
            sb.append("Exception Context:\n");
            int i = 0;
            for (Pair next : this.f7136a) {
                sb.append("\t[");
                int i2 = i + 1;
                sb.append(i2);
                sb.append(':');
                sb.append((String) next.getKey());
                sb.append("=");
                Object value = next.getValue();
                if (value == null) {
                    sb.append("null");
                } else {
                    try {
                        str2 = value.toString();
                    } catch (Exception e) {
                        str2 = "Exception thrown on toString(): " + ExceptionUtils.getStackTrace(e);
                    }
                    sb.append(str2);
                }
                sb.append("]\n");
                i = i2;
            }
            sb.append("---------------------------------");
        }
        return sb.toString();
    }
}
