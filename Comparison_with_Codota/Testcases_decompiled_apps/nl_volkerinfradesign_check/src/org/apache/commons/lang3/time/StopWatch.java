package org.apache.commons.lang3.time;

public class StopWatch {

    /* renamed from: a */
    private int f7258a = 0;

    /* renamed from: b */
    private int f7259b = 10;

    /* renamed from: c */
    private long f7260c;

    /* renamed from: d */
    private long f7261d;

    /* renamed from: e */
    private long f7262e;

    public void start() {
        if (this.f7258a == 2) {
            throw new IllegalStateException("Stopwatch must be reset before being restarted. ");
        } else if (this.f7258a != 0) {
            throw new IllegalStateException("Stopwatch already started. ");
        } else {
            this.f7260c = System.nanoTime();
            this.f7261d = System.currentTimeMillis();
            this.f7258a = 1;
        }
    }

    public void stop() {
        if (this.f7258a == 1 || this.f7258a == 3) {
            if (this.f7258a == 1) {
                this.f7262e = System.nanoTime();
            }
            this.f7258a = 2;
            return;
        }
        throw new IllegalStateException("Stopwatch is not running. ");
    }

    public void reset() {
        this.f7258a = 0;
        this.f7259b = 10;
    }

    public void split() {
        if (this.f7258a != 1) {
            throw new IllegalStateException("Stopwatch is not running. ");
        }
        this.f7262e = System.nanoTime();
        this.f7259b = 11;
    }

    public void unsplit() {
        if (this.f7259b != 11) {
            throw new IllegalStateException("Stopwatch has not been split. ");
        }
        this.f7259b = 10;
    }

    public void suspend() {
        if (this.f7258a != 1) {
            throw new IllegalStateException("Stopwatch must be running to suspend. ");
        }
        this.f7262e = System.nanoTime();
        this.f7258a = 3;
    }

    public void resume() {
        if (this.f7258a != 3) {
            throw new IllegalStateException("Stopwatch must be suspended to resume. ");
        }
        this.f7260c += System.nanoTime() - this.f7262e;
        this.f7258a = 1;
    }

    public long getTime() {
        return getNanoTime() / 1000000;
    }

    public long getNanoTime() {
        if (this.f7258a == 2 || this.f7258a == 3) {
            return this.f7262e - this.f7260c;
        }
        if (this.f7258a == 0) {
            return 0;
        }
        if (this.f7258a == 1) {
            return System.nanoTime() - this.f7260c;
        }
        throw new RuntimeException("Illegal running state has occured. ");
    }

    public long getSplitTime() {
        return getSplitNanoTime() / 1000000;
    }

    public long getSplitNanoTime() {
        if (this.f7259b == 11) {
            return this.f7262e - this.f7260c;
        }
        throw new IllegalStateException("Stopwatch must be split to get the split time. ");
    }

    public long getStartTime() {
        if (this.f7258a != 0) {
            return this.f7261d;
        }
        throw new IllegalStateException("Stopwatch has not been started");
    }

    public String toString() {
        return DurationFormatUtils.formatDurationHMS(getTime());
    }

    public String toSplitString() {
        return DurationFormatUtils.formatDurationHMS(getSplitTime());
    }
}
