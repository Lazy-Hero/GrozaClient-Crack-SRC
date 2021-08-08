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

public class PlayerESP
extends Module {
    public PlayerESP() {
        super("MinecraftESP", "", grozaclient.com.io.module.Category.Render);
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent e) {
        PlayerESP.mc.field_71441_e.field_72996_f.stream().filter(entity -> entity != PlayerESP.mc.field_71439_g && !entity.func_184202_aL()).forEach(entity -> entity.func_184195_f(true));
        super.onEnable();
    }

    @Override
    public void onDisable() {
        PlayerESP.mc.field_71441_e.field_72996_f.stream().filter(entity -> entity != PlayerESP.mc.field_71439_g && entity.func_184202_aL()).forEach(entity -> entity.func_184195_f(false));
        super.onDisable();
    }
}

