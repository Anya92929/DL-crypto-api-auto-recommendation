package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.C0494b;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.query.internal.C0521f;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.google.android.gms.drive.query.c */
public class C0515c implements C0521f<String> {
    /* renamed from: a */
    public <T> String mo5206b(C0494b<T> bVar, T t) {
        return String.format("contains(%s,%s)", new Object[]{bVar.getName(), t});
    }

    /* renamed from: a */
    public <T> String mo5207b(Operator operator, MetadataField<T> metadataField, T t) {
        return String.format("cmp(%s,%s,%s)", new Object[]{operator.getTag(), metadataField.getName(), t});
    }

    /* renamed from: a */
    public String mo5208b(Operator operator, List<String> list) {
        StringBuilder sb = new StringBuilder(operator.getTag() + "(");
        String str = "";
        Iterator<String> it = list.iterator();
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return sb.append(")").toString();
            }
            sb.append(str2);
            sb.append(it.next());
            str = ",";
        }
    }

    /* renamed from: bn */
    public String mo5216j(String str) {
        return String.format("not(%s)", new Object[]{str});
    }

    /* renamed from: c */
    public String mo5212d(MetadataField<?> metadataField) {
        return String.format("fieldOnly(%s)", new Object[]{metadataField.getName()});
    }

    /* renamed from: c */
    public <T> String mo5213d(MetadataField<T> metadataField, T t) {
        return String.format("has(%s,%s)", new Object[]{metadataField.getName(), t});
    }

    /* renamed from: ir */
    public String mo5215is() {
        return "all()";
    }
}
