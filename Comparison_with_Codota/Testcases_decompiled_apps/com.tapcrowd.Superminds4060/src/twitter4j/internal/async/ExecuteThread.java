package twitter4j.internal.async;

import twitter4j.internal.logging.Logger;

/* compiled from: DispatcherImpl */
class ExecuteThread extends Thread {
    private static Logger logger = Logger.getLogger(ExecuteThread.class);
    private boolean alive = true;

    /* renamed from: q */
    DispatcherImpl f2158q;

    ExecuteThread(String name, DispatcherImpl q, int index) {
        super(name + "[" + index + "]");
        this.f2158q = q;
    }

    public void shutdown() {
        this.alive = false;
    }

    public void run() {
        while (this.alive) {
            Runnable task = this.f2158q.poll();
            if (task != null) {
                try {
                    task.run();
                } catch (Exception ex) {
                    logger.error("Got an exception while running a task:", ex);
                }
            }
        }
    }
}
