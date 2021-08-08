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
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.monster.EntityMob
 *  net.minecraft.entity.passive.EntityAnimal
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.opengl.GL11
 */
package grozaclient.com.io.module.render;

import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import grozaclient.com.io.settings.BooleanSetting;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class Esp
extends Module {
    public BooleanSetting invisibleSet;
    private transient int BOX = 0;
    public BooleanSetting animalSet;
    private transient ArrayList ENTITIES = new ArrayList();
    public BooleanSetting mobSet = new BooleanSetting("Mobs", false);
    public BooleanSetting playerSet;

    private void a(Entity entity, double d, double d2, double d3) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)d), (float)((float)d2), (float)((float)d3));
        GL11.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)(-Esp.mc.func_175598_ae().field_78735_i), (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)Esp.mc.func_175598_ae().field_78732_j, (float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        GL11.glLineWidth((float)2.0f);
        GL11.glDisable((int)2896);
        GL11.glDisable((int)2929);
        Tessellator tessellator = Tessellator.func_178181_a();
        tessellator.func_178180_c();
        if (((EntityLivingBase)entity).func_110143_aJ() <= 20.0f) {
            Esp.drawRect(-0.7f, ((EntityLivingBase)entity).func_110143_aJ() / 10.0f, -0.58f, 0.0f, new Color(65, 186, 13, 255).getRGB());
            Esp.drawRect(-0.71f, 2.01f, -0.58f, 2.0f, new Color(46, 245, 211, 255).getRGB());
            Esp.drawRect(-0.71f, 2.01f, -0.7f, 0.01f, new Color(80, 255, 224, 255).getRGB());
            Esp.drawRect(-0.59f, 0.01f, -0.58f, 2.0f, new Color(60, 255, 216, 255).getRGB());
            Esp.drawRect(-0.58f, 0.01f, -0.71f, 0.0f, new Color(68, 248, 210, 255).getRGB());
            Esp.a(-0.5, 2.0, 0.5, 0.0, 2.5f, new Color(77, 252, 237, 255).getRGB(), new Color(81, 248, 176, 255).getRGB());
        }
        GL11.glDisable((int)3042);
        GL11.glPopMatrix();
        GL11.glEnable((int)2929);
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glDisable((int)2848);
    }

    @SubscribeEvent
    public void onRenderWorldLast(RenderWorldLastEvent event) {
        if (Esp.mc.field_71439_g == null || Esp.mc.field_71439_g.field_70128_L) {
            return;
        }
        List list = Esp.mc.field_71441_e.field_72996_f.stream().filter(entity -> entity != Esp.mc.field_71439_g).filter(entity -> !entity.field_70128_L).sorted(Comparator.comparing(entity -> Float.valueOf(Esp.mc.field_71439_g.func_70032_d(entity)))).collect(Collectors.toList());
        for (Object entity2w : list) {
            double d5;
            double d4;
            double d3;
            Entity entity2 = (Entity)entity2w;
            if (entity2 == null || entity2 == Esp.mc.field_71439_g) continue;
            if (this.invisibleSet.isEnabled() && entity2.func_82150_aj() && (entity2 instanceof EntityPlayer && this.playerSet.isEnabled() || entity2 instanceof EntityMob && this.mobSet.isEnabled() || entity2 instanceof EntityAnimal && this.animalSet.isEnabled())) {
                d3 = entity2.field_70142_S + (entity2.field_70165_t - entity2.field_70142_S) - Esp.mc.func_175598_ae().field_78730_l;
                d4 = entity2.field_70137_T + (entity2.field_70163_u - entity2.field_70137_T) - Esp.mc.func_175598_ae().field_78731_m;
                d5 = entity2.field_70136_U + (entity2.field_70161_v - entity2.field_70136_U) - Esp.mc.func_175598_ae().field_78728_n;
                this.a(entity2, d3, d4, d5);
                this.ab(entity2, d3, d4, d5);
                continue;
            }
            if (this.mobSet.isEnabled() && entity2 instanceof EntityMob) {
                d3 = entity2.field_70142_S + (entity2.field_70165_t - entity2.field_70142_S) - Esp.mc.func_175598_ae().field_78730_l;
                d4 = entity2.field_70137_T + (entity2.field_70163_u - entity2.field_70137_T) - Esp.mc.func_175598_ae().field_78731_m;
                d5 = entity2.field_70136_U + (entity2.field_70161_v - entity2.field_70136_U) - Esp.mc.func_175598_ae().field_78728_n;
                this.a(entity2, d3, d4, d5);
                this.ab(entity2, d3, d4, d5);
                continue;
            }
            if (this.animalSet.isEnabled() && entity2 instanceof EntityAnimal) {
                d3 = entity2.field_70142_S + (entity2.field_70165_t - entity2.field_70142_S) - Esp.mc.func_175598_ae().field_78730_l;
                d4 = entity2.field_70137_T + (entity2.field_70163_u - entity2.field_70137_T) - Esp.mc.func_175598_ae().field_78731_m;
                d5 = entity2.field_70136_U + (entity2.field_70161_v - entity2.field_70136_U) - Esp.mc.func_175598_ae().field_78728_n;
                this.a(entity2, d3, d4, d5);
                this.ab(entity2, d3, d4, d5);
                continue;
            }
            if (!this.playerSet.isEnabled() || !(entity2 instanceof EntityPlayer)) continue;
            d3 = entity2.field_70142_S + (entity2.field_70165_t - entity2.field_70142_S) - Esp.mc.func_175598_ae().field_78730_l;
            d4 = entity2.field_70137_T + (entity2.field_70163_u - entity2.field_70137_T) - Esp.mc.func_175598_ae().field_78731_m;
            d5 = entity2.field_70136_U + (entity2.field_70161_v - entity2.field_70136_U) - Esp.mc.func_175598_ae().field_78728_n;
            this.a(entity2, d3, d4, d5);
            this.ab(entity2, d3, d4, d5);
        }
    }

    private void ab(Entity entity, double d, double d2, double d3) {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)((float)d), (float)((float)d2), (float)((float)d3));
        GL11.glNormal3f((float)0.0f, (float)1.0f, (float)0.0f);
        GL11.glRotatef((float)(-Esp.mc.func_175598_ae().field_78732_j), (float)0.0f, (float)0.2f, (float)0.0f);
        GL11.glRotatef((float)Esp.mc.func_175598_ae().field_78735_i, (float)1.0f, (float)0.0f, (float)0.0f);
        GL11.glEnable((int)3042);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        GL11.glLineWidth((float)2.0f);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2929);
        if (((EntityLivingBase)entity).func_110143_aJ() <= 20.0f) {
            Esp.drawRect(1.1f, 0.5f, 1.1f, 0.5f, -14880362);
        }
        if (((EntityLivingBase)entity).func_110143_aJ() <= 10.0f) {
            Esp.drawRect(1.1f, 2.0f, 1.7f, 2.0f, -196692);
        }
        if (((EntityLivingBase)entity).func_110143_aJ() <= 5.0f) {
            Esp.drawRect(1.1f, 0.5f, 1.1f, 0.5f, -63232);
        }
        GL11.glDisable((int)3042);
        GL11.glPopMatrix();
        GL11.glEnable((int)2929);
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glDisable((int)2848);
    }

    public Esp() {
        super("PlayerESP", "1", grozaclient.com.io.module.Category.Render);
        this.animalSet = new BooleanSetting("Animals", false);
        this.playerSet = new BooleanSetting("Players", true);
        this.invisibleSet = new BooleanSetting("Invisible", true);
    }

    public static void a(double d, double d2, double d3, double d4, float f, int n, int n2) {
        d4 = 0.0;
        d3 = 0.5;
        d2 = 2.0;
        d = -0.5;
        Esp.a((float)d, (float)d2, (float)d3, (float)d4, n2);
        float f2 = (float)(n >> 24 & 0xFF) / 255.0f;
        float f3 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f4 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f5 = (float)(n & 0xFF) / 255.0f;
        GL11.glPushMatrix();
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        GL11.glColor4f((float)f3, (float)f4, (float)f5, (float)f2);
        GL11.glLineWidth((float)2.0f);
        GL11.glBegin((int)1);
        GL11.glVertex2d((double)d, (double)d2);
        GL11.glVertex2d((double)d, (double)d4);
        GL11.glVertex2d((double)d3, (double)d4);
        GL11.glVertex2d((double)d3, (double)d2);
        GL11.glVertex2d((double)d, (double)d2);
        GL11.glVertex2d((double)d3, (double)d2);
        GL11.glVertex2d((double)d, (double)d4);
        GL11.glVertex2d((double)d3, (double)d4);
        GL11.glEnd();
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glDisable((int)2848);
        GL11.glPopMatrix();
    }

    public static void drawRect(float f, float f2, float f3, float f4, int n) {
        float f5;
        if (f < f3) {
            f5 = f;
            f = f3;
            f3 = f5;
        }
        if (f2 < f4) {
            f5 = f2;
            f2 = f4;
            f4 = f5;
        }
        f5 = (float)(n >> 24 & 0xFF) / 255.0f;
        float f6 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f7 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f8 = (float)(n & 0xFF) / 255.0f;
        Tessellator tessellator = Tessellator.func_178181_a();
        BufferBuilder bufferBuilder = tessellator.func_178180_c();
        GlStateManager.func_179147_l();
        GlStateManager.func_179090_x();
        GlStateManager.func_187428_a((GlStateManager.SourceFactor)GlStateManager.SourceFactor.SRC_ALPHA, (GlStateManager.DestFactor)GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, (GlStateManager.SourceFactor)GlStateManager.SourceFactor.ONE, (GlStateManager.DestFactor)GlStateManager.DestFactor.ZERO);
        GlStateManager.func_179131_c((float)f6, (float)f7, (float)f8, (float)f5);
        bufferBuilder.func_181668_a(7, DefaultVertexFormats.field_181705_e);
        bufferBuilder.func_181662_b((double)f, (double)f4, 0.0).func_181675_d();
        bufferBuilder.func_181662_b((double)f3, (double)f4, 0.0).func_181675_d();
        bufferBuilder.func_181662_b((double)f3, (double)f2, 0.0).func_181675_d();
        bufferBuilder.func_181662_b((double)f, (double)f2, 0.0).func_181675_d();
        tessellator.func_78381_a();
        GlStateManager.func_179098_w();
        GlStateManager.func_179084_k();
    }

    public static void a(float f, float f2, float f3, float f4, int n) {
        f4 = 0.0f;
        f3 = 0.5f;
        f2 = 2.0f;
        f = -0.5f;
        float f5 = (float)(n >> 24 & 0xFF) / 255.0f;
        float f6 = (float)(n >> 16 & 0xFF) / 255.0f;
        float f7 = (float)(n >> 8 & 0xFF) / 255.0f;
        float f8 = (float)(n & 0xFF) / 255.0f;
        GL11.glPushMatrix();
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)2848);
        GL11.glColor4f((float)f6, (float)f7, (float)f8, (float)f5);
        GL11.glBegin((int)7);
        GL11.glVertex2d((double)f3, (double)f2);
        GL11.glVertex2d((double)f, (double)f2);
        GL11.glVertex2d((double)f, (double)f4);
        GL11.glVertex2d((double)f3, (double)f4);
        GL11.glEnd();
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glDisable((int)2848);
        GL11.glPopMatrix();
    }
}

