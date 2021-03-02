package cmn;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/* renamed from: cmn.ax */
final class C0729ax extends FutureTask {

    /* renamed from: a */
    final /* synthetic */ C0726au f1806a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C0729ax(C0726au auVar, Callable callable) {
        super(callable);
        this.f1806a = auVar;
    }

    /* access modifiers changed from: protected */
    public final void done() {
        try {
            C0726au.m3240b(this.f1806a, get());
        } catch (InterruptedException e) {
        } catch (ExecutionException e2) {
            throw new RuntimeException("An error occurred while executing doInBackground()", e2.getCause());
        } catch (CancellationException e3) {
            C0726au.m3240b(this.f1806a, (Object) null);
        }
    }
}
