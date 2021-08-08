/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.entity.projectile.EntityEgg
 *  net.minecraft.util.EnumFacing
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraft.world.World
 */
package grozaclient.com.io.settings;

import grozaclient.com.io.module.combat.EntitySize;
import grozaclient.com.io.settings.Wrapper;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityEgg;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class Utils {
    public static float getDirection;

    public static EntitySize getEntitySize(Entity entity) {
        EntitySize entitySize = new EntitySize(0.6f, 1.8f);
        return entitySize;
    }

    public static List<Entity> getEntityList() {
        return Minecraft.func_71410_x().field_71441_e.func_72910_y();
    }

    public static List<EntityPlayer> getPlayersList() {
        return Minecraft.func_71410_x().field_71441_e.field_73010_i;
    }

    private static float[] getDirection(Entity var0) {
        float[] arrf = new float[2];
        arrf[0] = Utils.getYaw(var0) + Wrapper.player().field_70177_z;
        arrf[1] = Utils.getPitch(var0) + Wrapper.player().field_70125_A;
        return arrf;
    }

    public static float[] getDirectionToBlock(int var0, int var1, int var2, EnumFacing var3) {
        EntityEgg var4 = new EntityEgg((World)Wrapper.INSTANCE.world());
        var4.field_70165_t = (double)var0 + 0.5;
        var4.field_70163_u = (double)var1 + 0.5;
        var4.field_70161_v = (double)var2 + 0.5;
        var4.field_70165_t += (double)var3.func_176730_m().func_177958_n() * 0.25;
        var4.field_70163_u += (double)var3.func_176730_m().func_177956_o() * 0.25;
        var4.field_70161_v += (double)var3.func_176730_m().func_177952_p() * 0.25;
        return Utils.getDirection((Entity)var4);
    }

    public static float getYaw(Entity entity) {
        double x = entity.field_70165_t - Wrapper.player().field_70165_t;
        double y = entity.field_70163_u - Wrapper.player().field_70163_u;
        double z = entity.field_70161_v - Wrapper.player().field_70161_v;
        double yaw = Math.atan2(x, z) * 57.29577951308232;
        yaw = -yaw;
        return (float)yaw;
    }

    public static float getPitch(Entity entity) {
        double x = entity.field_70165_t - Wrapper.player().field_70165_t;
        double y = entity.field_70163_u - Wrapper.player().field_70163_u;
        double z = entity.field_70161_v - Wrapper.player().field_70161_v;
        double pitch = Math.asin(y /= (double)Wrapper.player().func_70032_d(entity)) * 57.29577951308232;
        pitch = -pitch;
        return (float)pitch;
    }

    public static void setEntityBoundingBoxSize(Entity entity, float width, float height) {
        EntitySize size = Utils.getEntitySize(entity);
        entity.field_70130_N = size.width;
        entity.field_70131_O = size.height;
        double d0 = (double)width / 2.0;
        entity.func_174826_a(new AxisAlignedBB(entity.field_70165_t - d0, entity.field_70163_u, entity.field_70161_v - d0, entity.field_70165_t + d0, entity.field_70163_u + (double)height, entity.field_70161_v + d0));
    }

    public static float getDirection() {
        float var1 = Wrapper.player().field_70177_z;
        if (Wrapper.player().field_191988_bg < 0.0f) {
            var1 += 180.0f;
        }
        float forward = 1.0f;
        if (Wrapper.player().field_191988_bg < 0.0f) {
            forward = -0.5f;
        } else if (Wrapper.player().field_191988_bg > 0.0f) {
            forward = 0.5f;
        }
        if (Wrapper.player().field_70702_br > 0.0f) {
            var1 -= 90.0f * forward;
        }
        if (Wrapper.player().field_70702_br < 0.0f) {
            var1 += 90.0f * forward;
        }
        return var1 *= (float)Math.PI / 180;
    }

    public static String getPlayerName(EntityPlayer player) {
        return player.func_146103_bH() != null ? player.func_146103_bH().getName() : "null";
    }

    public static boolean isPlayer(Entity entity) {
        if (entity instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer)entity;
            String entityName = Utils.getPlayerName(player);
            String playerName = Utils.getPlayerName((EntityPlayer)Wrapper.player());
            if (entityName.equals(playerName)) {
                return true;
            }
        }
        return false;
    }
}

