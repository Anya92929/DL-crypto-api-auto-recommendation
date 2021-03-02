package com.google.android.gms.drive.metadata.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.UserMetadata;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/* renamed from: com.google.android.gms.drive.metadata.internal.m */
public class C0511m extends C0508j<UserMetadata> {
    public C0511m(String str, int i) {
        super(str, m1448bm(str), Collections.emptyList(), i);
    }

    /* renamed from: bl */
    private String m1447bl(String str) {
        return m1449r(getName(), str);
    }

    /* renamed from: bm */
    private static Collection<String> m1448bm(String str) {
        return Arrays.asList(new String[]{m1449r(str, "permissionId"), m1449r(str, "displayName"), m1449r(str, "picture"), m1449r(str, "isAuthenticatedUser"), m1449r(str, "emailAddress")});
    }

    /* renamed from: r */
    private static String m1449r(String str, String str2) {
        return str + "." + str2;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo5119b(DataHolder dataHolder, int i, int i2) {
        return !dataHolder.mo4322h(m1447bl("permissionId"), i, i2);
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public UserMetadata mo5120c(DataHolder dataHolder, int i, int i2) {
        String c = dataHolder.mo4306c(m1447bl("permissionId"), i, i2);
        if (c == null) {
            return null;
        }
        String c2 = dataHolder.mo4306c(m1447bl("displayName"), i, i2);
        String c3 = dataHolder.mo4306c(m1447bl("picture"), i, i2);
        Boolean valueOf = Boolean.valueOf(dataHolder.mo4308d(m1447bl("isAuthenticatedUser"), i, i2));
        return new UserMetadata(c, c2, c3, valueOf.booleanValue(), dataHolder.mo4306c(m1447bl("emailAddress"), i, i2));
    }
}
