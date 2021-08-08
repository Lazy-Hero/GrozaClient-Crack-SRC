/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.client.event.EntityViewRenderEvent$FOVModifier
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package grozaclient.com.io.module.render;

import grozaclient.com.io.GrozaClient;
import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import grozaclient.com.io.settings.Settinga;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ViewModel
extends Module {
    public ViewModel() {
        super("ViewModel", "", grozaclient.com.io.module.Category.Render);
        GrozaClient.instance.settingsManager.rSetting(new Settinga("Fov", this, 100.0, 90.0, 160.0, true));
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (ViewModel.mc.field_71441_e == null) {
            return;
        }
    }

    @SubscribeEvent
    public void FOVEvent(EntityViewRenderEvent.FOVModifier event) {
        event.setFOV((float)GrozaClient.instance.settingsManager.getSettingByName(this, "Fov").getValDouble());
    }
}

