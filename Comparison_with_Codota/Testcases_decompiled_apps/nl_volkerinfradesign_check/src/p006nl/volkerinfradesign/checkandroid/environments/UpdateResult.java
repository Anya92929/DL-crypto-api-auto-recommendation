package p006nl.volkerinfradesign.checkandroid.environments;

import android.os.Parcelable;

/* renamed from: nl.volkerinfradesign.checkandroid.environments.UpdateResult */
public interface UpdateResult extends Parcelable {
    Exception getError();

    boolean isSuccess();
}
