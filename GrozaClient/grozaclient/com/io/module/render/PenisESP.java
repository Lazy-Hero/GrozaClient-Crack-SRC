/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.RenderHelper
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.opengl.GL11
 *  org.lwjgl.util.glu.Cylinder
 *  org.lwjgl.util.glu.Sphere
 */
package grozaclient.com.io.module.render;

import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Cylinder;
import org.lwjgl.util.glu.Sphere;

public class PenisESP
extends Module {
    Minecraft mc = Minecraft.func_71410_x();

    public PenisESP() {
        super("PenisEsp", "", grozaclient.com.io.module.Category.Render);
    }

    @SubscribeEvent
    public void onRenderWorldLast(RenderWorldLastEvent event) {
        for (Object o : this.mc.field_71441_e.field_72996_f) {
            if (!(o instanceof EntityPlayer)) continue;
            EntityPlayer player = (EntityPlayer)o;
            double n = player.field_70142_S + (player.field_70165_t - player.field_70142_S) * (double)event.getPartialTicks();
            this.mc.func_175598_ae();
            double x = n - this.mc.func_175598_ae().field_78730_l;
            double n2 = player.field_70137_T + (player.field_70163_u - player.field_70137_T) * (double)event.getPartialTicks();
            this.mc.func_175598_ae();
            double y = n2 - this.mc.func_175598_ae().field_78731_m;
            double n3 = player.field_70136_U + (player.field_70161_v - player.field_70136_U) * (double)event.getPartialTicks();
            this.mc.func_175598_ae();
            double z = n3 - this.mc.func_175598_ae().field_78728_n;
            GL11.glPushMatrix();
            RenderHelper.func_74518_a();
            this.esp(player, x, y, z);
            RenderHelper.func_74519_b();
            GL11.glPopMatrix();
        }
    }

    public void esp(EntityPlayer player, double x, double y, double z) {
        GL11.glDisable((int)2896);
        GL11.glDisable((int)3553);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDisable((int)2929);
        GL11.glEnable((int)2848);
        GL11.glDepthMask((boolean)true);
        GL11.glLineWidth((float)3.0f);
        GL11.glTranslated((double)x, (double)y, (double)z);
        GL11.glRotatef((float)(-player.field_70759_as), (float)0.0f, (float)player.field_70131_O, (float)0.0f);
        GL11.glTranslated((double)(-x), (double)(-y), (double)(-z));
        GL11.glTranslated((double)x, (double)(y + (double)(player.field_70131_O / 2.0f) - (double)0.225f), (double)z);
        GL11.glColor4f((float)1.38f, (float)0.55f, (float)2.38f, (float)1.0f);
        GL11.glRotatef((float)((player.func_70093_af() ? 35 : -35) + 1), (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glTranslated((double)0.0, (double)0.0, (double)0.075f);
        Cylinder shaft = new Cylinder();
        shaft.setDrawStyle(100013);
        shaft.draw(0.1f, 0.119f, 0.5f, 25, 20);
        GL11.glColor4f((float)1.38f, (float)0.85f, (float)1.38f, (float)1.0f);
        GL11.glTranslated((double)0.0, (double)0.0, (double)-0.12500000298023223);
        GL11.glTranslated((double)-0.09000000074505805, (double)0.0, (double)0.0);
        Sphere right = new Sphere();
        right.setDrawStyle(100013);
        right.draw(0.14f, 10, 20);
        GL11.glTranslated((double)0.16000000149011612, (double)0.0, (double)0.0);
        Sphere left = new Sphere();
        left.setDrawStyle(100013);
        left.draw(0.14f, 10, 20);
        GL11.glColor4f((float)1.35f, (float)0.0f, (float)0.0f, (float)1.0f);
        GL11.glTranslated((double)-0.07000000074505806, (double)0.0, (double)0.589999952316284);
        Sphere tip = new Sphere();
        tip.setDrawStyle(100013);
        tip.draw(0.13f, 15, 20);
        GL11.glDepthMask((boolean)true);
        GL11.glDisable((int)2848);
        GL11.glEnable((int)2929);
        GL11.glDisable((int)3042);
        GL11.glEnable((int)2896);
        GL11.glEnable((int)3553);
    }
}

