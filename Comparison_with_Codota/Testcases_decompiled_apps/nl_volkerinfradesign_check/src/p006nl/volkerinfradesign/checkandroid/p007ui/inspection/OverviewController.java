package p006nl.volkerinfradesign.checkandroid.p007ui.inspection;

import android.os.Parcel;
import android.os.Parcelable;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemConstants;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemKey;
import p006nl.volkerinfradesign.checkandroid.database.InspectionKey;
import p006nl.volkerinfradesign.checkandroid.database.InspectionsTable;
import p006nl.volkerinfradesign.checkandroid.database.Schema;
import p006nl.volkerinfradesign.checkandroid.util.CursorUtil;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.OverviewController */
public class OverviewController implements Parcelable {
    public static final Parcelable.Creator<OverviewController> CREATOR = new Parcelable.Creator<OverviewController>() {
        /* renamed from: a */
        public OverviewController createFromParcel(Parcel parcel) {
            return new OverviewController(parcel);
        }

        /* renamed from: a */
        public OverviewController[] newArray(int i) {
            return new OverviewController[i];
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Observer f5136a = Observer.EMPTY_INSTANCE;

    /* renamed from: b */
    private final String f5137b;
    public final InspectionItemKey itemKey;
    public final int position;

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.OverviewController$Observer */
    public interface Observer {
        public static final Observer EMPTY_INSTANCE = new Observer() {
            public void onSubInspectionsChanged() {
            }
        };

        void onSubInspectionsChanged();
    }

    OverviewController(InspectionItemConstants.ItemCursor itemCursor, int i) {
        this.position = i;
        this.f5137b = itemCursor.getTitle();
        this.itemKey = itemCursor.getKey();
        m6144a(itemCursor);
    }

    protected OverviewController(Parcel parcel) {
        this.itemKey = (InspectionItemKey) parcel.readParcelable((ClassLoader) null);
        this.f5137b = parcel.readString();
        this.position = parcel.readInt();
        CursorUtil<InspectionItemConstants.ItemCursor> a = m6142a();
        try {
            m6144a(a.getFirst());
        } finally {
            a.closeQuietly();
        }
    }

    public int getCount() {
        CursorUtil<InspectionsTable.DataCursor> b = m6146b();
        try {
            return b.getCount();
        } finally {
            b.closeQuietly();
        }
    }

    public OverviewItemController getItem(int i) {
        CursorUtil<InspectionsTable.DataCursor> b = m6146b();
        try {
            return new OverviewItemController(b.get(i));
        } finally {
            b.closeQuietly();
        }
    }

    public boolean addInspection() {
        CursorUtil<InspectionItemConstants.ItemCursor> a = m6142a();
        try {
            boolean addSubInspection = a.getFirst().addSubInspection();
            if (addSubInspection) {
                this.f5136a.onSubInspectionsChanged();
            }
            return addSubInspection;
        } finally {
            a.closeQuietly();
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.itemKey, 0);
        parcel.writeString(this.f5137b);
        parcel.writeInt(this.position);
    }

    /* renamed from: a */
    private void m6144a(InspectionItemConstants.ItemCursor itemCursor) {
        if (itemCursor.isTable() && !itemCursor.hasSubInspections() && itemCursor.hasTriggeredCondition()) {
            addInspection();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public CursorUtil<InspectionItemConstants.ItemCursor> m6142a() {
        return new CursorUtil<InspectionItemConstants.ItemCursor>() {
            /* renamed from: a */
            public InspectionItemConstants.ItemCursor query() {
                return OverviewController.this.itemKey.get();
            }
        };
    }

    /* renamed from: b */
    private CursorUtil<InspectionsTable.DataCursor> m6146b() {
        return new CursorUtil<InspectionsTable.DataCursor>() {

            /* renamed from: a */
            final CursorUtil<InspectionItemConstants.ItemCursor> f5139a = OverviewController.this.m6142a();

            /* renamed from: a */
            public InspectionsTable.DataCursor query() {
                return this.f5139a.getFirst().getSubInspections(false);
            }

            public void closeQuietly() {
                this.f5139a.closeQuietly();
                super.closeQuietly();
            }
        };
    }

    public void onCreate(Observer observer) {
        if (observer == null) {
            observer = Observer.EMPTY_INSTANCE;
        }
        this.f5136a = observer;
    }

    public void onDestroy() {
        this.f5136a = Observer.EMPTY_INSTANCE;
    }

    public int getPosition() {
        return this.position;
    }

    public String getTitle() {
        return this.f5137b;
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.OverviewController$OverviewItemController */
    public class OverviewItemController {

        /* renamed from: a */
        final String f5141a;

        /* renamed from: b */
        final String f5142b;

        /* renamed from: c */
        final InspectionKey f5143c;

        /* renamed from: d */
        final int f5144d;

        public OverviewItemController(final InspectionsTable.DataCursor dataCursor) {
            C15921 r1 = new CursorUtil<InspectionItemConstants.ItemCursor>(OverviewController.this) {
                /* renamed from: a */
                public InspectionItemConstants.ItemCursor query() {
                    return Schema.getInspectionItems().getItems(dataCursor.getKey(), false);
                }
            };
            this.f5144d = dataCursor.getPosition();
            this.f5141a = dataCursor.getTitle() + " " + (this.f5144d + 1);
            this.f5142b = ((InspectionItemConstants.ItemCursor) r1.getFirst()).getStringValue();
            this.f5143c = dataCursor.getKey();
            r1.closeQuietly();
        }

        public String getTitle() {
            return this.f5141a;
        }

        public String getDescription() {
            return this.f5142b;
        }

        public InspectionKey getInspection() {
            return this.f5143c;
        }

        public boolean hasInspection() {
            return this.f5143c != null;
        }

        public void delete() {
            if (this.f5143c != null) {
                this.f5143c.delete();
                OverviewController.this.f5136a.onSubInspectionsChanged();
            }
        }

        public int getPosition() {
            return this.f5144d;
        }

        public boolean isValid() {
            return this.f5143c != null && this.f5143c.isValid();
        }
    }
}
