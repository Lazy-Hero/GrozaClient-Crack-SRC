/*
 * Decompiled with CFR 0.150.
 */
package grozaclient.com.io.settings;

public class SpamerUtil {
    private long previousMS = 0L;

    public void reset() {
        this.previousMS = this.getTime();
    }

    public boolean hasReached(double d) {
        return (double)(this.getTime() - this.previousMS) >= d;
    }

    public long getTime() {
        return System.nanoTime() / 1000000L;
    }
}

