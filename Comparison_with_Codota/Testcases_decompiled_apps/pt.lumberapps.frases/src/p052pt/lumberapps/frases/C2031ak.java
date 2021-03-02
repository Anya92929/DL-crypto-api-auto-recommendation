package p052pt.lumberapps.frases;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* renamed from: pt.lumberapps.frases.ak */
public abstract class C2031ak implements View.OnTouchListener {

    /* renamed from: a */
    private final GestureDetector f7699a = new GestureDetector(new C2033am(this));

    /* renamed from: a */
    public abstract void mo10170a();

    /* renamed from: b */
    public abstract void mo10171b();

    /* renamed from: c */
    public abstract void mo10172c();

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f7699a.onTouchEvent(motionEvent);
    }
}
