package p006nl.volkerinfradesign.checkandroid.environments;

import android.database.DataSetObserver;
import android.os.Parcelable;
import java.util.Calendar;
import p006nl.volkerinfradesign.checkandroid.database.InspectionKey;
import p006nl.volkerinfradesign.checkandroid.database.InspectionsTable;
import p006nl.volkerinfradesign.checkandroid.environments.Accounts;
import p006nl.volkerinfradesign.checkandroid.services.tasks.TasksCallback;
import p006nl.volkerinfradesign.checkandroid.tables.ViTaCursor;

/* renamed from: nl.volkerinfradesign.checkandroid.environments.Tasks */
public interface Tasks {

    /* renamed from: nl.volkerinfradesign.checkandroid.environments.Tasks$TaskCursor */
    public interface TaskCursor extends ViTaCursor {
        long getCompanyServerId();

        Calendar getDeadLineDate();

        String getDescription();

        Long getFormServerId();

        String getInitiatorEmail();

        String getInitiatorName();

        String getInitiatorPhone();

        Long getInspectionId();

        String getInspectionName();

        InspectionKey getKey();

        InspectionKey getOriginInspectionKey();

        OriginKey getOriginKey();

        Long getOriginServerId();

        float getProgress();

        long getServerId();

        TaskKey getTaskKey();

        String getTitle();

        boolean hasDescription();

        boolean hasInitiatorEmail();

        boolean hasInitiatorName();

        boolean hasInitiatorPhone();

        boolean hasInspectionName();

        boolean hasOriginServerId();

        InspectionKey instantiate();

        boolean isInstantiated();

        boolean isOriginDownloaded();
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.environments.Tasks$TaskKey */
    public interface TaskKey extends Parcelable {
        void cancel(String str);

        TaskCursor get();

        String getTitle();

        void setDelegated(Accounts.Profile.Person person, String str);
    }

    void cancel(TaskKey taskKey, String str);

    boolean deleteSoft(InspectionsTable.DataCursor dataCursor, boolean z);

    boolean deleteSoft(TaskCursor taskCursor);

    boolean detachInspection(InspectionKey inspectionKey);

    void download(boolean z, TasksCallback tasksCallback);

    TaskCursor get(TaskKey taskKey);

    TaskCursor getAll();

    int getCount();

    boolean hasSendableTasks();

    boolean isEmpty();

    void registerDataSetObserver(DataSetObserver dataSetObserver);

    void setDelegated(TaskKey taskKey, Accounts.Profile.Person person, String str);

    int size();

    void unregisterDataSetObserver(DataSetObserver dataSetObserver);
}
