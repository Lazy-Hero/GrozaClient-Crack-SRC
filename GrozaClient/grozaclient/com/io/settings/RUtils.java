/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.util.math.MathHelper
 */
package grozaclient.com.io.settings;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class RUtils {
    public static final Minecraft mc = Minecraft.func_71410_x();

    public static float[] rotations(Entity entity) {
        double d0 = entity.field_70165_t - RUtils.mc.field_71439_g.field_70165_t;
        double d2 = entity.field_70163_u - (RUtils.mc.field_71439_g.field_70163_u + (double)RUtils.mc.field_71439_g.func_70047_e());
        double d3 = entity.field_70161_v - RUtils.mc.field_71439_g.field_70161_v;
        double d4 = MathHelper.func_76133_a((double)(d0 * d0 + d3 * d3));
        float f = (float)(MathHelper.func_181159_b((double)d3, (double)d0) * 57.29577951308232) - 90.0f;
        float f2 = (float)(-(MathHelper.func_181159_b((double)d2, (double)d4) * 57.29577951308232));
        return new float[]{f, f2};
    }
}

