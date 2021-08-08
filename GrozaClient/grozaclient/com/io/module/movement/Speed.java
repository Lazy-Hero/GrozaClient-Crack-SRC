/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package grozaclient.com.io.module.movement;

import grozaclient.com.io.GrozaClient;
import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import grozaclient.com.io.settings.Settinga;
import grozaclient.com.io.settings.Timer;
import java.lang.reflect.Field;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Speed
extends Module {
    public final Timer timer = new Timer(20.0f);

    public Speed() {
        super("Speed", "Speeeeeeeeeed", grozaclient.com.io.module.Category.Movement);
        GrozaClient.instance.settingsManager.rSetting(new Settinga("Speed", this, 3.0, 1.0, 6.0, false));
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent e) {
        float speed = (float)GrozaClient.instance.settingsManager.getSettingByName(this, "Speed").getValDouble();
        if (Speed.mc.field_71439_g == null) {
            this.setTimer(20.0f);
            return;
        }
        if (Speed.mc.field_71439_g.field_70122_E) {
            Speed.mc.field_71439_g.func_70664_aZ();
        } else {
            EntityPlayerSP player = Speed.mc.field_71439_g;
            player.field_70181_x -= 10.0;
        }
        this.setTimer(speed);
    }

    @Override
    public void onDisable() {
        this.setTimer(0.0f);
        super.onDisable();
    }

    public static boolean isNotObfuscated() {
        try {
            return Minecraft.class.getDeclaredField("instance") != null;
        }
        catch (Exception ex) {
            return false;
        }
    }

    public void setTimer(float timer) {
        try {
            Field field = mc.getClass().getDeclaredField(Speed.isNotObfuscated() ? "timer" : "timer");
            field.setAccessible(true);
            field.set((Object)mc, new Timer(timer == 0.0f ? 20.0f : timer * 20.0f));
        }
        catch (Exception exception) {
            // empty catch block
        }
    }
}

