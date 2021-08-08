/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.MathHelper
 */
package grozaclient.com.io.settings;

import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.MathHelper;

public class RotationUtils {
    public static Minecraft mc;

    public static float[] getAverageRotations(List list) {
        double d = 0.0;
        double d2 = 0.0;
        double d3 = 0.0;
        for (Object entityw : list) {
            Entity entity = (Entity)entityw;
            d += entity.field_70165_t;
            d2 += entity.func_174813_aQ().field_72337_e - 2.0;
            d3 += entity.field_70161_v;
        }
        return new float[]{RotationUtils.getRotationFromPosition(d /= (double)list.size(), d3 /= (double)list.size(), d2 /= (double)list.size())[0], RotationUtils.getRotationFromPosition(d, d3, d2)[1]};
    }

    public static float getDistanceBetweenAngles(float f, float f2) {
        float f3 = Math.abs(f - f2) % 360.0f;
        if (f3 > 180.0f) {
            f3 = 360.0f - f3;
        }
        return f3;
    }

    public static float getTrajAngleSolutionLow(float f, float f2, float f3) {
        float f4 = f3 * f3 * f3 * f3 - 0.006f * (0.006f * (f * f) + 2.0f * f2 * (f3 * f3));
        return (float)Math.toDegrees(Math.atan(((double)(f3 * f3) - Math.sqrt(f4)) / (double)(0.006f * f)));
    }

    public static float[] getRotationFromPosition(double d, double d2, double d3) {
        double d4 = d - Minecraft.func_71410_x().field_71439_g.field_70165_t;
        double d5 = d2 - Minecraft.func_71410_x().field_71439_g.field_70161_v;
        double d6 = d3 - Minecraft.func_71410_x().field_71439_g.field_70163_u - 0.6;
        double d7 = MathHelper.func_76133_a((double)(d4 * d4 + d5 * d5));
        float f = (float)(Math.atan2(d5, d4) * 180.0 / Math.PI) - 90.0f;
        float f2 = (float)(-(Math.atan2(d6, d7) * 180.0 / Math.PI));
        return new float[]{f, f2};
    }

    public static float[] getNeededRotations(EntityLivingBase entityLivingBase) {
        double d = entityLivingBase.field_70165_t - Minecraft.func_71410_x().field_71439_g.field_70165_t;
        double d2 = entityLivingBase.field_70161_v - Minecraft.func_71410_x().field_71439_g.field_70161_v;
        double d3 = entityLivingBase.field_70163_u + (double)entityLivingBase.func_70047_e() - (Minecraft.func_71410_x().field_71439_g.func_174813_aQ().field_72338_b + (Minecraft.func_71410_x().field_71439_g.func_174813_aQ().field_72337_e - Minecraft.func_71410_x().field_71439_g.func_174813_aQ().field_72338_b));
        double d4 = MathHelper.func_76133_a((double)(d * d + d2 * d2));
        float f = (float)(MathHelper.func_181159_b((double)d2, (double)d) * 180.0 / Math.PI) - 90.0f;
        float f2 = (float)(-(MathHelper.func_181159_b((double)d3, (double)d4) * 180.0 / Math.PI));
        return new float[]{f, f2};
    }

    public static float[] getRotations(EntityLivingBase entityLivingBase, String string) {
        if (string == "Head") {
            double d = entityLivingBase.field_70165_t;
            double d2 = entityLivingBase.field_70161_v;
            double d3 = entityLivingBase.field_70163_u + (double)(entityLivingBase.func_70047_e() / 2.0f);
            return RotationUtils.getRotationFromPosition(d, d2, d3);
        }
        if (string == "Chest") {
            double d = entityLivingBase.field_70165_t;
            double d4 = entityLivingBase.field_70161_v;
            double d5 = entityLivingBase.field_70163_u + (double)(entityLivingBase.func_70047_e() / 2.0f) - 0.75;
            return RotationUtils.getRotationFromPosition(d, d4, d5);
        }
        if (string == "Dick") {
            double d = entityLivingBase.field_70165_t;
            double d6 = entityLivingBase.field_70161_v;
            double d7 = entityLivingBase.field_70163_u + (double)(entityLivingBase.func_70047_e() / 2.0f) - 1.2;
            return RotationUtils.getRotationFromPosition(d, d6, d7);
        }
        if (string == "Legs") {
            double d = entityLivingBase.field_70165_t;
            double d8 = entityLivingBase.field_70161_v;
            double d9 = entityLivingBase.field_70163_u + (double)(entityLivingBase.func_70047_e() / 2.0f) - 1.5;
            return RotationUtils.getRotationFromPosition(d, d8, d9);
        }
        double d = entityLivingBase.field_70165_t;
        double d10 = entityLivingBase.field_70161_v;
        double d11 = entityLivingBase.field_70163_u + (double)(entityLivingBase.func_70047_e() / 2.0f) - 0.5;
        return RotationUtils.getRotationFromPosition(d, d10, d11);
    }

    public static float getNewAngle(float f) {
        float f2;
        f %= 360.0f;
        if (f2 >= 180.0f) {
            f -= 360.0f;
        }
        if (f < -180.0f) {
            f += 360.0f;
        }
        return f;
    }

    public static void rotations(EntityPlayer target) {
    }
}

