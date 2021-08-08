/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.util.math.MathHelper
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package grozaclient.com.io.module.movement;

import grozaclient.com.io.GrozaClient;
import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import grozaclient.com.io.settings.Settinga;
import grozaclient.com.io.settings.Wrapper;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Fly
extends Module {
    public Fly() {
        super("Fly", "", grozaclient.com.io.module.Category.Movement);
        GrozaClient.instance.settingsManager.rSetting(new Settinga("Speed", this, 1.0, -5.0, 10.0, true));
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent playerTickEvent) {
        EntityPlayerSP player = Wrapper.player();
        if (player.field_70122_E) {
            player.func_70664_aZ();
        }
        if (!player.field_70122_E && player.field_70143_R != 0.0f) {
            float f = Fly.mc.field_71439_g.field_70177_z * ((float)Math.PI / 180);
            Fly.mc.field_71439_g.field_70159_w = (double)(-MathHelper.func_76126_a((float)f)) * GrozaClient.instance.settingsManager.getSettingByName(this, "Speed").getValDouble();
            Fly.mc.field_71439_g.field_70179_y = (double)MathHelper.func_76134_b((float)f) * GrozaClient.instance.settingsManager.getSettingByName(this, "Speed").getValDouble();
            Fly.mc.field_71439_g.field_70181_x = -0.02;
            Fly.mc.field_71439_g.field_70122_E = false;
        }
    }
}

