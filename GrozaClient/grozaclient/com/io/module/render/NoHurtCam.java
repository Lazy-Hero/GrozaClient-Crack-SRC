/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package grozaclient.com.io.module.render;

import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class NoHurtCam
extends Module {
    public NoHurtCam() {
        super("NoHurtCam", "", grozaclient.com.io.module.Category.Render);
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent playerTickEvent) {
        NoHurtCam.mc.field_71439_g.field_70737_aN = 0;
        NoHurtCam.mc.field_71439_g.field_70172_ad = 0;
        NoHurtCam.mc.field_71439_g.field_70771_an = 0;
        NoHurtCam.mc.field_71439_g.field_70738_aO = 0;
    }
}

