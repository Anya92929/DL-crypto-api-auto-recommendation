package com.google.android.gms.location.places.internal;

import android.text.SpannableString;
import android.text.style.CharacterStyle;
import com.google.android.gms.common.internal.zzv;
import com.google.android.gms.location.places.internal.AutocompletePredictionEntity;
import java.util.Collection;
import java.util.List;

public class zzc {
    public static CharSequence zza(String str, List<AutocompletePredictionEntity.SubstringEntity> list, CharacterStyle characterStyle) {
        if (characterStyle == null) {
            return str;
        }
        SpannableString spannableString = new SpannableString(str);
        for (AutocompletePredictionEntity.SubstringEntity next : list) {
            spannableString.setSpan(CharacterStyle.wrap(characterStyle), next.getOffset(), next.getLength() + next.getOffset(), 0);
        }
        return spannableString;
    }

    public static String zzj(Collection<String> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        return zzv.zzcL(", ").zza(collection);
    }
}
