/*
 * Decompiled with CFR 0.150.
 */
package grozaclient.com.io.module.misc;

import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;

public class FullBright
extends Module {
    public float oldGamma;

    public FullBright() {
        super("FullBright", "all bright", grozaclient.com.io.module.Category.Misc);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        this.oldGamma = FullBright.mc.field_71474_y.field_74333_Y;
        FullBright.mc.field_71474_y.field_74333_Y = 10.0f;
    }

    @Override
    public void onDisable() {
        super.onDisable();
        FullBright.mc.field_71474_y.field_74333_Y = this.oldGamma;
    }
}

