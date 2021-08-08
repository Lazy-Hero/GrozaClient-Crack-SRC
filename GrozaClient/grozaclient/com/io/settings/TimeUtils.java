/*
 * Decompiled with CFR 0.150.
 */
package grozaclient.com.io.settings;

public class TimeUtils {
    public long cock = -1L;
    private long lastMS = 0L;

    public TimeUtils() {
        this.reset();
    }

    private long getCurrentMS() {
        return System.nanoTime() / 1000000L;
    }

    public boolean hasReached(double milliseconds) {
        return (double)(this.getCurrentMS() - this.lastMS) >= milliseconds;
    }

    public boolean delay(float milliSec) {
        return (float)(this.getTime() - this.lastMS) >= milliSec;
    }

    public long getTime() {
        return System.nanoTime() / 1000000L;
    }

    public boolean check(double ms) {
        return (double)(System.currentTimeMillis() - this.cock) >= ms;
    }

    public void reset() {
        this.cock = System.currentTimeMillis();
    }
}

