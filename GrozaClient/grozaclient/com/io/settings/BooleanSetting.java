/*
 * Decompiled with CFR 0.150.
 */
package grozaclient.com.io.settings;

import grozaclient.com.io.settings.Settinga;

public class BooleanSetting
extends Settinga {
    public boolean enabled;

    public BooleanSetting(String string, boolean bl) {
        this.name = string;
        this.enabled = bl;
    }

    public void toggle() {
        this.enabled = !this.enabled;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean bl) {
        this.enabled = bl;
    }
}

