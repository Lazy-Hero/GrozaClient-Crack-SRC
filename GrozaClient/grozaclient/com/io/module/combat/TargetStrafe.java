/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.renderer.GlStateManager
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityArmorStand
 *  net.minecraft.entity.monster.EntityMob
 *  net.minecraft.entity.passive.EntityAnimal
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.potion.Potion
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package grozaclient.com.io.module.combat;

import grozaclient.com.io.GrozaClient;
import grozaclient.com.io.friend.Friend;
import grozaclient.com.io.friend.FriendManager;
import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import grozaclient.com.io.settings.BooleanSetting;
import grozaclient.com.io.settings.RotationUtils;
import grozaclient.com.io.settings.Settinga;
import grozaclient.com.io.settings.TimerUtil;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class TargetStrafe
extends Module {
    public TimerUtil timerUtil;
    public BooleanSetting playerSet;
    public BooleanSetting animalSett;
    public BooleanSetting mobSet;
    public BooleanSetting invisibleTarget;
    public boolean sideDirection = true;
    public static int direction = -1;
    public double increment = 0.05;
    public BooleanSetting renderCircle;

    public double getMovementSpeed() {
        double d = 0.2873;
        if (Minecraft.func_71410_x().field_71439_g.func_70644_a(Objects.requireNonNull(Potion.func_188412_a((int)1)))) {
            int n = Objects.requireNonNull(Minecraft.func_71410_x().field_71439_g.func_70660_b(Objects.requireNonNull(Potion.func_188412_a((int)1)))).func_76458_c();
            d *= 1.0 + 0.2 * (double)(n + 1);
        }
        return d;
    }

    public Entity getTargetEz() {
        if (TargetStrafe.mc.field_71439_g == null || TargetStrafe.mc.field_71439_g.field_70128_L) {
            return null;
        }
        List list = TargetStrafe.mc.field_71441_e.field_72996_f.stream().filter(entity -> entity != TargetStrafe.mc.field_71439_g).filter(entity -> (double)TargetStrafe.mc.field_71439_g.func_70032_d(entity) <= GrozaClient.instance.settingsManager.getSettingByName(this, "Range").getValDouble()).filter(entity -> !entity.field_70128_L).filter(this::lambda$getTargetEz$3).sorted(Comparator.comparing(entity -> Float.valueOf(TargetStrafe.mc.field_71439_g.func_70032_d(entity)))).collect(Collectors.toList());
        if (list.size() > 0) {
            return (Entity)list.get(0);
        }
        return null;
    }

    public final boolean doStrafeAtSpeed(double d) {
        boolean bl = true;
        Entity entity = this.getTargetEz();
        if (entity != null) {
            if (TargetStrafe.mc.field_71439_g.field_70122_E) {
                TargetStrafe.mc.field_71439_g.func_70664_aZ();
            }
            float[] arrf = RotationUtils.getNeededRotations((EntityLivingBase)entity);
            if ((double)Minecraft.func_71410_x().field_71439_g.func_70032_d(entity) <= GrozaClient.instance.settingsManager.getSettingByName(this, "Range").getValDouble()) {
                TargetStrafe.mc.field_71439_g.field_70761_aq = arrf[0];
                TargetStrafe.mc.field_71439_g.field_70759_as = arrf[0];
                TargetStrafe.setSpeed(d - (0.1 - GrozaClient.instance.settingsManager.getSettingByName(this, "Speed").getValDouble() / 100.0), arrf[0], direction, 0.0);
            } else {
                TargetStrafe.setSpeed(d - (0.1 - GrozaClient.instance.settingsManager.getSettingByName(this, "Speed").getValDouble() / 100.0), arrf[0], direction, 1.0);
                TargetStrafe.mc.field_71439_g.field_70761_aq = arrf[0];
                TargetStrafe.mc.field_71439_g.field_70759_as = arrf[0];
            }
        }
        return true;
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent playerTickEvent) {
        if (TargetStrafe.mc.field_71439_g.field_70123_F && this.timerUtil.hasReached(80.0)) {
            this.timerUtil.reset();
            this.invertStrafe();
        }
        TargetStrafe.mc.field_71439_g.field_71158_b.field_192832_b = 0.0f;
        double d = this.getMovementSpeed();
        this.doStrafeAtSpeed(d);
    }

    public TargetStrafe() {
        super("TargetStrafe", "", grozaclient.com.io.module.Category.Rage);
        GrozaClient.instance.settingsManager.rSetting(new Settinga("Speed", this, -7.0, -7.0, 10.0, true));
        GrozaClient.instance.settingsManager.rSetting(new Settinga("Range", this, 3.0, 0.0, 5.0, true));
        GrozaClient.instance.settingsManager.rSetting(new Settinga("OnlyCrit", this, true));
        this.invisibleTarget = new BooleanSetting("Invisible", false);
        this.playerSet = new BooleanSetting("Players", true);
        this.mobSet = new BooleanSetting("Mobs", false);
        this.animalSett = new BooleanSetting("Animals", false);
        this.timerUtil = new TimerUtil();
    }

    public static void setSpeed(double d, float f, double d2, double d3) {
        double d4 = d3;
        double d5 = d2;
        float f2 = f;
        if (d4 == 0.0 && d5 == 0.0) {
            TargetStrafe.mc.field_71439_g.field_70179_y = 0.0;
            TargetStrafe.mc.field_71439_g.field_70159_w = 0.0;
        } else {
            if (d4 != 0.0) {
                if (d5 > 0.0) {
                    f2 += (float)(d4 > 0.0 ? -45 : 45);
                } else if (d5 < 0.0) {
                    f2 += (float)(d4 > 0.0 ? 45 : -45);
                }
                d5 = 0.0;
                if (d4 > 0.0) {
                    d4 = 1.0;
                } else if (d4 < 0.0) {
                    d4 = -1.0;
                }
            }
            double d6 = Math.cos(Math.toRadians(f2 + 90.0f));
            double d7 = Math.sin(Math.toRadians(f2 + 90.0f));
            TargetStrafe.mc.field_71439_g.field_70159_w = d4 * d * d6 + d5 * d * d7;
            TargetStrafe.mc.field_71439_g.field_70179_y = d4 * d * d7 - d5 * d * d6;
        }
    }

    private void drawRadius(Entity entity, double d, double d2, double d3, double d4) {
        GlStateManager.func_179126_j();
        double d5 = 0.0;
        Double.compare(0.0, 0.01);
    }

    private boolean lambda$getTargetEz$3(Entity entity) {
        return this.attackCheck(entity);
    }

    @Override
    public boolean onRenderWorldLast(float f) {
        if (TargetStrafe.mc.field_71439_g == null || TargetStrafe.mc.field_71439_g.field_70128_L) {
            return false;
        }
        List list = TargetStrafe.mc.field_71441_e.field_72996_f.stream().filter(entity -> entity != TargetStrafe.mc.field_71439_g).filter(entity -> TargetStrafe.mc.field_71439_g.func_70032_d(entity) <= 15.0f).filter(entity -> !entity.field_70128_L).filter(this::attackCheckin).filter(entity -> !(entity instanceof EntityArmorStand)).sorted(Comparator.comparing(entity -> Float.valueOf(TargetStrafe.mc.field_71439_g.func_70032_d(entity)))).collect(Collectors.toList());
        if (list.size() > 0) {
            double d = GrozaClient.instance.settingsManager.getSettingByName(this, "Range").getValDouble();
            Entity entity2 = (Entity)list.get(0);
            double d2 = entity2.field_70142_S + (entity2.field_70165_t - entity2.field_70142_S) * (double)f - TargetStrafe.mc.func_175598_ae().field_78730_l;
            double d3 = entity2.field_70137_T + (entity2.field_70163_u - entity2.field_70137_T) * (double)f - TargetStrafe.mc.func_175598_ae().field_78731_m;
            double d4 = entity2.field_70136_U + (entity2.field_70161_v - entity2.field_70136_U) * (double)f - TargetStrafe.mc.func_175598_ae().field_78728_n;
            if (this.increment < 2.03 && this.sideDirection) {
                if (this.increment >= 2.0) {
                    this.sideDirection = false;
                    this.increment = 2.0;
                    d3 -= this.increment;
                }
                this.increment += 0.02;
                this.drawRadius((Entity)list.get(0), d2, d3 += this.increment, d4, d);
            }
            if (this.increment > 0.01 && !this.sideDirection) {
                if (this.increment <= 0.02) {
                    this.sideDirection = true;
                    this.increment = 0.01;
                }
                this.increment -= 0.02;
                this.drawRadius((Entity)list.get(0), d2, d3 += this.increment, d4, d);
            }
        }
        return false;
    }

    public boolean attackCheck(Entity entity) {
        for (Object friendw : FriendManager.friends) {
            Friend friend = (Friend)friendw;
            if (entity.func_70005_c_() != friend.name) continue;
            return false;
        }
        return this.invisibleTarget.isEnabled() && entity.func_82150_aj() && (this.playerSet.isEnabled() && entity instanceof EntityPlayer || this.mobSet.isEnabled() && entity instanceof EntityMob || this.animalSett.isEnabled() && entity instanceof EntityAnimal) || this.playerSet.isEnabled() && entity instanceof EntityPlayer && !entity.func_82150_aj() || this.animalSett.isEnabled() && entity instanceof EntityAnimal && !entity.func_82150_aj() || this.mobSet.isEnabled() && entity instanceof EntityMob && !entity.func_82150_aj();
    }

    private void invertStrafe() {
        direction = -direction;
    }

    public boolean attackCheckin(Entity entity) {
        return entity instanceof EntityPlayer && ((EntityPlayer)entity).func_110143_aJ() > 0.0f && Math.abs(TargetStrafe.mc.field_71439_g.field_70177_z - RotationUtils.getNeededRotations((EntityLivingBase)entity)[0]) % 180.0f < 190.0f && !entity.func_82150_aj() && !entity.func_110124_au().equals(TargetStrafe.mc.field_71439_g.func_110124_au());
    }
}

