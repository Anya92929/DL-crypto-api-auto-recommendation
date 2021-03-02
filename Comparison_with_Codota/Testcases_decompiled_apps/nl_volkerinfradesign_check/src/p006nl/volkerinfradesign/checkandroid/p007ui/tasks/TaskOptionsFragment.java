package p006nl.volkerinfradesign.checkandroid.p007ui.tasks;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.p001v4.app.DialogFragment;
import android.support.p001v4.app.Fragment;
import android.support.p001v4.app.FragmentTransaction;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import org.apache.commons.lang3.StringUtils;
import p006nl.volkerinfradesign.checkandroid.App;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.environments.Accounts;
import p006nl.volkerinfradesign.checkandroid.environments.Tasks;
import p006nl.volkerinfradesign.checkandroid.p007ui.tasks.DelegateTaskFragment;
import p006nl.volkerinfradesign.checkandroid.util.SimpleTextWatcher;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.tasks.TaskOptionsFragment */
public class TaskOptionsFragment extends DialogFragment implements DelegateTaskFragment.DelegateTaskFragmentParent {

    /* renamed from: aj */
    private Tasks.TaskKey f5523aj;

    /* renamed from: ak */
    private TaskOptionsFragmentParent f5524ak;
    /* access modifiers changed from: private */

    /* renamed from: al */
    public boolean f5525al;
    /* access modifiers changed from: private */

    /* renamed from: am */
    public String f5526am;

    /* renamed from: an */
    private final View.OnClickListener f5527an = new View.OnClickListener() {
        public void onClick(View view) {
            Tasks.TaskCursor taskCursor = TaskOptionsFragment.this.m6381m().get();
            try {
                if (taskCursor.moveToFirst()) {
                    int id = view.getId();
                    if (id == C1352R.C1354id.callInitiator) {
                        TaskOptionsFragment.this.m6383o().callInitiator(TaskOptionsFragment.this, taskCursor);
                    } else if (id == C1352R.C1354id.mailInitiator) {
                        TaskOptionsFragment.this.m6383o().mailInitiator(TaskOptionsFragment.this, taskCursor);
                    } else if (id == C1352R.C1354id.showOrigin) {
                        TaskOptionsFragment.this.m6383o().onShowOriginClicked(TaskOptionsFragment.this, taskCursor);
                    } else if (id == C1352R.C1354id.showInspection) {
                        TaskOptionsFragment.this.m6383o().onShowInspectionClicked(TaskOptionsFragment.this, taskCursor);
                    } else if (id == C1352R.C1354id.cancelTask) {
                        TaskOptionsFragment.this.m6380l();
                    } else if (id == C1352R.C1354id.delegateTask) {
                        FragmentTransaction beginTransaction = TaskOptionsFragment.this.getChildFragmentManager().beginTransaction();
                        Fragment findFragmentByTag = TaskOptionsFragment.this.getChildFragmentManager().findFragmentByTag("delegate_task_fragment");
                        if (findFragmentByTag != null) {
                            beginTransaction.remove(findFragmentByTag);
                        }
                        new DelegateTaskFragment().show(beginTransaction, "delegate_task_fragment");
                    }
                }
            } finally {
                taskCursor.close();
            }
        }
    };

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.tasks.TaskOptionsFragment$TaskOptionsFragmentParent */
    public interface TaskOptionsFragmentParent {
        void callInitiator(TaskOptionsFragment taskOptionsFragment, Tasks.TaskCursor taskCursor);

        void mailInitiator(TaskOptionsFragment taskOptionsFragment, Tasks.TaskCursor taskCursor);

        void onCancelTaskClicked(Tasks.TaskKey taskKey, String str);

        void onShowInspectionClicked(TaskOptionsFragment taskOptionsFragment, Tasks.TaskCursor taskCursor);

        void onShowOriginClicked(TaskOptionsFragment taskOptionsFragment, Tasks.TaskCursor taskCursor);

        void personInChargeSelected(Tasks.TaskKey taskKey, String str, Accounts.Profile.Person person);
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m6380l() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View inflate = getActivity().getLayoutInflater().inflate(C1352R.layout.task_dialog_input, (ViewGroup) null);
        final EditText editText = (EditText) inflate.findViewById(C1352R.C1354id.input);
        final C17062 r3 = new SimpleTextWatcher() {
            public void afterTextChanged(Editable editable) {
                String unused = TaskOptionsFragment.this.f5526am = editable.toString().trim();
            }
        };
        C17073 r4 = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                boolean unused = TaskOptionsFragment.this.f5525al = false;
                String unused2 = TaskOptionsFragment.this.f5526am = null;
                editText.removeTextChangedListener(r3);
                if (i == -1) {
                    String trim = editText.getText().toString().trim();
                    if (StringUtils.isBlank(trim)) {
                        Toast.makeText(TaskOptionsFragment.this.getActivity(), "Geef een reden op.", 1).show();
                        return;
                    }
                    TaskOptionsFragment.this.m6383o().onCancelTaskClicked(TaskOptionsFragment.this.m6381m(), trim);
                    dialogInterface.dismiss();
                    return;
                }
                dialogInterface.dismiss();
            }
        };
        editText.setText(this.f5526am);
        editText.addTextChangedListener(r3);
        builder.setTitle("Taak sluiten");
        builder.setMessage("Waarom sluit u deze taak?");
        builder.setView(inflate);
        builder.setNegativeButton(17039360, r4);
        builder.setPositiveButton(17039370, r4);
        builder.show();
        this.f5525al = true;
    }

    public static final TaskOptionsFragment newInstance(Tasks.TaskCursor taskCursor) {
        TaskOptionsFragment taskOptionsFragment = new TaskOptionsFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("task_options:task_key", taskCursor.getTaskKey());
        taskOptionsFragment.setArguments(bundle);
        return taskOptionsFragment;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.f5525al = bundle.getBoolean("task_options:showing_dialog");
            this.f5526am = bundle.getString("task_options:dialog_text");
        }
    }

    @NonNull
    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.setTitle(m6381m().getTitle());
        return onCreateDialog;
    }

    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(C1352R.layout.task_dialog, viewGroup, false);
        Tasks.TaskCursor taskCursor = m6382n().getModel().getTasks().get(m6381m());
        try {
            if (!taskCursor.moveToFirst()) {
                throw new IllegalArgumentException("Could not find the task!");
            }
            TextView textView = (TextView) inflate.findViewById(C1352R.C1354id.initiatorName);
            Button button = (Button) inflate.findViewById(C1352R.C1354id.mailInitiator);
            Button button2 = (Button) inflate.findViewById(C1352R.C1354id.callInitiator);
            Button button3 = (Button) inflate.findViewById(C1352R.C1354id.showOrigin);
            Button button4 = (Button) inflate.findViewById(C1352R.C1354id.showInspection);
            if (taskCursor.getFormServerId() != null) {
                button4.setVisibility(0);
                button4.setOnClickListener(this.f5527an);
            } else {
                button4.setVisibility(8);
            }
            if (taskCursor.getOriginServerId() != null) {
                button3.setVisibility(0);
                button3.setOnClickListener(this.f5527an);
            } else {
                button3.setVisibility(8);
            }
            button4.setOnClickListener(this.f5527an);
            inflate.findViewById(C1352R.C1354id.cancelTask).setOnClickListener(this.f5527an);
            inflate.findViewById(C1352R.C1354id.delegateTask).setOnClickListener(this.f5527an);
            if (taskCursor.hasInitiatorName()) {
                textView.setText("Melding gemaakt door: " + taskCursor.getInitiatorName());
                if (taskCursor.hasInitiatorEmail()) {
                    button.setVisibility(0);
                    button.setText(taskCursor.getInitiatorEmail());
                    button.setOnClickListener(this.f5527an);
                } else {
                    button.setVisibility(8);
                }
                if (taskCursor.hasInitiatorPhone()) {
                    button2.setVisibility(0);
                    button2.setText(taskCursor.getInitiatorPhone());
                    button2.setOnClickListener(this.f5527an);
                } else {
                    button2.setVisibility(8);
                }
            } else {
                inflate.findViewById(C1352R.C1354id.noInitiator).setVisibility(0);
                textView.setVisibility(8);
                button.setVisibility(8);
                button2.setVisibility(8);
            }
            return inflate;
        } finally {
            taskCursor.close();
        }
    }

    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.f5525al) {
            m6380l();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("task_options:showing_dialog", this.f5525al);
        bundle.putString("task_options:dialog_text", this.f5526am);
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public Tasks.TaskKey m6381m() {
        if (this.f5523aj == null) {
            this.f5523aj = (Tasks.TaskKey) getArguments().getParcelable("task_options:task_key");
        }
        return this.f5523aj;
    }

    /* renamed from: n */
    private App m6382n() {
        return (App) getActivity().getApplication();
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public TaskOptionsFragmentParent m6383o() {
        if (this.f5524ak == null) {
            Object parentFragment = getParentFragment();
            if (parentFragment == null || !(parentFragment instanceof TaskOptionsFragmentParent)) {
                parentFragment = getActivity();
            }
            this.f5524ak = (TaskOptionsFragmentParent) parentFragment;
        }
        return this.f5524ak;
    }

    public void personInChargeSelected(String str, Accounts.Profile.Person person) {
        m6383o().personInChargeSelected(m6381m(), str, person);
        dismiss();
    }
}
