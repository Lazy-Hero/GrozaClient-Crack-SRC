/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.event.entity.living.LivingEvent$LivingUpdateEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package grozaclient.com.io.module.combat;

import grozaclient.com.io.GrozaClient;
import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import grozaclient.com.io.settings.Settinga;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Velocity
extends Module {
    public Velocity() {
        super("Velocity", "", grozaclient.com.io.module.Category.Rage);
        GrozaClient.instance.settingsManager.rSetting(new Settinga("Horizontal", this, 90.0, 0.0, 100.0, true));
        GrozaClient.instance.settingsManager.rSetting(new Settinga("Vertical", this, 100.0, 0.0, 100.0, true));
    }

    @SubscribeEvent
    public void onLivingUpdate(LivingEvent.LivingUpdateEvent e) {
        float horizontal = (float)GrozaClient.instance.settingsManager.getSettingByName(this, "Horizontal").getValDouble();
        float vertical = (float)GrozaClient.instance.settingsManager.getSettingByName(this, "Vertical").getValDouble();
        if (Velocity.mc.field_71439_g.field_70737_aN == Velocity.mc.field_71439_g.field_70738_aO && Velocity.mc.field_71439_g.field_70738_aO > 0) {
            Velocity.mc.field_71439_g.field_70159_w *= (double)(horizontal / 100.0f);
            Velocity.mc.field_71439_g.field_70181_x *= (double)(vertical / 100.0f);
            Velocity.mc.field_71439_g.field_70179_y *= (double)(horizontal / 100.0f);
        }
    }
}

