package p006nl.volkerinfradesign.checkandroid.p007ui.inspection;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.p001v4.app.DialogFragment;
import android.text.Editable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import p006nl.volkerinfradesign.checkandroid.C1352R;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemConstants;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemKey;
import p006nl.volkerinfradesign.checkandroid.database.InspectionItemType;

/* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.TextDialog */
public class TextDialog extends DialogFragment {
    /* access modifiers changed from: private */

    /* renamed from: aj */
    public static final String f5193aj = null;

    /* renamed from: ak */
    private C1610a f5194ak;

    /* renamed from: nl.volkerinfradesign.checkandroid.ui.inspection.TextDialog$a */
    interface C1610a {
        void onRemarkChanged(InspectionItemKey inspectionItemKey, String str);

        void onValueChanged(InspectionItemKey inspectionItemKey, String str);
    }

    /* renamed from: a */
    public static final TextDialog m6192a(InspectionItemConstants.ItemCursor itemCursor) {
        return m6193a(itemCursor.getKey(), itemCursor.getStringValue(), itemCursor.getTitle(), itemCursor.getType().getInputType(), false);
    }

    /* renamed from: b */
    public static final TextDialog m6194b(InspectionItemConstants.ItemCursor itemCursor) {
        return m6193a(itemCursor.getKey(), itemCursor.getRemark(), "Opmerking", InspectionItemType.STRING.getInputType(), true);
    }

    /* renamed from: a */
    private static TextDialog m6193a(InspectionItemKey inspectionItemKey, String str, String str2, int i, boolean z) {
        TextDialog textDialog = new TextDialog();
        Bundle bundle = new Bundle(5);
        bundle.putParcelable("check:item_key", inspectionItemKey);
        bundle.putString("check:value", str);
        bundle.putString("check:title", str2);
        bundle.putInt("check:input_type", i);
        bundle.putBoolean(f5193aj, z);
        textDialog.setArguments(bundle);
        return textDialog;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        getDialog().getWindow().setSoftInputMode(5);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View inflate = getActivity().getLayoutInflater().inflate(C1352R.layout.ins_2_dialog_text_input, (ViewGroup) null);
        final EditText editText = (EditText) inflate.findViewById(C1352R.C1354id.input);
        String string = getArguments().getString("check:value");
        Editable text = editText.getText();
        if (text == null) {
            editText.setText(string);
        } else if (string != null) {
            text.clear();
            text.append(string);
        }
        editText.setHint(getArguments().getString("check:hint"));
        editText.setInputType(getArguments().getInt("check:input_type"));
        builder.setIcon(C1352R.C1353drawable.ic_action_edit);
        builder.setTitle(getArguments().getString("check:title"));
        builder.setView(inflate);
        builder.setNegativeButton(17039360, (DialogInterface.OnClickListener) null);
        builder.setPositiveButton(17039370, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                InspectionItemKey inspectionItemKey = (InspectionItemKey) TextDialog.this.getArguments().getParcelable("check:item_key");
                String trim = editText.getText().toString().trim();
                if (TextDialog.this.getArguments().getBoolean(TextDialog.f5193aj, false)) {
                    TextDialog.this.m6196m().onRemarkChanged(inspectionItemKey, trim);
                } else {
                    TextDialog.this.m6196m().onValueChanged(inspectionItemKey, trim);
                }
                TextDialog.this.dismiss();
            }
        });
        return builder.create();
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public C1610a m6196m() {
        if (this.f5194ak == null) {
            Object parentFragment = getParentFragment();
            if (!(parentFragment instanceof C1610a)) {
                parentFragment = getActivity();
            }
            this.f5194ak = (C1610a) parentFragment;
        }
        return this.f5194ak;
    }
}
