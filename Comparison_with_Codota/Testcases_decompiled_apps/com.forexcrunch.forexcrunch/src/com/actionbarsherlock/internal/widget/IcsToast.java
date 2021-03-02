package com.actionbarsherlock.internal.widget;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import com.actionbarsherlock.C0044R;

public class IcsToast extends Toast {
    public static final int LENGTH_LONG = 1;
    public static final int LENGTH_SHORT = 0;
    private static final String TAG = "Toast";

    public static Toast makeText(Context context, CharSequence s, int duration) {
        if (Build.VERSION.SDK_INT >= 14) {
            return Toast.makeText(context, s, duration);
        }
        IcsToast toast = new IcsToast(context);
        toast.setDuration(duration);
        TextView view = new TextView(context);
        view.setText(s);
        view.setTextColor(-1);
        view.setGravity(17);
        view.setBackgroundResource(C0044R.drawable.abs__toast_frame);
        toast.setView(view);
        return toast;
    }

    public static Toast makeText(Context context, int resId, int duration) {
        return makeText(context, (CharSequence) context.getResources().getString(resId), duration);
    }

    public IcsToast(Context context) {
        super(context);
    }

    public void setText(CharSequence s) {
        if (Build.VERSION.SDK_INT >= 14) {
            super.setText(s);
        } else if (getView() != null) {
            try {
                ((TextView) getView()).setText(s);
            } catch (ClassCastException e) {
                Log.e(TAG, "This Toast was not created with IcsToast.makeText", e);
            }
        }
    }
}
