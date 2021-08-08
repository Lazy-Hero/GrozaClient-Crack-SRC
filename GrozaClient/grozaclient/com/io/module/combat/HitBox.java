/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.math.AxisAlignedBB
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 */
package grozaclient.com.io.module.combat;

import grozaclient.com.io.GrozaClient;
import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import grozaclient.com.io.module.combat.EntitySize;
import grozaclient.com.io.settings.Settinga;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class HitBox
extends Module {
    public void setEntityBoundingBoxSize(EntityPlayer entityPlayer, float f, float f2) {
        EntitySize entitySize = this.getEntitySize(entityPlayer);
        entityPlayer.field_70130_N = entitySize.width;
        entityPlayer.field_70131_O = entitySize.height;
        double d = (double)f / 2.0;
        entityPlayer.func_174826_a(new AxisAlignedBB(entityPlayer.field_70165_t - d, entityPlayer.field_70163_u, entityPlayer.field_70161_v - d, entityPlayer.field_70165_t + d, entityPlayer.field_70163_u + (double)f2, entityPlayer.field_70161_v + d));
    }

    public void setHitBoxForEntities() {
        if (HitBox.mc.field_71439_g == null || HitBox.mc.field_71439_g.field_70128_L) {
            return;
        }
        List list = HitBox.mc.field_71441_e.field_72996_f.stream().filter(entity -> entity != HitBox.mc.field_71439_g).filter(entity -> HitBox.mc.field_71439_g.func_70032_d(entity) <= 200.0f).filter(entity -> !entity.field_70128_L).filter(entity -> entity instanceof EntityPlayer).sorted(Comparator.comparing(entity -> Float.valueOf(HitBox.mc.field_71439_g.func_70032_d(entity)))).collect(Collectors.toList());
        for (Object entity2w : list) {
            Entity entity2 = (Entity)entity2w;
            float f = (float)GrozaClient.instance.settingsManager.getSettingByName(this, "X").getValDouble();
            float f2 = (float)GrozaClient.instance.settingsManager.getSettingByName(this, "Y").getValDouble();
            this.setEntityBoundingBoxSize((EntityPlayer)entity2, f, f2);
        }
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent clientTickEvent) {
        this.setHitBoxForEntities();
    }

    public HitBox() {
        super("HitBox", "bigger players range attack", grozaclient.com.io.module.Category.Rage);
        GrozaClient.instance.settingsManager.rSetting(new Settinga("X", this, 1.0, 0.0, 3.0, true));
        GrozaClient.instance.settingsManager.rSetting(new Settinga("Y", this, 2.0, 0.0, 3.0, true));
    }

    public EntitySize getEntitySize(EntityPlayer entityPlayer) {
        EntitySize entitySize = new EntitySize(0.6f, 1.8f);
        return entitySize;
    }

    public boolean check(EntityLivingBase entityLivingBase) {
        return !(entityLivingBase instanceof EntityPlayerSP) && entityLivingBase != HitBox.mc.field_71439_g && !entityLivingBase.field_70128_L && entityLivingBase.func_110143_aJ() >= 0.0f && entityLivingBase instanceof EntityPlayer;
    }
}

