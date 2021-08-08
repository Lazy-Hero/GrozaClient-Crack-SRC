/*
 * Decompiled with CFR 0.150.
 */
package grozaclient.com.io.settings;

import grozaclient.com.io.module.Module;
import grozaclient.com.io.settings.Settinga;
import java.util.ArrayList;

public class SettingsManager {
    private ArrayList<Settinga> settingas = new ArrayList();

    public void rSetting(Settinga in) {
        this.settingas.add(in);
    }

    public ArrayList<Settinga> getSettings() {
        return this.settingas;
    }

    public ArrayList<Settinga> getSettingsByMod(Module mod) {
        ArrayList<Settinga> out = new ArrayList<Settinga>();
        for (Settinga s : this.getSettings()) {
            if (!s.getParentMod().equals(mod)) continue;
            out.add(s);
        }
        if (out.isEmpty()) {
            return null;
        }
        return out;
    }

    public Settinga getSettingByName(Module mod, String name) {
        for (Settinga set : this.getSettings()) {
            if (!set.getName().equalsIgnoreCase(name) || set.getParentMod() != mod) continue;
            return set;
        }
        System.err.println("[Tutorial] Error Setting NOT found: '" + name + "'!");
        return null;
    }
}

