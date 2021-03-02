package com.caldroid;

import android.view.View;
import java.util.Date;

public abstract class CaldroidListener {
    public abstract void onSelectDate(Date date, View view);

    public void onChangeMonth(int month, int year) {
    }
}
