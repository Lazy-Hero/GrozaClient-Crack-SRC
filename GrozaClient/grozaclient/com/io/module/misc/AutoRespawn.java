/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiGameOver
 */
package grozaclient.com.io.module.misc;

import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import net.minecraft.client.gui.GuiGameOver;

public class AutoRespawn
extends Module {
    public AutoRespawn() {
        super("AutoRespawn", "", grozaclient.com.io.module.Category.Misc);
    }

    @Override
    public void perUpdate() {
        if (AutoRespawn.mc.field_71462_r instanceof GuiGameOver) {
            AutoRespawn.mc.field_71439_g.func_71004_bE();
            mc.func_147108_a(null);
        }
        super.perUpdate();
    }
}

