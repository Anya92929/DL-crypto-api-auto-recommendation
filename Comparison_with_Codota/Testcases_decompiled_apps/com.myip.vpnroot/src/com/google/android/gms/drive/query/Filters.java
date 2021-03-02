package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.query.internal.ComparisonFilter;
import com.google.android.gms.drive.query.internal.FieldOnlyFilter;
import com.google.android.gms.drive.query.internal.InFilter;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.NotFilter;
import com.google.android.gms.drive.query.internal.Operator;

public class Filters {
    public static Filter and(Filter filter, Filter... additionalFilters) {
        return new LogicalFilter(Operator.f1159QW, filter, additionalFilters);
    }

    public static Filter and(Iterable<Filter> filters) {
        return new LogicalFilter(Operator.f1159QW, filters);
    }

    public static Filter contains(SearchableMetadataField<String> field, String value) {
        return new ComparisonFilter(Operator.f1162QZ, field, value);
    }

    /* renamed from: eq */
    public static <T> Filter m1454eq(SearchableMetadataField<T> field, T value) {
        return new ComparisonFilter(Operator.f1154QR, field, value);
    }

    public static <T extends Comparable<T>> Filter greaterThan(SearchableOrderedMetadataField<T> field, T value) {
        return new ComparisonFilter(Operator.f1157QU, field, value);
    }

    public static <T extends Comparable<T>> Filter greaterThanEquals(SearchableOrderedMetadataField<T> field, T value) {
        return new ComparisonFilter(Operator.f1158QV, field, value);
    }

    /* renamed from: in */
    public static <T> Filter m1455in(SearchableCollectionMetadataField<T> field, T value) {
        return new InFilter(field, value);
    }

    public static <T extends Comparable<T>> Filter lessThan(SearchableOrderedMetadataField<T> field, T value) {
        return new ComparisonFilter(Operator.f1155QS, field, value);
    }

    public static <T extends Comparable<T>> Filter lessThanEquals(SearchableOrderedMetadataField<T> field, T value) {
        return new ComparisonFilter(Operator.f1156QT, field, value);
    }

    public static Filter not(Filter toNegate) {
        return new NotFilter(toNegate);
    }

    public static Filter openedByMe() {
        return new FieldOnlyFilter(SearchableField.LAST_VIEWED_BY_ME);
    }

    /* renamed from: or */
    public static Filter m1456or(Filter filter, Filter... additionalFilters) {
        return new LogicalFilter(Operator.f1160QX, filter, additionalFilters);
    }

    /* renamed from: or */
    public static Filter m1457or(Iterable<Filter> filters) {
        return new LogicalFilter(Operator.f1160QX, filters);
    }

    public static Filter sharedWithMe() {
        return new FieldOnlyFilter(SearchableField.f1115Qy);
    }
}
