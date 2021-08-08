/*
 * Decompiled with CFR 0.150.
 */
package grozaclient.com.io.module.render;

import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import grozaclient.com.io.settings.BooleanValue;

public class NoRender
extends Module {
    private BooleanValue pumpkin = new BooleanValue("Pumpkin", "NoRenderPumpkin", this, true);
    private BooleanValue fire = new BooleanValue("Fire", "NoRenderFire", this, true);
    private BooleanValue portal = new BooleanValue("Portal", "NoRenderPortal", this, true);

    public NoRender() {
        super("ItemESP", "", grozaclient.com.io.module.Category.Render);
    }
}

