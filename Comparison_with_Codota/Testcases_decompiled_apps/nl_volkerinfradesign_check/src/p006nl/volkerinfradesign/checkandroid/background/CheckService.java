package p006nl.volkerinfradesign.checkandroid.background;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.gson.JsonArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.AppState;
import p006nl.volkerinfradesign.checkandroid.data.FileSystem;
import p006nl.volkerinfradesign.checkandroid.data.tree.Form;
import p006nl.volkerinfradesign.checkandroid.data.tree.FormRef;
import p006nl.volkerinfradesign.checkandroid.data.tree.Root;
import p006nl.volkerinfradesign.checkandroid.services.tasks.TasksCallback;

/* renamed from: nl.volkerinfradesign.checkandroid.background.CheckService */
public class CheckService extends IntentService {
    public static final boolean DEBUG = true;
    public static final String FORM_SERVER_IDS = "check:form_server_ids";
    public static final String INTENT_ACTION_FORMS_SAVED = "nl.volkerinfradesign.check.forms_saved";
    public static final String INTENT_ACTION_INSPECTIONS_UPLOADED = "nl.volkerinfradesign.check.inspections_uploaded";
    public static final String INTENT_ACTION_PICTURE_UPLOADED = "nl.volkerinfradesign.check.picture_uploaded";
    public static final String INTENT_ACTION_STRUCTURE_SAVED = "nl.volkerinfradesign.check.structure_saved";
    public static final String PICTURE_RECORD_ID = "check:picture_his_record_id";
    public static final String SERIALIZED_EXCEPTION = "check:serialized_exception";
    public static final String UPLOADED_IDS = "check:uploaded_record_ids";
    public static final String UPLOADED_PICTURES = "check:uploaded_pictures";
    public static final String UPLOADED_PICTURE_FILE = "check:uploaded_picture_file";

    /* renamed from: a */
    private static Intents f4673a;

    public static final IntentFilter getFilter() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(FilterTag.STRUCTURE_SAVED.getTag());
        intentFilter.addAction(FilterTag.FORMS_SAVED.getTag());
        intentFilter.addAction(FilterTag.TASKS_DOWNLOADED.getTag());
        return intentFilter;
    }

    public static Intents getIntents() {
        if (f4673a == null) {
            f4673a = new Intents();
        }
        return f4673a;
    }

    public CheckService() {
        super(CheckService.class.getSimpleName());
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        String action = intent.getAction();
        if ("nl.volkerinfradesign.check.download_structure".equals(action)) {
            m5800b(intent);
        } else if ("nl.volkerinfradesign.check.download_form".equals(action)) {
            m5799a(intent);
        } else if ("download_tasks".equals(action)) {
            m5801c(intent);
        }
    }

    /* renamed from: a */
    private void m5799a(Intent intent) {
        long[] longArrayExtra = intent.getLongArrayExtra(FORM_SERVER_IDS);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Exception exc = null;
        Collections.addAll(arrayList, ArrayUtils.toObject(longArrayExtra));
        while (!arrayList.isEmpty()) {
            List subList = arrayList.subList(0, Math.min(10, arrayList.size()));
            Exception a = m5798a((List<Long>) subList);
            if (a != null) {
                arrayList2.addAll(subList);
                AppState.getInstance().getModel().getLogger().logError("Error while downloading forms.", a);
            } else {
                arrayList3.addAll(subList);
                a = exc;
            }
            subList.clear();
            exc = a;
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < arrayList2.size(); i++) {
            List singletonList = Collections.singletonList(arrayList2.get(i));
            Exception a2 = m5798a((List<Long>) singletonList);
            if (a2 != null) {
                AppState.getInstance().getModel().getLogger().logError("Error while downloading forms.", a2);
                exc = a2;
            } else {
                arrayList3.addAll(singletonList);
            }
        }
        Intent intent2 = new Intent(INTENT_ACTION_FORMS_SAVED);
        intent2.setAction(FilterTag.FORMS_SAVED.name());
        intent2.putExtra(SERIALIZED_EXCEPTION, exc);
        intent2.putExtra(FORM_SERVER_IDS, ArrayUtils.toPrimitive((Long[]) arrayList3.toArray(new Long[arrayList3.size()])));
        sendBroadcast(intent2);
    }

    /* renamed from: a */
    private Exception m5798a(List<Long> list) {
        if (!AppState.getInstance().isThereASession()) {
            return new Exception("Not logged in");
        }
        int i = 0;
        IOException e = null;
        while (i < 3) {
            try {
                for (Form next : Form.download((Collection<Long>) list)) {
                    if (next != null) {
                        next.save();
                    }
                }
                return null;
            } catch (IOException e2) {
                e = e2;
                e.printStackTrace();
                i++;
            }
        }
        return e;
    }

    /* renamed from: b */
    private void m5800b(Intent intent) {
        Intent intent2 = new Intent(INTENT_ACTION_STRUCTURE_SAVED);
        ArrayList arrayList = new ArrayList();
        try {
            Root download = Root.download();
            arrayList.addAll(download.getAllFormRefs());
            download.save();
        } catch (Exception e) {
            intent2.putExtra(SERIALIZED_EXCEPTION, e);
        }
        sendBroadcast(intent2);
        startService(getIntents().downloadForms(getApplicationContext(), arrayList, true));
    }

    /* renamed from: c */
    private void m5801c(Intent intent) {
        final Intent intent2 = new Intent("download_tasks");
        ((App) getApplication()).getModel().getTasks().download(false, new TasksCallback() {
            public void onStart() {
            }

            public void onError(Exception exc) {
                intent2.putExtra(CheckService.SERIALIZED_EXCEPTION, exc);
            }

            public void onSessionExpired(Exception exc) {
                intent2.putExtra(CheckService.SERIALIZED_EXCEPTION, exc);
            }

            public void onSuccess(JsonArray jsonArray) {
            }
        });
        sendBroadcast(intent);
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.background.CheckService$FilterTag */
    public enum FilterTag {
        FORMS_SAVED {
            public String getTag() {
                return CheckService.INTENT_ACTION_FORMS_SAVED;
            }
        },
        STRUCTURE_SAVED {
            public String getTag() {
                return CheckService.INTENT_ACTION_STRUCTURE_SAVED;
            }
        },
        TASKS_DOWNLOADED {
            public String getTag() {
                return "nl.volkerinfradesign.check.tasks_downloaded";
            }
        };

        public abstract String getTag();

        public static final FilterTag fromTag(String str) {
            for (FilterTag filterTag : values()) {
                if (filterTag.getTag() == str) {
                    return filterTag;
                }
            }
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.background.CheckService$Intents */
    public static class Intents {
        public Intent downloadForm(Context context, FormRef formRef) {
            Intent intent = new Intent(context, CheckService.class);
            intent.setAction("nl.volkerinfradesign.check.download_form");
            intent.putExtra(CheckService.FORM_SERVER_IDS, new long[]{formRef.getServerId()});
            return intent;
        }

        public Intent downloadForms(Context context, Iterable<FormRef> iterable, boolean z) {
            Intent intent = new Intent(context, CheckService.class);
            HashSet hashSet = new HashSet();
            if (iterable != null) {
                for (FormRef serverId : iterable) {
                    hashSet.add(Long.valueOf(serverId.getServerId()));
                }
            }
            if (z) {
                hashSet.addAll(FileSystem.get().getFormsDir().getFormIds());
            }
            long[] primitive = ArrayUtils.toPrimitive((Long[]) hashSet.toArray(new Long[hashSet.size()]));
            intent.setAction("nl.volkerinfradesign.check.download_form");
            intent.putExtra(CheckService.FORM_SERVER_IDS, primitive);
            return intent;
        }

        public Intent downloadStructure(Context context) {
            Intent intent = new Intent(context, CheckService.class);
            intent.setAction("nl.volkerinfradesign.check.download_structure");
            return intent;
        }

        public Intent downloadTasks(Context context) {
            Intent intent = new Intent(context, CheckService.class);
            intent.setAction("download_tasks");
            return intent;
        }
    }
}
