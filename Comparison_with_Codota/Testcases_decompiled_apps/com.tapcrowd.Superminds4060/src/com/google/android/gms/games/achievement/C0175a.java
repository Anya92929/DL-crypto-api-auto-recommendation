package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.C0138b;
import com.google.android.gms.common.data.C0140d;
import com.google.android.gms.games.C0178d;
import com.google.android.gms.games.Player;
import com.google.android.gms.internal.C0384db;
import com.google.android.gms.internal.C0408dl;
import com.google.android.gms.plus.PlusShare;
import com.tapcrowd.app.modules.favorites_v2.DBFavorites;
import org.apache.cordova.Globalization;

/* renamed from: com.google.android.gms.games.achievement.a */
public final class C0175a extends C0138b implements Achievement {
    C0175a(C0140d dVar, int i) {
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
        C0384db.m831k(z);
        return getInteger("current_steps");
    }

    public String getDescription() {
        return getString(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION);
    }

    public void getDescription(CharArrayBuffer dataOut) {
        mo3584a(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, dataOut);
    }

    public String getFormattedCurrentSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        C0384db.m831k(z);
        return getString("formatted_current_steps");
    }

    public void getFormattedCurrentSteps(CharArrayBuffer dataOut) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        C0384db.m831k(z);
        mo3584a("formatted_current_steps", dataOut);
    }

    public String getFormattedTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        C0384db.m831k(z);
        return getString("formatted_total_steps");
    }

    public void getFormattedTotalSteps(CharArrayBuffer dataOut) {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        C0384db.m831k(z);
        mo3584a("formatted_total_steps", dataOut);
    }

    public long getLastUpdatedTimestamp() {
        return getLong("last_updated_timestamp");
    }

    public String getName() {
        return getString(DBFavorites.KEY_NAME);
    }

    public void getName(CharArrayBuffer dataOut) {
        mo3584a(DBFavorites.KEY_NAME, dataOut);
    }

    public Player getPlayer() {
        return new C0178d(this.f369jf, this.f370ji);
    }

    public Uri getRevealedImageUri() {
        return mo3591u("revealed_icon_image_uri");
    }

    public int getState() {
        return getInteger("state");
    }

    public int getTotalSteps() {
        boolean z = true;
        if (getType() != 1) {
            z = false;
        }
        C0384db.m831k(z);
        return getInteger("total_steps");
    }

    public int getType() {
        return getInteger(Globalization.TYPE);
    }

    public Uri getUnlockedImageUri() {
        return mo3591u("unlocked_icon_image_uri");
    }

    public String toString() {
        C0408dl.C0410a a = C0408dl.m938d(this).mo4388a(DBFavorites.KEY_EVENT_ID, getAchievementId()).mo4388a(DBFavorites.KEY_NAME, getName()).mo4388a("state", Integer.valueOf(getState())).mo4388a(Globalization.TYPE, Integer.valueOf(getType()));
        if (getType() == 1) {
            a.mo4388a("steps", getCurrentSteps() + "/" + getTotalSteps());
        }
        return a.toString();
    }
}
