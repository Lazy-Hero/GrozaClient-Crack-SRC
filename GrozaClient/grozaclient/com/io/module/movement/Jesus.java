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

public class Jesus
extends Module {
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent playerTickEvent) {
        if ((Jesus.mc.field_71439_g.func_70090_H() || Jesus.mc.field_71439_g.func_180799_ab()) && Jesus.mc.field_71439_g.field_70181_x < 1.0) {
            Jesus.mc.field_71439_g.func_70664_aZ();
        }
    }

    public Jesus() {
        super("Jesus", "walk on water", grozaclient.com.io.module.Category.Movement);
    }
}

