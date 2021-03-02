package com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.C0297d;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GameRef;

public final class ExperienceEventRef extends C0297d implements ExperienceEvent {
    private final GameRef aam;

    public ExperienceEventRef(DataHolder holder, int dataRow) {
        super(holder, dataRow);
        if (mo4339aS("external_game_id")) {
            this.aam = null;
        } else {
            this.aam = new GameRef(this.f693IC, this.f694JQ);
        }
    }

    public String getIconImageUrl() {
        return getString("icon_url");
    }
}
