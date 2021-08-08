/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.settings.KeyBinding
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package grozaclient.com.io.module.movement;

import grozaclient.com.io.GrozaClient;
import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import grozaclient.com.io.settings.Settinga;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Sprint
extends Module {
    public Sprint() {
        super("Sprint", "i like sprinting", grozaclient.com.io.module.Category.Movement);
        GrozaClient.instance.settingsManager.rSetting(new Settinga("KeepSprint", this, true));
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent e) {
        KeyBinding.func_74510_a((int)Sprint.mc.field_71474_y.field_151444_V.func_151463_i(), (boolean)true);
    }

    @Override
    public void onDisable() {
        super.onDisable();
        KeyBinding.func_74510_a((int)Sprint.mc.field_71474_y.field_151444_V.func_151463_i(), (boolean)false);
    }
}

