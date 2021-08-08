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
import java.util.Random;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AntiAim
extends Module {
    private final Random e = new Random();

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent playerTickEvent) {
        float f = this.e.nextFloat() * 360.0f;
        float cfr_ignored_0 = this.e.nextFloat() * 60.0f - 30.0f;
        AntiAim.mc.field_71439_g.field_70759_as = f;
        AntiAim.mc.field_71439_g.field_70761_aq = f;
    }

    public AntiAim() {
        super("AntiAim", "", grozaclient.com.io.module.Category.Misc);
    }
}

