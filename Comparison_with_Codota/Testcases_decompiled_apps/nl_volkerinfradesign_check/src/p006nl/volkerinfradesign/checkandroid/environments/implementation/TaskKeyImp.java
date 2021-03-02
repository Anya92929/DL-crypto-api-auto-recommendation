package p006nl.volkerinfradesign.checkandroid.environments.implementation;

import android.os.Parcel;
import android.os.Parcelable;
import p006nl.volkerinfradesign.checkandroid.AppState;
import p006nl.volkerinfradesign.checkandroid.environments.Accounts;
import p006nl.volkerinfradesign.checkandroid.environments.Tasks;

/* renamed from: nl.volkerinfradesign.checkandroid.environments.implementation.TaskKeyImp */
final class TaskKeyImp implements Tasks.TaskKey {
    public static final Parcelable.Creator<TaskKeyImp> CREATOR = new Parcelable.Creator<TaskKeyImp>() {
        /* renamed from: a */
        public TaskKeyImp createFromParcel(Parcel parcel) {
            return new TaskKeyImp(parcel);
        }

        /* renamed from: a */
        public TaskKeyImp[] newArray(int i) {
            return new TaskKeyImp[i];
        }
    };

    /* renamed from: a */
    final long f4924a;

    TaskKeyImp(Tasks.TaskCursor taskCursor) {
        this.f4924a = taskCursor.getId();
    }

    public TaskKeyImp(Parcel parcel) {
        this.f4924a = parcel.readLong();
    }

    public Tasks.TaskCursor get() {
        return AppState.getInstance().getModel().getTasks().get(this);
    }

    public void cancel(String str) {
        AppState.getInstance().getModel().getTasks().cancel(this, str);
    }

    public String getTitle() {
        Tasks.TaskCursor taskCursor = get();
        try {
            return taskCursor.moveToFirst() ? taskCursor.getTitle() : null;
        } finally {
            taskCursor.close();
        }
    }

    public void setDelegated(Accounts.Profile.Person person, String str) {
        AppState.getInstance().getModel().getTasks().setDelegated(this, person, str);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f4924a);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String[] mo9662a() {
        return new String[]{Long.toString(this.f4924a)};
    }
}
