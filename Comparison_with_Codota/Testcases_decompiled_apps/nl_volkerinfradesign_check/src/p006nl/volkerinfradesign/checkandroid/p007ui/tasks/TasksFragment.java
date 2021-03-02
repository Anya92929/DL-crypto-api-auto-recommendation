package p006nl.volkerinfradesign.checkandroid.p007ui.tasks;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.net.Uri;
import android.os.Bundle;
import android.support.p001v4.app.Fragment;
import android.support.p001v4.app.FragmentManager;
import android.support.p001v4.app.FragmentTransaction;
import android.support.p001v4.app.ListFragment;
import android.support.p001v4.app.ShareCompat;
import android.support.p001v4.internal.view.SupportMenu;
import android.support.p001v4.view.ViewCompat;
import android.support.p001v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.JsonArray;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import org.apache.commons.p009io.IOUtils;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.OnBackPressedObservable;
import p006nl.volkerinfradesign.checkandroid.data.FileSystem;
import p006nl.volkerinfradesign.checkandroid.database.InspectionKey;
import p006nl.volkerinfradesign.checkandroid.environments.Accounts;
import p006nl.volkerinfradesign.checkandroid.environments.OriginKey;
import p006nl.volkerinfradesign.checkandroid.environments.Tasks;
import p006nl.volkerinfradesign.checkandroid.p007ui.inspection.InspectionActivity;
import p006nl.volkerinfradesign.checkandroid.p007ui.tasks.DownloadFormDialog;
import p006nl.volkerinfradesign.checkandroid.p007ui.tasks.InspectionLoaderDialog;
import p006nl.volkerinfradesign.checkandroid.p007ui.tasks.TaskOptionsFragment;
import p006nl.volkerinfradesign.checkandroid.services.tasks.TasksCallback;
import p006nl.volkerinfradesign.checkandroid.tables.DbUtil;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.tasks.TasksFragment */
public class TasksFragment extends ListFragment implements DownloadFormDialog.DownloadFormDialogParent, InspectionLoaderDialog.InspectionLoaderParent, TaskOptionsFragment.TaskOptionsFragmentParent {

    /* renamed from: aj */
    private OnBackPressedObservable f5533aj;
    /* access modifiers changed from: private */

    /* renamed from: ak */
    public final SimpleDateFormat f5534ak = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());

    /* renamed from: al */
    private final TasksCallback f5535al = new TasksCallback() {
        public void onStart() {
            TasksActivity tasksActivity = (TasksActivity) TasksFragment.this.getActivity();
            if (tasksActivity != null) {
                tasksActivity.showProgress((MenuItem) null, false);
            }
        }

        public void onError(Exception exc) {
            TasksActivity tasksActivity = (TasksActivity) TasksFragment.this.getActivity();
            Toast.makeText(TasksFragment.this.getActivity(), exc.toString(), 1).show();
            if (tasksActivity != null) {
                tasksActivity.finishProgress();
            }
        }

        public void onSessionExpired(Exception exc) {
        }

        public void onSuccess(JsonArray jsonArray) {
            TasksActivity tasksActivity = (TasksActivity) TasksFragment.this.getActivity();
            if (tasksActivity != null) {
                tasksActivity.finishProgress();
            }
        }
    };

    /* renamed from: am */
    private final DataSetObserver f5536am = new DataSetObserver() {
        public void onChanged() {
            C1711a listAdapter = TasksFragment.this.getListAdapter();
            if (listAdapter != null) {
                listAdapter.changeCursor(TasksFragment.this.m6387l().getModel().getTasks().getAll());
            }
        }

        public void onInvalidated() {
            C1711a listAdapter = TasksFragment.this.getListAdapter();
            if (listAdapter != null) {
                listAdapter.changeCursor((Cursor) null);
            }
        }
    };

    /* renamed from: an */
    private final OnBackPressedObservable.OnBackPressedObserver f5537an = new OnBackPressedObservable.OnBackPressedObserver() {
        public boolean onActivityBackPressed() {
            boolean z = false;
            FragmentManager childFragmentManager = TasksFragment.this.getChildFragmentManager();
            Fragment findFragmentByTag = childFragmentManager.findFragmentByTag("task_options_fragment");
            while (findFragmentByTag != null && childFragmentManager.popBackStackImmediate()) {
                findFragmentByTag = childFragmentManager.findFragmentByTag("task_options_fragment");
                z = true;
            }
            return z;
        }
    };

    /* renamed from: i */
    private int f5538i;

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.tasks.TasksFragment$TasksActivity */
    public interface TasksActivity {
        void finishProgress();

        void showProgress(MenuItem menuItem, boolean z);

        boolean uploadInspections();
    }

    public C1711a getListAdapter() {
        return (C1711a) super.getListAdapter();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        C1711a listAdapter;
        super.onActivityResult(i, i2, intent);
        if (i == 777 && (listAdapter = getListAdapter()) != null) {
            listAdapter.changeCursor(m6387l().getModel().getTasks().getAll());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setListAdapter(new C1711a());
        m6387l().getModel().getTasks().registerDataSetObserver(this.f5536am);
        m6387l().getModel().getTasks().download(true, this.f5535al);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        setHasOptionsMenu(true);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(C1352R.C1355menu.todo_menu, menu);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(C1352R.layout.todos_list_content, viewGroup, false);
        this.f5538i = inflate.getId();
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        getListView().setEmptyView(view.findViewById(16908292));
        getListView().setDividerHeight(0);
        m6388m().registerOnBackPressedObserver(this.f5537an);
    }

    public void onDestroyView() {
        m6388m().unregisterOnBackPressedObserver(this.f5537an);
        super.onDestroyView();
    }

    public void onDestroy() {
        C1711a listAdapter = getListAdapter();
        if (listAdapter != null) {
            DbUtil.closeQuietly(listAdapter.getCursor());
        }
        m6387l().getModel().getTasks().unregisterDataSetObserver(this.f5536am);
        super.onDestroy();
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
        super.onListItemClick(listView, view, i, j);
        Tasks.TaskCursor a = getListAdapter().getItem(i);
        Fragment findFragmentByTag = getChildFragmentManager().findFragmentByTag("task_options_fragment");
        FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
        if (findFragmentByTag != null) {
            beginTransaction.remove(findFragmentByTag);
        }
        TaskOptionsFragment.newInstance(a).show(beginTransaction, "task_options_fragment");
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == C1352R.C1354id.download) {
            m6387l().getModel().getTasks().download(true, this.f5535al);
            return true;
        } else if (itemId != C1352R.C1354id.send) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            ((TasksActivity) getActivity()).uploadInspections();
            return true;
        }
    }

    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        menu.findItem(C1352R.C1354id.send).setVisible(m6387l().getModel().getTasks().hasSendableTasks());
    }

    public void onFormDownloaded(long j) {
        C1711a listAdapter = getListAdapter();
        Tasks.TaskCursor all = m6387l().getModel().getTasks().getAll();
        if (all.moveToId(j)) {
            showInspection(all.isInstantiated() ? all.getKey() : all.instantiate(), false);
        }
        if (listAdapter != null) {
            listAdapter.changeCursor(all);
        } else {
            all.close();
        }
    }

    public void showInspection(InspectionKey inspectionKey, boolean z) {
        startActivityForResult(InspectionActivity.getIntent((Context) getActivity(), inspectionKey, z), 777);
    }

    public void onShowOriginClicked(TaskOptionsFragment taskOptionsFragment, Tasks.TaskCursor taskCursor) {
        if (taskCursor.isOriginDownloaded()) {
            showInspection(taskCursor.getOriginInspectionKey(), true);
        } else {
            Fragment findFragmentByTag = getChildFragmentManager().findFragmentByTag("tasks_fragment:download_form_dialog");
            FragmentTransaction beginTransaction = getChildFragmentManager().beginTransaction();
            if (findFragmentByTag != null) {
                beginTransaction.remove(findFragmentByTag);
            }
            InspectionLoaderDialog.newInstance(taskCursor.getOriginKey()).show(beginTransaction, "tasks_fragment:download_form_dialog");
        }
        if (taskOptionsFragment != null) {
            getChildFragmentManager().beginTransaction().remove(taskOptionsFragment).commit();
        }
    }

    public void onShowInspectionClicked(TaskOptionsFragment taskOptionsFragment, Tasks.TaskCursor taskCursor) {
        InspectionKey instantiate;
        Long formServerId = taskCursor.getFormServerId();
        if (formServerId != null) {
            if (formServerId != null && FileSystem.get().getFormsDir().hasForm(formServerId.longValue())) {
                if (taskCursor.isInstantiated()) {
                    instantiate = taskCursor.getKey();
                } else {
                    instantiate = taskCursor.instantiate();
                }
                showInspection(instantiate, false);
            } else {
                FragmentManager childFragmentManager = getChildFragmentManager();
                Fragment findFragmentByTag = childFragmentManager.findFragmentByTag("tasks_fragment:download_form_dialog");
                if (findFragmentByTag != null) {
                    childFragmentManager.beginTransaction().remove(findFragmentByTag).commit();
                }
                DownloadFormDialog.m6354a(taskCursor.getId(), new long[]{formServerId.longValue()}).show(childFragmentManager, "tasks_fragment:download_form_dialog");
            }
            if (taskOptionsFragment != null) {
                getChildFragmentManager().beginTransaction().remove(taskOptionsFragment).commit();
            }
        }
    }

    public void onCancelTaskClicked(Tasks.TaskKey taskKey, String str) {
        Fragment findFragmentByTag = getChildFragmentManager().findFragmentByTag("task_options_fragment");
        taskKey.cancel(str);
        getListAdapter().changeCursor(m6387l().getModel().getTasks().getAll());
        if (findFragmentByTag != null) {
            getChildFragmentManager().beginTransaction().remove(findFragmentByTag).commit();
        }
        m6387l().getModel().getTasks().download(true, this.f5535al);
    }

    public void personInChargeSelected(Tasks.TaskKey taskKey, String str, Accounts.Profile.Person person) {
        taskKey.setDelegated(person, str);
        getListAdapter().changeCursor(m6387l().getModel().getTasks().getAll());
        m6387l().getModel().getTasks().download(true, this.f5535al);
    }

    public void callInitiator(TaskOptionsFragment taskOptionsFragment, Tasks.TaskCursor taskCursor) {
        try {
            startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + taskCursor.getInitiatorPhone())));
        } catch (ActivityNotFoundException e) {
            m6385a("U kunt niet bellen met dit toestel.", e);
        }
    }

    public void mailInitiator(TaskOptionsFragment taskOptionsFragment, Tasks.TaskCursor taskCursor) {
        try {
            ShareCompat.IntentBuilder from = ShareCompat.IntentBuilder.from(getActivity());
            from.setType("message/rfc822");
            from.addEmailTo(taskCursor.getInitiatorEmail());
            from.setSubject(taskCursor.getTitle());
            from.setChooserTitle((CharSequence) "Initiator mailen");
            from.setText("Beste " + taskCursor.getInitiatorName() + ",\n\n");
            from.startChooser();
        } catch (ActivityNotFoundException e) {
            m6385a("Er is geen mailapplicatie gevonden.", e);
        }
    }

    /* renamed from: a */
    private void m6385a(String str, ActivityNotFoundException activityNotFoundException) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setIcon(17301560);
        builder.setTitle("Fout");
        builder.setMessage(str + ":\n\n" + activityNotFoundException.toString());
        builder.setNegativeButton(17039370, (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public App m6387l() {
        return (App) getActivity().getApplication();
    }

    /* renamed from: m */
    private OnBackPressedObservable m6388m() {
        if (this.f5533aj == null) {
            Object parentFragment = getParentFragment();
            if (parentFragment == null || !(parentFragment instanceof OnBackPressedObservable)) {
                parentFragment = getActivity();
            }
            this.f5533aj = (OnBackPressedObservable) parentFragment;
        }
        return this.f5533aj;
    }

    public void onInspectionDownloaded(OriginKey originKey) {
        showInspection(originKey.getOriginInspectionKey(), true);
    }

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.tasks.TasksFragment$a */
    final class C1711a extends CursorAdapter {

        /* renamed from: b */
        private final LayoutInflater f5543b;

        private C1711a() {
            super((Context) TasksFragment.this.getActivity(), (Cursor) TasksFragment.this.m6387l().getModel().getTasks().getAll(), 2);
            this.f5543b = TasksFragment.this.getActivity().getLayoutInflater();
        }

        public void bindView(View view, Context context, Cursor cursor) {
            Tasks.TaskCursor taskCursor = (Tasks.TaskCursor) cursor;
            TextView textView = (TextView) view.findViewById(16908308);
            TextView textView2 = (TextView) view.findViewById(16908309);
            ProgressBar progressBar = (ProgressBar) view.findViewById(16908301);
            String str = "";
            if (taskCursor.hasDescription()) {
                str = str + taskCursor.getDescription() + IOUtils.LINE_SEPARATOR_UNIX;
            }
            if (taskCursor.hasInspectionName()) {
                str = str + taskCursor.getInspectionName() + IOUtils.LINE_SEPARATOR_UNIX;
            }
            textView.setText(taskCursor.getTitle());
            textView2.setText(str + "Deadline: " + TasksFragment.this.f5534ak.format(taskCursor.getDeadLineDate().getTime()));
            if (taskCursor.getDeadLineDate() == null || taskCursor.getDeadLineDate().getTimeInMillis() >= Calendar.getInstance().getTimeInMillis()) {
                textView2.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            } else {
                textView2.setTextColor(SupportMenu.CATEGORY_MASK);
            }
            if (taskCursor.isInstantiated()) {
                progressBar.setProgress((int) (taskCursor.getProgress() * ((float) progressBar.getMax())));
                progressBar.setVisibility(0);
                return;
            }
            progressBar.setVisibility(8);
        }

        /* renamed from: a */
        public Tasks.TaskCursor getCursor() {
            return (Tasks.TaskCursor) super.getCursor();
        }

        /* renamed from: a */
        public Tasks.TaskCursor getItem(int i) {
            return (Tasks.TaskCursor) super.getItem(i);
        }

        public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
            return this.f5543b.inflate(C1352R.layout.task_item, viewGroup, false);
        }
    }
}
