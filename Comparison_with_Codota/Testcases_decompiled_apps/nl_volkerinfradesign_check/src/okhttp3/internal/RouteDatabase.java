package okhttp3.internal;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.Route;

public final class RouteDatabase {

    /* renamed from: a */
    private final Set<Route> f6019a = new LinkedHashSet();

    public synchronized void failed(Route route) {
        this.f6019a.add(route);
    }

    public synchronized void connected(Route route) {
        this.f6019a.remove(route);
    }

    public synchronized boolean shouldPostpone(Route route) {
        return this.f6019a.contains(route);
    }

    public synchronized int failedRoutesCount() {
        return this.f6019a.size();
    }
}
