/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package grozaclient.com.io.module.movement;

import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class WaterJump
extends Module {
    public WaterJump() {
        super("WaterJump", "", grozaclient.com.io.module.Category.Movement);
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent e) {
        if (WaterJump.mc.field_71439_g.func_70090_H()) {
            WaterJump.mc.field_71439_g.field_70181_x = 9.0;
        }
    }
}

