package p006nl.volkerinfradesign.checkandroid.background;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.Observable;
import p006nl.volkerinfradesign.checkandroid.data.tree.Root;

/* renamed from: nl.volkerinfradesign.checkandroid.background.CheckServiceManager */
public class CheckServiceManager extends BroadcastReceiver {

    /* renamed from: a */
    private final IntentFilter f4677a = new IntentFilter();

    /* renamed from: b */
    private final ServiceEventsObservable f4678b = new ServiceEventsObservable();

    /* renamed from: nl.volkerinfradesign.checkandroid.background.CheckServiceManager$ServiceEvents */
    public interface ServiceEvents {
        void notifyFormsDownloaded();

        void notifyInspectionsChanged();

        void notifyPictureUploaded();

        void notifyRootLoaded(Root root);
    }

    public CheckServiceManager() {
        this.f4677a.addAction(CheckService.INTENT_ACTION_STRUCTURE_SAVED);
        this.f4677a.addAction(CheckService.INTENT_ACTION_INSPECTIONS_UPLOADED);
        this.f4677a.addAction(CheckService.INTENT_ACTION_PICTURE_UPLOADED);
        this.f4677a.addAction(CheckService.INTENT_ACTION_FORMS_SAVED);
    }

    public final ServiceEvents getObservable() {
        return this.f4678b;
    }

    public void onExceptionReceived(Exception exc, Intent intent) {
    }

    public void onFormsDownloaded(Intent intent) {
    }

    public void onInspectionsUploaded(Intent intent) {
    }

    public void onPictureUploaded(Intent intent) {
    }

    public final void onReceive(Context context, Intent intent) {
        Exception exc = (Exception) intent.getSerializableExtra(CheckService.SERIALIZED_EXCEPTION);
        if (exc != null) {
            onExceptionReceived(exc, intent);
            return;
        }
        String action = intent.getAction();
        if (CheckService.INTENT_ACTION_PICTURE_UPLOADED.equals(action)) {
            onPictureUploaded(intent);
        } else if (CheckService.INTENT_ACTION_INSPECTIONS_UPLOADED.equals(action)) {
            onInspectionsUploaded(intent);
        } else if (CheckService.INTENT_ACTION_STRUCTURE_SAVED.equals(action)) {
            onStructureSaved(intent);
        } else if (CheckService.INTENT_ACTION_FORMS_SAVED.equals(action)) {
            onFormsDownloaded(intent);
        }
    }

    public void onStatusUploaded(Intent intent) {
    }

    public void onStructureSaved(Intent intent) {
    }

    public final void registerReceiver(Context context) {
        context.registerReceiver(this, this.f4677a);
    }

    public final void registerServiceEventsObserver(ServiceEvents serviceEvents) {
        this.f4678b.registerObserver(serviceEvents);
    }

    public final void unregisterReceiver(Context context) {
        context.unregisterReceiver(this);
    }

    public final void unregisterServiceEventsObserver(ServiceEvents serviceEvents) {
        this.f4678b.unregisterObserver(serviceEvents);
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.background.CheckServiceManager$ServiceEventsObservable */
    public class ServiceEventsObservable extends Observable<ServiceEvents> implements ServiceEvents {
        public ServiceEventsObservable() {
        }

        public void notifyFormsDownloaded() {
            synchronized (this.mObservers) {
                for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                    ((ServiceEvents) this.mObservers.get(size)).notifyFormsDownloaded();
                }
            }
        }

        public void notifyInspectionsChanged() {
            synchronized (this.mObservers) {
                for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                    ((ServiceEvents) this.mObservers.get(size)).notifyInspectionsChanged();
                }
            }
        }

        public void notifyPictureUploaded() {
            synchronized (this.mObservers) {
                for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                    ((ServiceEvents) this.mObservers.get(size)).notifyPictureUploaded();
                }
            }
        }

        public void notifyRootLoaded(Root root) {
            synchronized (this.mObservers) {
                for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                    ((ServiceEvents) this.mObservers.get(size)).notifyRootLoaded(root);
                }
            }
        }
    }
}
