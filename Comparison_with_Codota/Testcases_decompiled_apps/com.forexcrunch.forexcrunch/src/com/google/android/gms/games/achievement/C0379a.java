package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.forexcrunch.forexcrunch.gui.ChartActivity;
import com.google.android.gms.common.data.C0342b;
import com.google.android.gms.common.data.C0344d;
import com.google.android.gms.games.C0382d;
import com.google.android.gms.games.Player;
import com.google.android.gms.internal.C0594h;
import com.google.android.gms.internal.C0618r;

/* renamed from: com.google.android.gms.games.achievement.a */
public final class C0379a extends C0342b implements Achievement {
    C0379a(C0344d dVar, int i) {
        super(dVar, i);
    }

    public String getAchievementId() {
        return getString("external_achievement_id");
    }

    public int getCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        C0594h.m1777a(z);
        return getInteger("current_steps");
    }

    public String getDescription() {
        return getString("description");
    }

    public void getDescription(CharArrayBuffer dataOut) {
        mo4037a("description", dataOut);
    }

    public String getFormattedCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        C0594h.m1777a(z);
        return getString("formatted_current_steps");
    }

    public void getFormattedCurrentSteps(CharArrayBuffer dataOut) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        C0594h.m1777a(z);
        mo4037a("formatted_current_steps", dataOut);
    }

    public String getFormattedTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        C0594h.m1777a(z);
        return getString("formatted_total_steps");
    }

    public void getFormattedTotalSteps(CharArrayBuffer dataOut) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        C0594h.m1777a(z);
        mo4037a("formatted_total_steps", dataOut);
    }

    public long getLastUpdatedTimestamp() {
        return getLong("last_updated_timestamp");
    }

    public String getName() {
        return getString("name");
    }

    public void getName(CharArrayBuffer dataOut) {
        mo4037a("name", dataOut);
    }

    public Player getPlayer() {
        return new C0382d(this.f795S, this.f796V);
    }

    public Uri getRevealedImageUri() {
        return mo4038d("revealed_icon_image_uri");
    }

    public int getState() {
        return getInteger("state");
    }

    public int getTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        C0594h.m1777a(z);
        return getInteger("total_steps");
    }

    public int getType() {
        return getInteger(ChartActivity.TYPE);
    }

    public Uri getUnlockedImageUri() {
        return mo4038d("unlocked_icon_image_uri");
    }

    public String toString() {
        C0618r.C0620a a = C0618r.m1882c(this).mo5486a("id", getAchievementId()).mo5486a("name", getName()).mo5486a("state", Integer.valueOf(getState())).mo5486a(ChartActivity.TYPE, Integer.valueOf(getType()));
        if (getType() == 1) {
            a.mo5486a("steps", getCurrentSteps() + "/" + getTotalSteps());
        }
        return a.toString();
    }
}
