/*
 * Decompiled with CFR 0.150.
 */
package grozaclient.com.io.module.combat;

import grozaclient.com.io.GrozaClient;
import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import grozaclient.com.io.settings.Settinga;

public class AntiBot
extends Module {
    public AntiBot() {
        super("AntiBot", "", grozaclient.com.io.module.Category.Rage);
        GrozaClient.instance.settingsManager.rSetting(new Settinga("Invisible Remove", this, true));
    }
}

