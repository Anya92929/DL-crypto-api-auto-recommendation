package p006nl.volkerinfradesign.checkandroid.background;

import android.os.Parcelable;

/* renamed from: nl.volkerinfradesign.checkandroid.background.UploadReport */
public interface UploadReport extends Parcelable {
    String getDescription();

    Exception getException();

    boolean hasException();

    boolean isSucces();
}
