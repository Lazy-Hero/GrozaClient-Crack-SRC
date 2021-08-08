/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.AxisAlignedBB
 *  org.lwjgl.opengl.GL11
 */
package grozaclient.com.io.settings;

import grozaclient.com.io.settings.Wrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import org.lwjgl.opengl.GL11;

public class RenderUtils {
    protected static Minecraft mc = Minecraft.func_71410_x();

    public static void drawRect(double x, double y, double d, double e, int color) {
        float f = (float)(color >> 24 & 0xFF) / 255.0f;
        float f1 = (float)(color >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(color >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(color & 0xFF) / 255.0f;
        RenderUtils.glRenderStart();
        GL11.glColor4f((float)f1, (float)f2, (float)f3, (float)f);
        GL11.glBegin((int)7);
        GL11.glVertex2d((double)x, (double)y);
        GL11.glVertex2d((double)d, (double)y);
        GL11.glVertex2d((double)d, (double)e);
        GL11.glVertex2d((double)x, (double)e);
        GL11.glEnd();
        RenderUtils.glRenderStop();
    }

    public static void drawESP(Entity entity, float colorRed, float colorGreen, float colorBlue, float colorAlpha, float ticks) {
        try {
            double renderPosX = Wrapper.INSTANCE.mc().func_175598_ae().field_78730_l;
            double renderPosY = Wrapper.INSTANCE.mc().func_175598_ae().field_78731_m;
            double renderPosZ = Wrapper.INSTANCE.mc().func_175598_ae().field_78728_n;
            double xPos = entity.field_70142_S + (entity.field_70165_t - entity.field_70142_S) * (double)ticks - renderPosX;
            double yPos = entity.field_70137_T + (entity.field_70163_u - entity.field_70137_T) * (double)ticks + (double)(entity.field_70131_O / 2.0f) - renderPosY;
            double zPos = entity.field_70136_U + (entity.field_70161_v - entity.field_70136_U) * (double)ticks - renderPosZ;
            float playerViewY = Wrapper.INSTANCE.mc().func_175598_ae().field_78735_i;
            float playerViewX = Wrapper.INSTANCE.mc().func_175598_ae().field_78732_j;
            boolean thirdPersonView = Wrapper.INSTANCE.mc().func_175598_ae().field_78733_k.field_74320_O == 2;
            GL11.glPushMatrix();
            GlStateManager.func_179137_b((double)xPos, (double)yPos, (double)zPos);
            GlStateManager.func_187432_a((float)0.0f, (float)1.0f, (float)0.0f);
            GlStateManager.func_179114_b((float)(-playerViewY), (float)0.0f, (float)1.0f, (float)0.0f);
            GlStateManager.func_179114_b((float)((float)(thirdPersonView ? -1 : 1) * playerViewX), (float)1.0f, (float)0.0f, (float)0.0f);
            GL11.glEnable((int)3042);
            GL11.glDisable((int)3553);
            GL11.glDisable((int)2896);
            GL11.glDisable((int)2929);
            GL11.glDepthMask((boolean)false);
            GL11.glLineWidth((float)1.0f);
            GL11.glBlendFunc((int)770, (int)771);
            GL11.glEnable((int)2848);
            GL11.glColor4f((float)colorRed, (float)colorGreen, (float)colorBlue, (float)colorAlpha);
            GL11.glBegin((int)1);
            GL11.glVertex3d((double)0.0, (double)1.0, (double)0.0);
            GL11.glVertex3d((double)-0.5, (double)0.5, (double)0.0);
            GL11.glVertex3d((double)0.0, (double)1.0, (double)0.0);
            GL11.glVertex3d((double)0.5, (double)0.5, (double)0.0);
            GL11.glVertex3d((double)0.0, (double)0.0, (double)0.0);
            GL11.glVertex3d((double)-0.5, (double)0.5, (double)0.0);
            GL11.glVertex3d((double)0.0, (double)0.0, (double)0.0);
            GL11.glVertex3d((double)0.5, (double)0.5, (double)0.0);
            GL11.glEnd();
            GL11.glDepthMask((boolean)true);
            GL11.glEnable((int)2929);
            GL11.glEnable((int)3553);
            GL11.glEnable((int)2896);
            GL11.glDisable((int)2848);
            GL11.glDisable((int)3042);
            GL11.glPopMatrix();
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public static void glRenderStart() {
        GL11.glPushMatrix();
        GL11.glPushAttrib((int)1048575);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)2884);
        GL11.glDisable((int)3553);
    }

    public static void glRenderStop() {
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2884);
        GL11.glDisable((int)3042);
        GL11.glPopAttrib();
        GL11.glPopMatrix();
    }

    public static void drawCircle(float cx, double cy, float r, int num_segments, int c) {
        GL11.glPushMatrix();
        cx *= 2.0f;
        cy *= 2.0;
        float f = (float)(c >> 24 & 0xFF) / 255.0f;
        float f1 = (float)(c >> 16 & 0xFF) / 255.0f;
        float f2 = (float)(c >> 8 & 0xFF) / 255.0f;
        float f3 = (float)(c & 0xFF) / 255.0f;
        float theta = (float)(6.2831852 / (double)num_segments);
        float p = (float)Math.cos(theta);
        float s = (float)Math.sin(theta);
        float x = r *= 2.0f;
        float y = 0.0f;
        GL11.glEnable((int)2848);
        RenderUtils.enableGL2D();
        GL11.glScalef((float)0.5f, (float)0.5f, (float)0.5f);
        GL11.glColor4f((float)f1, (float)f2, (float)f3, (float)f);
        GL11.glBegin((int)2);
        for (int ii = 0; ii < num_segments; ++ii) {
            GL11.glVertex2f((float)(x + cx), (float)((float)((double)y + cy)));
            float t = x;
            x = p * x - s * y;
            y = s * t + p * y;
        }
        GL11.glEnd();
        GL11.glScalef((float)2.0f, (float)2.0f, (float)2.0f);
        RenderUtils.disableGL2D();
        GlStateManager.func_179131_c((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
        GL11.glPopMatrix();
    }

    public static void disableGL2D() {
        GL11.glEnable((int)3553);
        GL11.glDisable((int)3042);
        GL11.glEnable((int)2929);
        GL11.glDisable((int)2848);
        GL11.glHint((int)3154, (int)4352);
        GL11.glHint((int)3155, (int)4352);
    }

    public static void enableGL2D() {
        GL11.glDisable((int)2929);
        GL11.glEnable((int)3042);
        GL11.glDisable((int)3553);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glDepthMask((boolean)true);
        GL11.glEnable((int)2848);
        GL11.glHint((int)3154, (int)4354);
        GL11.glHint((int)3155, (int)4354);
    }

    public static void drawSolidBox(AxisAlignedBB axisAlignedBB) {
        GL11.glBegin((int)7);
        GL11.glVertex3d((double)axisAlignedBB.field_72340_a, (double)axisAlignedBB.field_72338_b, (double)axisAlignedBB.field_72339_c);
        GL11.glVertex3d((double)axisAlignedBB.field_72340_a, (double)axisAlignedBB.field_72337_e, (double)axisAlignedBB.field_72339_c);
        GL11.glVertex3d((double)axisAlignedBB.field_72336_d, (double)axisAlignedBB.field_72337_e, (double)axisAlignedBB.field_72339_c);
        GL11.glVertex3d((double)axisAlignedBB.field_72336_d, (double)axisAlignedBB.field_72338_b, (double)axisAlignedBB.field_72339_c);
        GL11.glVertex3d((double)axisAlignedBB.field_72336_d, (double)axisAlignedBB.field_72338_b, (double)axisAlignedBB.field_72339_c);
        GL11.glVertex3d((double)axisAlignedBB.field_72336_d, (double)axisAlignedBB.field_72337_e, (double)axisAlignedBB.field_72339_c);
        GL11.glVertex3d((double)axisAlignedBB.field_72336_d, (double)axisAlignedBB.field_72337_e, (double)axisAlignedBB.field_72334_f);
        GL11.glVertex3d((double)axisAlignedBB.field_72336_d, (double)axisAlignedBB.field_72338_b, (double)axisAlignedBB.field_72334_f);
        GL11.glVertex3d((double)axisAlignedBB.field_72340_a, (double)axisAlignedBB.field_72338_b, (double)axisAlignedBB.field_72334_f);
        GL11.glVertex3d((double)axisAlignedBB.field_72336_d, (double)axisAlignedBB.field_72338_b, (double)axisAlignedBB.field_72334_f);
        GL11.glVertex3d((double)axisAlignedBB.field_72336_d, (double)axisAlignedBB.field_72337_e, (double)axisAlignedBB.field_72334_f);
        GL11.glVertex3d((double)axisAlignedBB.field_72340_a, (double)axisAlignedBB.field_72337_e, (double)axisAlignedBB.field_72334_f);
        GL11.glVertex3d((double)axisAlignedBB.field_72340_a, (double)axisAlignedBB.field_72338_b, (double)axisAlignedBB.field_72339_c);
        GL11.glVertex3d((double)axisAlignedBB.field_72340_a, (double)axisAlignedBB.field_72338_b, (double)axisAlignedBB.field_72334_f);
        GL11.glVertex3d((double)axisAlignedBB.field_72340_a, (double)axisAlignedBB.field_72337_e, (double)axisAlignedBB.field_72334_f);
        GL11.glVertex3d((double)axisAlignedBB.field_72340_a, (double)axisAlignedBB.field_72337_e, (double)axisAlignedBB.field_72339_c);
        GL11.glVertex3d((double)axisAlignedBB.field_72340_a, (double)axisAlignedBB.field_72338_b, (double)axisAlignedBB.field_72339_c);
        GL11.glVertex3d((double)axisAlignedBB.field_72336_d, (double)axisAlignedBB.field_72338_b, (double)axisAlignedBB.field_72339_c);
        GL11.glVertex3d((double)axisAlignedBB.field_72336_d, (double)axisAlignedBB.field_72338_b, (double)axisAlignedBB.field_72334_f);
        GL11.glVertex3d((double)axisAlignedBB.field_72340_a, (double)axisAlignedBB.field_72338_b, (double)axisAlignedBB.field_72334_f);
        GL11.glVertex3d((double)axisAlignedBB.field_72340_a, (double)axisAlignedBB.field_72337_e, (double)axisAlignedBB.field_72339_c);
        GL11.glVertex3d((double)axisAlignedBB.field_72340_a, (double)axisAlignedBB.field_72337_e, (double)axisAlignedBB.field_72334_f);
        GL11.glVertex3d((double)axisAlignedBB.field_72336_d, (double)axisAlignedBB.field_72337_e, (double)axisAlignedBB.field_72334_f);
        GL11.glVertex3d((double)axisAlignedBB.field_72336_d, (double)axisAlignedBB.field_72337_e, (double)axisAlignedBB.field_72339_c);
        GL11.glEnd();
    }
}

