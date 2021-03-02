package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.C0297d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.C0345m;
import com.google.android.gms.games.internal.constants.PlatformType;

public final class GameInstanceRef extends C0297d implements GameInstance {
    GameInstanceRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
    }

    public String getApplicationId() {
        return getString("external_game_id");
    }

    public String getDisplayName() {
        return getString("instance_display_name");
    }

    public String getPackageName() {
        return getString("package_name");
    }

    /* renamed from: lb */
    public boolean mo7374lb() {
        return getInteger("real_time_support") > 0;
    }

    /* renamed from: lc */
    public boolean mo7375lc() {
        return getInteger("turn_based_support") > 0;
    }

    /* renamed from: ld */
    public int mo7376ld() {
        return getInteger("platform_type");
    }

    /* renamed from: le */
    public boolean mo7377le() {
        return getInteger("piracy_check") > 0;
    }

    /* renamed from: lf */
    public boolean mo7378lf() {
        return getInteger("installed") > 0;
    }

    public String toString() {
        return C0345m.m848h(this).mo4549a("ApplicationId", getApplicationId()).mo4549a("DisplayName", getDisplayName()).mo4549a("SupportsRealTime", Boolean.valueOf(mo7374lb())).mo4549a("SupportsTurnBased", Boolean.valueOf(mo7375lc())).mo4549a("PlatformType", PlatformType.m3518dH(mo7376ld())).mo4549a("PackageName", getPackageName()).mo4549a("PiracyCheckEnabled", Boolean.valueOf(mo7377le())).mo4549a("Installed", Boolean.valueOf(mo7378lf())).toString();
    }
}
