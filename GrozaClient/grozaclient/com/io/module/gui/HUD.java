/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.Gui
 *  net.minecraft.client.gui.GuiChat
 *  net.minecraft.client.gui.ScaledResolution
 *  net.minecraftforge.client.event.RenderGameOverlayEvent
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$ElementType
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$RenderTickEvent
 *  org.lwjgl.opengl.GL11
 */
package grozaclient.com.io.module.gui;

import grozaclient.com.io.GrozaClient;
import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import java.awt.Color;
import java.util.Collections;
import java.util.Comparator;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiChat;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.opengl.GL11;

public class HUD
extends Module {
    public FontRenderer fr;
    private int y;

    public HUD() {
        super("HUD", "modules on screen", grozaclient.com.io.module.Category.Gui);
        this.fr = Minecraft.func_71410_x().field_71466_p;
    }

    @SubscribeEvent
    public void onUpdate(TickEvent.RenderTickEvent event) {
        Collections.sort(GrozaClient.moduleManager.getModuleList(), new ModuleComparator());
        ScaledResolution sr = new ScaledResolution(mc);
        ScaledResolution scaledResolution = new ScaledResolution(mc);
        int count = 2;
        if (HUD.mc.field_71439_g == null && HUD.mc.field_71441_e == null) {
            return;
        }
        if (HUD.mc.field_71462_r == null || HUD.mc.field_71462_r instanceof GuiChat) {
            String drawFPS = String.valueOf(Minecraft.func_175610_ah());
            GrozaClient.moduleManager.getModuleList().sort(Comparator.comparingInt(m -> Minecraft.func_71410_x().field_71466_p.func_78256_a(((Module)m).getName())).reversed());
            GL11.glPushMatrix();
            GL11.glScaled((double)2.0, (double)2.0, (double)2.0);
            int[] counter = new int[]{1};
            GL11.glPopMatrix();
            this.renderArrayList(sr);
        }
    }

    public Color getGradientOffset(Color color1, Color color2, double offset) {
        if (offset > 1.0) {
            double left = offset % 1.0;
            int off = (int)offset;
            offset = off % 2 == 0 ? left : 1.0 - left;
        }
        double inverse_percent = 1.0 - offset;
        int redPart = (int)((double)color1.getRed() * inverse_percent + (double)color2.getRed() * offset);
        int greenPart = (int)((double)color1.getGreen() * inverse_percent + (double)color2.getGreen() * offset);
        int bluePart = (int)((double)color1.getBlue() * inverse_percent + (double)color2.getBlue() * offset);
        return new Color(redPart, greenPart, bluePart);
    }

    private void renderArrayList(ScaledResolution sr) {
        Collections.sort(GrozaClient.moduleManager.modules, new ModuleComparator());
        int count = 0;
        int[] counter = new int[]{1};
        for (Module m : GrozaClient.moduleManager.getModuleList()) {
            if (!m.isToggled() || m.getName().equalsIgnoreCase("HUD") || !m.visible) continue;
            int offset = count * (this.fr.field_78288_b + 5);
            Gui.func_73734_a((int)(sr.func_78326_a() - this.fr.func_78256_a(m.getName()) - 10), (int)offset, (int)(sr.func_78326_a() - this.fr.func_78256_a(m.getName()) - 10), (int)this.fr.field_78288_b, (int)Color.black.getRGB());
            Gui.func_73734_a((int)(sr.func_78326_a() - this.fr.func_78256_a(m.getName()) - 6), (int)offset, (int)sr.func_78326_a(), (int)(12 + offset + 2), (int)new Color(-1728053248, true).hashCode());
            Gui.func_73734_a((int)(sr.func_78326_a() - 2), (int)offset, (int)sr.func_78326_a(), (int)(offset + 15), (int)this.getGradientOffset(new Color(107, 220, 248), new Color(6, 239, 64, 255), (double)Math.abs(System.currentTimeMillis() / 10L) / 100.0).getRGB());
            boolean n = false;
            counter[0] = counter[0] + 1;
            this.fr.func_78276_b(m.getName(), sr.func_78326_a() - this.fr.func_78256_a(m.getName()) - 4, 4 + offset, -1);
            ++count;
        }
    }

    @SubscribeEvent
    public void onRenderOverlay(RenderGameOverlayEvent event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.POTION_ICONS) {
            event.setCanceled(true);
        }
    }

    public static int rainbow1(int delay) {
        double rainbowState = Math.ceil((System.currentTimeMillis() + (long)delay) / 20L);
        return Color.getHSBColor((float)((rainbowState %= 360.0) / 360.0), 1.0f, 1.0f).getRGB();
    }

    public static class ModuleComparator
    implements Comparator<Module> {
        @Override
        public int compare(Module arg0, Module arg1) {
            if (Minecraft.func_71410_x().field_71466_p.func_78256_a(arg0.getName()) > Minecraft.func_71410_x().field_71466_p.func_78256_a(arg1.getName())) {
                return -1;
            }
            if (Minecraft.func_71410_x().field_71466_p.func_78256_a(arg0.getName()) > Minecraft.func_71410_x().field_71466_p.func_78256_a(arg1.getName())) {
                return 1;
            }
            return 0;
        }
    }
}

