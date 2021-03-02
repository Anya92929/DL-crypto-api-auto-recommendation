package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SortOrder implements SafeParcelable {
    public static final Parcelable.Creator<SortOrder> CREATOR = new C0514b();

    /* renamed from: BR */
    final int f1117BR;

    /* renamed from: QA */
    final List<FieldWithSortOrder> f1118QA;

    /* renamed from: QB */
    final boolean f1119QB;

    public static class Builder {

        /* renamed from: QA */
        private final List<FieldWithSortOrder> f1120QA = new ArrayList();

        /* renamed from: QB */
        private boolean f1121QB = false;

        public Builder addSortAscending(SortableMetadataField sortField) {
            this.f1120QA.add(new FieldWithSortOrder(sortField.getName(), true));
            return this;
        }

        public Builder addSortDescending(SortableMetadataField sortField) {
            this.f1120QA.add(new FieldWithSortOrder(sortField.getName(), false));
            return this;
        }

        public SortOrder build() {
            return new SortOrder((List) this.f1120QA, this.f1121QB);
        }
    }

    SortOrder(int versionCode, List<FieldWithSortOrder> sortingFields, boolean sortFolderFirst) {
        this.f1117BR = versionCode;
        this.f1118QA = sortingFields;
        this.f1119QB = sortFolderFirst;
    }

    private SortOrder(List<FieldWithSortOrder> sortingFields, boolean sortFolderFirst) {
        this(1, sortingFields, sortFolderFirst);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format(Locale.US, "SortOrder[%s, %s]", new Object[]{TextUtils.join(",", this.f1118QA), Boolean.valueOf(this.f1119QB)});
    }

    public void writeToParcel(Parcel out, int flags) {
        C0514b.m1462a(this, out, flags);
    }
}
