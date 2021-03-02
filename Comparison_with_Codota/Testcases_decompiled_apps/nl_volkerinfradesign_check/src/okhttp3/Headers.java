package okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import okhttp3.internal.http.HttpDate;
import org.apache.commons.p009io.IOUtils;

public final class Headers {

    /* renamed from: a */
    private final String[] f5806a;

    private Headers(Builder builder) {
        this.f5806a = (String[]) builder.f5807a.toArray(new String[builder.f5807a.size()]);
    }

    private Headers(String[] strArr) {
        this.f5806a = strArr;
    }

    public String get(String str) {
        return m6545a(this.f5806a, str);
    }

    public Date getDate(String str) {
        String str2 = get(str);
        if (str2 != null) {
            return HttpDate.parse(str2);
        }
        return null;
    }

    public int size() {
        return this.f5806a.length / 2;
    }

    public String name(int i) {
        return this.f5806a[i * 2];
    }

    public String value(int i) {
        return this.f5806a[(i * 2) + 1];
    }

    public Set<String> names() {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        int size = size();
        for (int i = 0; i < size; i++) {
            treeSet.add(name(i));
        }
        return Collections.unmodifiableSet(treeSet);
    }

    public List<String> values(String str) {
        int size = size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(name(i))) {
                if (arrayList == null) {
                    arrayList = new ArrayList(2);
                }
                arrayList.add(value(i));
            }
        }
        if (arrayList != null) {
            return Collections.unmodifiableList(arrayList);
        }
        return Collections.emptyList();
    }

    public Builder newBuilder() {
        Builder builder = new Builder();
        Collections.addAll(builder.f5807a, this.f5806a);
        return builder;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int size = size();
        for (int i = 0; i < size; i++) {
            sb.append(name(i)).append(": ").append(value(i)).append(IOUtils.LINE_SEPARATOR_UNIX);
        }
        return sb.toString();
    }

    public Map<String, List<String>> toMultimap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = size();
        for (int i = 0; i < size; i++) {
            String name = name(i);
            List list = (List) linkedHashMap.get(name);
            if (list == null) {
                list = new ArrayList(2);
                linkedHashMap.put(name, list);
            }
            list.add(value(i));
        }
        return linkedHashMap;
    }

    /* renamed from: a */
    private static String m6545a(String[] strArr, String str) {
        for (int length = strArr.length - 2; length >= 0; length -= 2) {
            if (str.equalsIgnoreCase(strArr[length])) {
                return strArr[length + 1];
            }
        }
        return null;
    }

    /* renamed from: of */
    public static Headers m6547of(String... strArr) {
        if (strArr == null || strArr.length % 2 != 0) {
            throw new IllegalArgumentException("Expected alternating header names and values");
        }
        String[] strArr2 = (String[]) strArr.clone();
        for (int i = 0; i < strArr2.length; i++) {
            if (strArr2[i] == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            strArr2[i] = strArr2[i].trim();
        }
        int i2 = 0;
        while (i2 < strArr2.length) {
            String str = strArr2[i2];
            String str2 = strArr2[i2 + 1];
            if (str.length() != 0 && str.indexOf(0) == -1 && str2.indexOf(0) == -1) {
                i2 += 2;
            } else {
                throw new IllegalArgumentException("Unexpected header: " + str + ": " + str2);
            }
        }
        return new Headers(strArr2);
    }

    /* renamed from: of */
    public static Headers m6546of(Map<String, String> map) {
        if (map == null) {
            throw new IllegalArgumentException("Expected map with header names and values");
        }
        String[] strArr = new String[(map.size() * 2)];
        int i = 0;
        for (Map.Entry next : map.entrySet()) {
            if (next.getKey() == null || next.getValue() == null) {
                throw new IllegalArgumentException("Headers cannot be null");
            }
            String trim = ((String) next.getKey()).trim();
            String trim2 = ((String) next.getValue()).trim();
            if (trim.length() != 0 && trim.indexOf(0) == -1 && trim2.indexOf(0) == -1) {
                strArr[i] = trim;
                strArr[i + 1] = trim2;
                i += 2;
            } else {
                throw new IllegalArgumentException("Unexpected header: " + trim + ": " + trim2);
            }
        }
        return new Headers(strArr);
    }

    public static final class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final List<String> f5807a = new ArrayList(20);

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public Builder mo10690a(String str) {
            int indexOf = str.indexOf(":", 1);
            if (indexOf != -1) {
                return mo10691a(str.substring(0, indexOf), str.substring(indexOf + 1));
            }
            if (str.startsWith(":")) {
                return mo10691a("", str.substring(1));
            }
            return mo10691a("", str);
        }

        public Builder add(String str) {
            int indexOf = str.indexOf(":");
            if (indexOf != -1) {
                return add(str.substring(0, indexOf).trim(), str.substring(indexOf + 1));
            }
            throw new IllegalArgumentException("Unexpected header: " + str);
        }

        public Builder add(String str, String str2) {
            m6549b(str, str2);
            return mo10691a(str, str2);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public Builder mo10691a(String str, String str2) {
            this.f5807a.add(str);
            this.f5807a.add(str2.trim());
            return this;
        }

        public Builder removeAll(String str) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f5807a.size()) {
                    return this;
                }
                if (str.equalsIgnoreCase(this.f5807a.get(i2))) {
                    this.f5807a.remove(i2);
                    this.f5807a.remove(i2);
                    i2 -= 2;
                }
                i = i2 + 2;
            }
        }

        public Builder set(String str, String str2) {
            m6549b(str, str2);
            removeAll(str);
            mo10691a(str, str2);
            return this;
        }

        /* renamed from: b */
        private void m6549b(String str, String str2) {
            if (str == null) {
                throw new IllegalArgumentException("name == null");
            } else if (str.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            } else {
                int length = str.length();
                for (int i = 0; i < length; i++) {
                    char charAt = str.charAt(i);
                    if (charAt <= 31 || charAt >= 127) {
                        throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in header name: %s", new Object[]{Integer.valueOf(charAt), Integer.valueOf(i), str}));
                    }
                }
                if (str2 == null) {
                    throw new IllegalArgumentException("value == null");
                }
                int length2 = str2.length();
                for (int i2 = 0; i2 < length2; i2++) {
                    char charAt2 = str2.charAt(i2);
                    if (charAt2 <= 31 || charAt2 >= 127) {
                        throw new IllegalArgumentException(String.format("Unexpected char %#04x at %d in %s value: %s", new Object[]{Integer.valueOf(charAt2), Integer.valueOf(i2), str, str2}));
                    }
                }
            }
        }

        public String get(String str) {
            for (int size = this.f5807a.size() - 2; size >= 0; size -= 2) {
                if (str.equalsIgnoreCase(this.f5807a.get(size))) {
                    return this.f5807a.get(size + 1);
                }
            }
            return null;
        }

        public Headers build() {
            return new Headers(this);
        }
    }
}
