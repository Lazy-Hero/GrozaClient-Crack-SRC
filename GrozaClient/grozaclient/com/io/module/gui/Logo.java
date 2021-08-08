/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.renderer.BufferBuilder
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.client.renderer.GlStateManager$DestFactor
 *  net.minecraft.client.renderer.GlStateManager$SourceFactor
 *  net.minecraft.client.renderer.Tessellator
 *  net.minecraft.client.renderer.vertex.DefaultVertexFormats
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$Text
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package grozaclient.com.io.module.gui;

import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import java.awt.Color;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Logo
extends Module {
    public Logo() {
        super("Logo", "New Logo Groza", grozaclient.com.io.module.Category.Gui);
    }

    @Override
    public boolean onRenderWorldLast(float f) {
        return false;
    }

    @Override
    protected float currentFloatValue(String range) {
        return 0.0f;
    }

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Text e) {
        GlStateManager.func_179152_a((float)1.0f, (float)1.0f, (float)1.0f);
        String nurik = "GrozaClient 1.5.1 | " + Logo.mc.func_147104_D().field_78845_b.toLowerCase();
        this.drawRect(1.0, 4.5, 2 + Logo.mc.field_71466_p.func_78256_a(nurik) + 1, 5.5f + (float)Logo.mc.field_71466_p.field_78288_b + 1.0f, -1879048192);
        Logo.mc.field_71466_p.func_175063_a(nurik, 2.0f, 5.5f, 0xFFFFFF);
        GlStateManager.func_179152_a((float)1.0f, (float)1.0f, (float)1.0f);
        double posY = 0.0;
        double width = Logo.mc.field_71466_p.func_78256_a(nurik) + 2;
        this.drawGradientRect(1.0, posY + 3.0, 4.0 + width / 3.0, posY + 4.5, new Color(37, 250, 244, 255).getRGB(), new Color(54, 214, 243, 255).getRGB());
        this.drawGradientRect(1.0 + width / 3.0, posY + 3.0, 1.0 + width / 3.0 * 2.0, posY + 4.5, new Color(104, 213, 246, 255).getRGB(), new Color(15, 178, 203, 255).getRGB());
        this.drawGradientRect(1.0 + width / 3.0 * 2.0, posY + 3.0, width / 3.0 * 3.0 + 1.0, posY + 4.5, new Color(55, 211, 250, 255).getRGB(), new Color(58, 246, 180, 255).getRGB());
    }

    private void drawRect(double left, double top, double right, double bottom, int color) {
        if (left < right) {
            double i = left;
            left = right;
            right = i;
        }
        if (top < bottom) {
            double j = top;
            top = bottom;
            bottom = j;
        }
        float f3 = (float)(color >> 24 & 0xFF) / 255.0f;
        float f = (float)(color >> 16 & 0xFF) / 255.0f;
        float f1 = (float)(color >> 8 & 0xFF) / 255.0f;
        float f2 = (float)(color & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.func_178181_a();
        BufferBuilder bufferbuilder = tessellator.func_178180_c();
        GlStateManager.func_179147_l();
        GlStateManager.func_179090_x();
        GlStateManager.func_187428_a((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.func_179131_c((float)f, (float)f1, (float)f2, (float)f3);
        bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181705_e);
        bufferbuilder.func_181662_b(left, bottom, 0.0).func_181675_d();
        bufferbuilder.func_181662_b(right, bottom, 0.0).func_181675_d();
        bufferbuilder.func_181662_b(right, top, 0.0).func_181675_d();
        bufferbuilder.func_181662_b(left, top, 0.0).func_181675_d();
        tessellator.func_78381_a();
        GlStateManager.func_179098_w();
        GlStateManager.func_179084_k();
    }

    public void drawGradientRect(double left, double top, double right, double bottom, int startColor, int endColor) {
        float f = (float)(startColor >> 24 & 0xFF) / 255.0f;
        float f1 = (float)(startColor >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(startColor >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(startColor & 0xFF) / 255.0f;
        float f4 = (float)(endColor >> 24 & 0xFF) / 255.0f;
        float f5 = (float)(endColor >> 16 & 0xFF) / 255.0f;
        float f6 = (float)(endColor >> 8 & 0xFF) / 255.0f;
        float f7 = (float)(endColor & 0xFF) / 255.0f;
        GlStateManager.func_179090_x();
        GlStateManager.func_179147_l();
        GlStateManager.func_179118_c();
        GlStateManager.func_187428_a((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.func_179103_j((int)7425);
        Tessellator tessellator = Tessellator.func_178181_a();
        BufferBuilder bufferbuilder = tessellator.func_178180_c();
        bufferbuilder.func_181668_a(7, DefaultVertexFormats.field_181706_f);
        bufferbuilder.func_181662_b(right, top, 1.0).func_181666_a(f5, f6, f7, f4).func_181675_d();
        bufferbuilder.func_181662_b(left, top, 1.0).func_181666_a(f1, f2, f3, f).func_181675_d();
        bufferbuilder.func_181662_b(left, bottom, 1.0).func_181666_a(f1, f2, f3, f).func_181675_d();
        bufferbuilder.func_181662_b(right, bottom, 1.0).func_181666_a(f5, f6, f7, f4).func_181675_d();
        tessellator.func_78381_a();
        GlStateManager.func_179103_j((int)7424);
        GlStateManager.func_179084_k();
        GlStateManager.func_179141_d();
        GlStateManager.func_179098_w();
    }
}

