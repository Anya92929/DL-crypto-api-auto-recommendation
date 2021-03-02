package p006nl.volkerinfradesign.checkandroid.background;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import p006nl.volkerinfradesign.checkandroid.background.CheckService;

/* renamed from: nl.volkerinfradesign.checkandroid.background.CheckReceiver */
public abstract class CheckReceiver extends BroadcastReceiver {
    public abstract void onExceptionThrown(Exception exc);

    public abstract void onFormsSaved(long[] jArr);

    public abstract void onStructureSaved();

    public abstract void onTaskDownloaded();

    public void onReceive(Context context, Intent intent) {
        switch (CheckService.FilterTag.fromTag(intent.getAction())) {
            case FORMS_SAVED:
                onFormsSaved(intent.getLongArrayExtra(CheckService.FORM_SERVER_IDS));
                break;
            case STRUCTURE_SAVED:
                onStructureSaved();
                break;
            case TASKS_DOWNLOADED:
                onTaskDownloaded();
                break;
        }
        if (intent.hasExtra(CheckService.SERIALIZED_EXCEPTION)) {
            onExceptionThrown((Exception) intent.getSerializableExtra(CheckService.SERIALIZED_EXCEPTION));
        }
    }
}
