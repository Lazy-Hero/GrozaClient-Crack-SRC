/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package grozaclient.com.io.module.misc;

import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class NoPush
extends Module {
    public NoPush() {
        super("NoPush", "", grozaclient.com.io.module.Category.Misc);
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent e) {
        NoPush.mc.field_71439_g.field_70144_Y = 1.0f;
    }

    @Override
    public void onDisable() {
        NoPush.mc.field_71439_g.field_70144_Y = 0.0f;
        super.onDisable();
    }
}

