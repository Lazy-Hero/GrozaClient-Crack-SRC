/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.MathHelper
 *  net.minecraft.util.math.Vec3d
 *  net.minecraftforge.client.event.RenderWorldLastEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.opengl.GL11
 */
package grozaclient.com.io.module.player;

import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class Tracers
extends Module {
    public Tracers() {
        super("Tracers", "", grozaclient.com.io.module.Category.Exploit);
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
    public void onRenderWorldLast(RenderWorldLastEvent event) {
        GL11.glPushMatrix();
        GL11.glEnable((int)2848);
        GL11.glDisable((int)2929);
        GL11.glDisable((int)3553);
        GL11.glDisable((int)2896);
        GL11.glDepthMask((boolean)false);
        GL11.glBlendFunc((int)770, (int)771);
        GL11.glEnable((int)3042);
        GL11.glLineWidth((float)1.0f);
        for (Entity entity : Tracers.mc.field_71441_e.field_72996_f) {
            if (entity == Tracers.mc.field_71439_g || entity == null || !(entity instanceof EntityPlayer)) continue;
            mc.func_175606_aa().func_70032_d(entity);
            double d = entity.field_70142_S + (entity.field_70165_t - entity.field_70142_S) - Tracers.mc.func_175598_ae().field_78730_l;
            double d2 = entity.field_70137_T + (entity.field_70163_u - entity.field_70137_T) - Tracers.mc.func_175598_ae().field_78731_m;
            double d3 = entity.field_70136_U + (entity.field_70161_v - entity.field_70136_U) - Tracers.mc.func_175598_ae().field_78728_n;
            float f2 = (float)(System.currentTimeMillis() % 2000L) / 1000.0f;
            float cfr_ignored_0 = 0.5f + 0.5f * MathHelper.func_76126_a((float)(f2 * (float)Math.PI));
            float cfr_ignored_1 = 0.5f + 0.5f * MathHelper.func_76126_a((float)((f2 + 1.3333334f) * (float)Math.PI));
            float cfr_ignored_2 = 0.5f + 0.5f * MathHelper.func_76126_a((float)((f2 + 2.6666667f) * (float)Math.PI));
            float cfr_ignored_3 = Tracers.mc.field_71439_g.func_70032_d(entity) / 20.0f;
            GL11.glColor4f((float)190.0f, (float)1.0f, (float)1.0f, (float)1.71f);
            Vec3d vec3d = new Vec3d(0.0, 0.0, 2.0);
            vec3d = vec3d.func_178789_a(-((float)Math.toRadians(Tracers.mc.field_71439_g.field_70125_A)));
            Vec3d vec3d2 = vec3d.func_178785_b(-((float)Math.toRadians(Tracers.mc.field_71439_g.field_70177_z)));
            GL11.glBegin((int)2);
            GL11.glVertex3d((double)vec3d2.field_72450_a, (double)((double)Tracers.mc.field_71439_g.func_70047_e() + vec3d2.field_72448_b), (double)vec3d2.field_72449_c);
            GL11.glVertex3d((double)d, (double)(d2 + 1.15), (double)d3);
            GL11.glEnd();
        }
        GL11.glDisable((int)3042);
        GL11.glDepthMask((boolean)true);
        GL11.glEnable((int)3553);
        GL11.glEnable((int)2929);
        GL11.glDisable((int)2848);
        GL11.glPopMatrix();
    }
}

