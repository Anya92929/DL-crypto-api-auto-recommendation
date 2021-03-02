package com.jackhenry.godough.core.login;

import android.os.Bundle;
import android.support.p000v4.app.DialogFragment;
import android.support.p000v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.jackhenry.godough.core.AbstractActivity;
import com.jackhenry.godough.core.C1494ai;
import com.jackhenry.godough.core.C1496ak;
import com.jackhenry.godough.core.C1506am;
import com.jackhenry.godough.core.C1802r;
import com.jackhenry.godough.core.GoDoughApp;
import com.jackhenry.godough.core.model.MFAQuestion;
import com.jackhenry.godough.core.model.MFARecollect;
import com.jackhenry.godough.core.p034b.p035a.C1512c;
import com.jackhenry.godough.core.p038e.C1576e;
import com.jackhenry.godough.core.p038e.C1577f;
import com.jackhenry.godough.core.widgets.ActionButton;
import java.util.List;

public class MFARecollectQuestionsFragment extends C1802r implements View.OnClickListener {
    public static final String TAG = "MFARecollectQuestionFragment";

    /* renamed from: a */
    private ActionButton f6338a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TextView[] f6339b = new TextView[3];

    /* renamed from: c */
    private EditText[] f6340c = new EditText[3];
    /* access modifiers changed from: private */

    /* renamed from: d */
    public MFAQuestion[] f6341d = new MFAQuestion[3];

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m6346a(int i) {
        this.f6340c[i].setText("");
        this.f6340c[i].setEnabled(true);
        m6348a(this.f6340c[i]);
    }

    /* renamed from: a */
    private void m6347a(View view) {
        m6354p();
        MFARecollect mfaRecollect = ((MFARecollectActivity) getActivity()).getMfaRecollect();
        mfaRecollect.setQuestionOne(this.f6341d[0]);
        mfaRecollect.setQuestionTwo(this.f6341d[1]);
        mfaRecollect.setQuestionThree(this.f6341d[2]);
        ((MFARecollectActivity) getActivity()).submitData(mfaRecollect);
    }

    /* renamed from: a */
    private void m6348a(EditText editText) {
        ((InputMethodManager) GoDoughApp.getApp().getSystemService("input_method")).toggleSoftInput(1, 0);
        editText.requestFocus();
        editText.setSelection(editText.getText().length());
    }

    /* renamed from: b */
    private void m6351b(View view) {
        int i;
        int intValue = Integer.valueOf((String) view.getTag()).intValue();
        List<MFAQuestion> questions = ((C1688cf) getActivity()).getQuestions(intValue);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), C1496ak.selection_dialog_list_item, questions);
        arrayAdapter.setDropDownViewResource(C1496ak.selection_dialog_list_item);
        if (this.f6341d[intValue] != null && this.f6341d[intValue].getQuestion() != null) {
            int i2 = 0;
            while (true) {
                i = i2;
                if (i >= this.f6341d.length) {
                    break;
                } else if (questions.get(i).getId() == this.f6341d[intValue].getId()) {
                    break;
                } else {
                    i2 = i + 1;
                }
            }
        }
        i = -1;
        C1512c cVar = new C1512c();
        String str = "";
        switch (intValue) {
            case 0:
                str = getString(C1506am.mfa_question_one_select);
                break;
            case 1:
                str = getString(C1506am.mfa_question_two_select);
                break;
            case 2:
                str = getString(C1506am.mfa_question_three_select);
                break;
        }
        cVar.mo9713b(str);
        cVar.mo9712a(arrayAdapter, i, new C1687ce(this, questions, intValue));
        cVar.show(getActivity().getSupportFragmentManager(), "SELECT_DIALOG");
    }

    /* renamed from: p */
    private void m6354p() {
        for (int i = 0; i < 3; i++) {
            if (this.f6341d[i] != null && this.f6340c[i].getText().toString().length() > 0) {
                this.f6341d[i].setAnswer(this.f6340c[i].getText().toString());
            }
        }
    }

    /* renamed from: q */
    private void m6355q() {
        C1686cd cdVar = new C1686cd(this);
        for (EditText addTextChangedListener : this.f6340c) {
            addTextChangedListener.addTextChangedListener(cdVar);
        }
    }

    /* renamed from: r */
    private void m6356r() {
        for (int i = 0; i < this.f6339b.length; i++) {
            this.f6340c[i].setEnabled(false);
            if (this.f6341d[i] != null) {
                this.f6339b[i].setText(this.f6341d[i].getQuestion());
                this.f6340c[i].setEnabled(true);
                if (this.f6341d[i].getAnswer() != null && this.f6341d[i].getAnswer().length() > 0) {
                    this.f6340c[i].setText(this.f6341d[i].getAnswer());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public void m6357s() {
        mo9924o();
        if (getActivity() != null) {
            ((AbstractActivity) getActivity()).showDialog(new C1576e(C1577f.INFO, 0, getString(C1506am.mfa_recollect_questions_title), getString(C1506am.mfa_info_button_text)));
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public void mo9923n() {
        int i = 0;
        for (int i2 = 0; i2 < this.f6339b.length; i2++) {
            if (!(this.f6341d[i2] == null || this.f6340c[i2].getText().toString() == null || this.f6340c[i2].getText().toString().length() <= 0)) {
                i++;
            }
        }
        if (i == 3) {
            this.f6338a.setEnabled(true);
        } else {
            this.f6338a.setEnabled(false);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public void mo9924o() {
        FragmentManager supportFragmentManager = getActivity().getSupportFragmentManager();
        DialogFragment dialogFragment = (DialogFragment) supportFragmentManager.findFragmentByTag("INFO_DIALOG");
        if (dialogFragment != null) {
            supportFragmentManager.beginTransaction().remove(dialogFragment).commitAllowingStateLoss();
        }
    }

    public void onClick(View view) {
        if (view.getTag() == null || !view.getTag().equals(this.f6338a.getButton().getTag())) {
            m6351b(view);
        } else {
            m6347a(view);
        }
    }

    public void onCreate(Bundle bundle) {
        setRetainInstance(true);
        super.onCreate(bundle);
        MFARecollect mfaRecollect = ((MFARecollectActivity) getActivity()).getMfaRecollect();
        for (int i = 0; i < 3; i++) {
            if (this.f6341d[i] == null) {
                switch (i) {
                    case 0:
                        this.f6341d[i] = mfaRecollect.getQuestionOne();
                        break;
                    case 1:
                        this.f6341d[i] = mfaRecollect.getQuestionTwo();
                        break;
                    case 2:
                        this.f6341d[i] = mfaRecollect.getQuestionThree();
                        break;
                }
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ((AbstractActivity) getActivity()).getSupportActionBar().setTitle(C1506am.security_title);
        View inflate = layoutInflater.inflate(C1496ak.mfa_recollect_questions_fragment, (ViewGroup) null, false);
        ((ImageView) inflate.findViewById(C1494ai.btn_question_info)).setOnClickListener(new C1685cc(this));
        this.f6338a = (ActionButton) inflate.findViewById(C1494ai.btn_submit);
        this.f6338a.getButton().setTag(Integer.valueOf(C1506am.btn_submit));
        this.f6338a.setOnClickListener(this);
        if (((MFARecollectActivity) getActivity()).getMfa().isCollectPhone()) {
            this.f6338a.setText((CharSequence) getString(C1506am.btn_continue));
        }
        this.f6339b[0] = (TextView) inflate.findViewById(C1494ai.question_one);
        this.f6339b[1] = (TextView) inflate.findViewById(C1494ai.question_two);
        this.f6339b[2] = (TextView) inflate.findViewById(C1494ai.question_three);
        inflate.findViewById(C1494ai.question_one_panel).setOnClickListener(this);
        inflate.findViewById(C1494ai.question_two_panel).setOnClickListener(this);
        inflate.findViewById(C1494ai.question_three_panel).setOnClickListener(this);
        this.f6340c[0] = (EditText) inflate.findViewById(C1494ai.answer_one);
        this.f6340c[1] = (EditText) inflate.findViewById(C1494ai.answer_two);
        this.f6340c[2] = (EditText) inflate.findViewById(C1494ai.answer_three);
        m6355q();
        m6356r();
        mo9923n();
        return inflate;
    }

    public void onPause() {
        super.onPause();
        m6354p();
    }
}
