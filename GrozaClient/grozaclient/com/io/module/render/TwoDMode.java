/*
 * Decompiled with CFR 0.150.
 */
package grozaclient.com.io.module.render;

import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;

public class TwoDMode
extends Module {
    public TwoDMode() {
        super("TwoDMode", "", grozaclient.com.io.module.Category.Render);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        TwoDMode.mc.field_71474_y.field_74325_U = true;
    }

    @Override
    public void onDisable() {
        super.onDisable();
        TwoDMode.mc.field_71474_y.field_74325_U = false;
    }
}

