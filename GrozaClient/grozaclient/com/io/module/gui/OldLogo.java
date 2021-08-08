/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraftforge.client.event.RenderGameOverlayEvent
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$ElementType
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package grozaclient.com.io.module.gui;

import grozaclient.com.io.GrozaClient;
import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import java.awt.Color;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class OldLogo
extends Module {
    public OldLogo() {
        super("OldLogo", "", grozaclient.com.io.module.Category.Gui);
    }

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent event) {
        ScaledResolution sr = new ScaledResolution(Minecraft.func_71410_x());
        int y = 2;
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            for (Module mod : GrozaClient.moduleManager.getModuleList()) {
                if (mod.getName().equalsIgnoreCase("OldLogo") || !mod.isToggled() || !mod.visible) continue;
                FontRenderer fr = Minecraft.func_71410_x().field_71466_p;
                GlStateManager.func_179094_E();
                GlStateManager.func_179152_a((float)1.0f, (float)1.0f, (float)1.0f);
                Minecraft.func_71410_x().field_71466_p.func_175063_a("GrozaClient 1.5.1", 1.0f, 1.0f, this.rainbow(3330, 1, 1.0f, 0.5f));
                y += fr.field_78288_b;
                GlStateManager.func_179152_a((float)1.0f, (float)1.0f, (float)1.0f);
                GlStateManager.func_179121_F();
            }
        }
    }

    public int rainbow(int speed, int offset, float brightness, float saturation) {
        float hue = (System.currentTimeMillis() + (long)offset) % (long)speed;
        return Color.getHSBColor(hue /= (float)speed, saturation, brightness).getRGB();
    }
}

