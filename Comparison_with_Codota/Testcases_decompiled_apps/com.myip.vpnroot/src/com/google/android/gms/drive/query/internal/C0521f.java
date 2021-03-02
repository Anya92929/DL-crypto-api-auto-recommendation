package com.google.android.gms.drive.query.internal;

import com.google.android.gms.drive.metadata.C0494b;
import com.google.android.gms.drive.metadata.MetadataField;
import java.util.List;

/* renamed from: com.google.android.gms.drive.query.internal.f */
public interface C0521f<F> {
    /* renamed from: b */
    <T> F mo5206b(C0494b<T> bVar, T t);

    /* renamed from: b */
    <T> F mo5207b(Operator operator, MetadataField<T> metadataField, T t);

    /* renamed from: b */
    F mo5208b(Operator operator, List<F> list);

    /* renamed from: d */
    F mo5212d(MetadataField<?> metadataField);

    /* renamed from: d */
    <T> F mo5213d(MetadataField<T> metadataField, T t);

    /* renamed from: is */
    F mo5215is();

    /* renamed from: j */
    F mo5216j(F f);
}
