package p006nl.volkerinfradesign.checkandroid.environments;

import android.os.Parcelable;
import p006nl.volkerinfradesign.checkandroid.database.InspectionKey;

/* renamed from: nl.volkerinfradesign.checkandroid.environments.OriginKey */
public interface OriginKey extends Parcelable {
    InspectionKey getOriginInspectionKey();

    long getOriginServerId();

    boolean hasOriginServerId();
}
