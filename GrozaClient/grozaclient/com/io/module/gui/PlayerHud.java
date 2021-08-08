/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.OpenGlHelper
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.client.renderer.entity.RenderManager
 *  net.minecraft.entity.Entity
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$Text
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package grozaclient.com.io.module.gui;

import grozaclient.com.io.GrozaClient;
import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import grozaclient.com.io.settings.Settinga;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PlayerHud
extends Module {
    public PlayerHud() {
        super("PlayerModel", "", grozaclient.com.io.module.Category.Gui);
        GrozaClient.instance.settingsManager.rSetting(new Settinga("PosX", this, 10.0, -10.0, 1000.0, true));
        GrozaClient.instance.settingsManager.rSetting(new Settinga("PosY", this, 80.0, -10.0, 1000.0, true));
    }

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Text e) {
        EntityPlayerSP ent = PlayerHud.mc.field_71439_g;
        GlStateManager.func_179094_E();
        GlStateManager.func_179124_c((float)1.0f, (float)1.0f, (float)1.0f);
        RenderHelper.func_74519_b();
        GlStateManager.func_179141_d();
        GlStateManager.func_179103_j((int)7424);
        GlStateManager.func_179141_d();
        GlStateManager.func_179126_j();
        GlStateManager.func_179114_b((float)0.0f, (float)0.0f, (float)5.0f, (float)0.0f);
        GlStateManager.func_179142_g();
        GlStateManager.func_179094_E();
        GlStateManager.func_179109_b((float)((float)(GrozaClient.instance.settingsManager.getSettingByName(this, "PosX").getValDouble() + 25.0)), (float)((float)(GrozaClient.instance.settingsManager.getSettingByName(this, "PosY").getValDouble() + 25.0)), (float)50.0f);
        GlStateManager.func_179152_a((float)-35.0f, (float)35.0f, (float)35.0f);
        GlStateManager.func_179114_b((float)180.0f, (float)0.0f, (float)0.0f, (float)1.0f);
        GlStateManager.func_179114_b((float)135.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        RenderHelper.func_74519_b();
        GlStateManager.func_179114_b((float)-135.0f, (float)0.0f, (float)1.0f, (float)0.0f);
        GlStateManager.func_179114_b((float)(-((float)Math.atan((float)GrozaClient.instance.settingsManager.getSettingByName(this, "PosY").getValDouble() / 40.0f)) * 20.0f), (float)1.0f, (float)0.0f, (float)0.0f);
        GlStateManager.func_179109_b((float)0.0f, (float)0.0f, (float)0.0f);
        RenderManager rendermanager = mc.func_175598_ae();
        rendermanager.func_178631_a(180.0f);
        rendermanager.func_178633_a(false);
        try {
            rendermanager.func_188391_a((Entity)ent, 0.0, 0.0, 0.0, 0.0f, 1.0f, false);
        }
        catch (Exception exception) {
            // empty catch block
        }
        rendermanager.func_178633_a(true);
        GlStateManager.func_179121_F();
        RenderHelper.func_74518_a();
        GlStateManager.func_179101_C();
        GlStateManager.func_179138_g((int)OpenGlHelper.field_77476_b);
        GlStateManager.func_179090_x();
        GlStateManager.func_179138_g((int)OpenGlHelper.field_77478_a);
        GlStateManager.func_179143_c((int)515);
        GlStateManager.func_179117_G();
        GlStateManager.func_179097_i();
        GlStateManager.func_179121_F();
    }
}

