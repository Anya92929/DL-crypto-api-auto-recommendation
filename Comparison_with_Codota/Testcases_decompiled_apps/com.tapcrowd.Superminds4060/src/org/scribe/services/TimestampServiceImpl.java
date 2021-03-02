package org.scribe.services;

import java.util.Random;

public class TimestampServiceImpl implements TimestampService {
    private Timer timer = new Timer();

    public String getNonce() {
        return String.valueOf(getTs().longValue() + ((long) this.timer.getRandomInteger().intValue()));
    }

    public String getTimestampInSeconds() {
        return String.valueOf(getTs());
    }

    private Long getTs() {
        return Long.valueOf(this.timer.getMilis().longValue() / 1000);
    }

    /* access modifiers changed from: package-private */
    public void setTimer(Timer timer2) {
        this.timer = timer2;
    }

    static class Timer {
        Timer() {
        }

        /* access modifiers changed from: package-private */
        public Long getMilis() {
            return Long.valueOf(System.currentTimeMillis());
        }

        /* access modifiers changed from: package-private */
        public Integer getRandomInteger() {
            return Integer.valueOf(new Random().nextInt());
        }
    }
}
