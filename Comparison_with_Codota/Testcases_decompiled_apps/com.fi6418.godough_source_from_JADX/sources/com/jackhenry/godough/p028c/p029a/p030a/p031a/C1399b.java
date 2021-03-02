package com.jackhenry.godough.p028c.p029a.p030a.p031a;

import com.google.p008a.C0353ab;
import com.google.p008a.C0354ac;
import com.google.p008a.C0355ad;
import com.google.p008a.C0491u;
import com.google.p008a.C0492v;
import com.google.p008a.C0493w;
import com.jackhenry.godough.core.model.Settings;
import java.lang.reflect.Type;

/* renamed from: com.jackhenry.godough.c.a.a.a.b */
public class C1399b implements C0355ad<Settings.Texture>, C0492v<Settings.Texture> {
    /* renamed from: a */
    public C0493w mo6285a(Settings.Texture texture, Type type, C0354ac acVar) {
        return new C0353ab(texture.name());
    }

    /* renamed from: a */
    public Settings.Texture mo6288b(C0493w wVar, Type type, C0491u uVar) {
        try {
            return Settings.Texture.values()[wVar.mo6301e()];
        } catch (Exception e) {
            return Settings.Texture.TRANSPARENT;
        }
    }
}
