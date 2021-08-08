/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.client.event.RenderBlockOverlayEvent
 *  net.minecraftforge.client.event.RenderBlockOverlayEvent$OverlayType
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package grozaclient.com.io.module.render;

import grozaclient.com.io.GrozaClient;
import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import grozaclient.com.io.settings.Settinga;
import net.minecraftforge.client.event.RenderBlockOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AntiFire
extends Module {
    public AntiFire() {
        super("AntiFire", "1", grozaclient.com.io.module.Category.Render);
        GrozaClient.instance.settingsManager.rSetting(new Settinga("Fire", this, true));
    }

    @SubscribeEvent
    public void onBlockOverlay(RenderBlockOverlayEvent event) {
        if (GrozaClient.instance.settingsManager.getSettingByName(this, "Fire").getValBoolean() && event.getOverlayType() == RenderBlockOverlayEvent.OverlayType.FIRE) {
            event.setCanceled(true);
        }
    }
}

