/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.entity.item.EntityArmorStand
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.EnumHand
 *  net.minecraftforge.client.event.EntityViewRenderEvent$CameraSetup
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 *  net.minecraftforge.fml.relauncher.Side
 *  net.minecraftforge.fml.relauncher.SideOnly
 */
package grozaclient.com.io.module.combat;

import grozaclient.com.io.GrozaClient;
import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import grozaclient.com.io.settings.RotationUtils;
import grozaclient.com.io.settings.Settinga;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityArmorStand;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class KillAura
extends Module {
    private final int hitDelayTimer;
    private long curTimeHit;
    private final Random random;
    private long curTimeRotate;
    private final int rotateTimer;

    public KillAura() {
        super("KillAura", "automatically pvp", grozaclient.com.io.module.Category.Rage);
        GrozaClient.instance.settingsManager.rSetting(new Settinga("Range", this, 3.2, 3.0, 6.0, false));
        GrozaClient.instance.settingsManager.rSetting(new Settinga("SunRise", this, true));
        GrozaClient.instance.settingsManager.rSetting(new Settinga("OldMatrix", this, true));
        GrozaClient.instance.settingsManager.rSetting(new Settinga("NewMatrix", this, true));
        this.hitDelayTimer = 625;
        this.random = new Random();
        this.rotateTimer = 2000;
        this.curTimeHit = System.currentTimeMillis();
        this.curTimeRotate = System.currentTimeMillis();
    }

    public static float[] getRotations(Entity entity) {
        double d = entity.field_70165_t + (entity.field_70165_t - entity.field_70142_S) - KillAura.mc.field_71439_g.field_70165_t;
        double d2 = entity.field_70163_u + (double)entity.func_70047_e() - KillAura.mc.field_71439_g.field_70163_u + (double)KillAura.mc.field_71439_g.func_70047_e() - 3.5;
        double d3 = entity.field_70161_v + (entity.field_70161_v - entity.field_70136_U) - KillAura.mc.field_71439_g.field_70161_v;
        double d4 = Math.sqrt(Math.pow(d, 2.0) + Math.pow(d3, 2.0));
        float f = (float)Math.toDegrees(-Math.atan(d / d3));
        float f2 = (float)(-Math.toDegrees(Math.atan(d2 / d4)));
        if (d < 0.0 && d3 < 0.0) {
            f = (float)(90.0 + Math.toDegrees(Math.atan(d3 / d)));
        } else if (d > 0.0 && d3 < 0.0) {
            f = (float)(-90.0 + Math.toDegrees(Math.atan(d3 / d)));
        }
        return new float[]{f, f2};
    }

    @SideOnly(value=Side.SERVER)
    @SubscribeEvent
    public void onCameraSetup(EntityViewRenderEvent.CameraSetup cameraSetup) {
        block21: {
            if (KillAura.mc.field_71439_g == null || KillAura.mc.field_71439_g.field_70128_L) {
                return;
            }
            List list = KillAura.mc.field_71441_e.field_72996_f.stream().filter(entity -> entity != KillAura.mc.field_71439_g).filter(entity -> (double)KillAura.mc.field_71439_g.func_70032_d(entity) <= 3.5).filter(entity -> !entity.field_70128_L).filter(this::attackCheck).filter(entity -> !(entity instanceof EntityArmorStand)).sorted(Comparator.comparing(entity -> Float.valueOf(KillAura.mc.field_71439_g.func_70032_d(entity)))).collect(Collectors.toList());
            if (list.size() <= 0) break block21;
            float[] arrf = KillAura.getRotations((Entity)((EntityLivingBase)list.get(0)));
            arrf[0] = arrf[0] + (float)this.random.nextInt(30) * 0.1f;
            arrf[1] = arrf[1] + (float)this.random.nextInt(60) * 0.1f;
            float f = arrf[0] - 180.0f;
            float f2 = arrf[1];
            KillAura.mc.field_71439_g.field_70761_aq = f - 180.0f;
            KillAura.mc.field_71439_g.field_70759_as = f - 180.0f;
            if (f >= 0.0f) {
                if (cameraSetup.getYaw() < f) {
                    while (cameraSetup.getYaw() < f) {
                        cameraSetup.setYaw(cameraSetup.getYaw() + (float)this.random.nextInt(99) * 0.001f);
                    }
                } else {
                    while (cameraSetup.getYaw() > f) {
                        cameraSetup.setYaw(cameraSetup.getYaw() - (float)this.random.nextInt(99) * 0.001f);
                    }
                }
            } else if (cameraSetup.getYaw() < f) {
                while (cameraSetup.getYaw() < f) {
                    cameraSetup.setYaw(cameraSetup.getYaw() + (float)this.random.nextInt(99) * 0.001f);
                }
            } else {
                while (cameraSetup.getYaw() > f) {
                    cameraSetup.setYaw(cameraSetup.getYaw() - (float)this.random.nextInt(99) * 0.001f);
                }
            }
            if (f2 >= 0.0f) {
                if (cameraSetup.getPitch() < f2) {
                    while (cameraSetup.getPitch() < f2) {
                        cameraSetup.setPitch(cameraSetup.getPitch() + (float)this.random.nextInt(99) * 0.001f);
                    }
                } else {
                    while (cameraSetup.getPitch() > f2) {
                        cameraSetup.setPitch(cameraSetup.getPitch() - (float)this.random.nextInt(99) * 0.001f);
                    }
                }
            } else if (cameraSetup.getPitch() < f2) {
                while (cameraSetup.getPitch() < f2) {
                    cameraSetup.setPitch(cameraSetup.getPitch() + (float)this.random.nextInt(99) * 0.001f);
                }
            } else {
                while (cameraSetup.getPitch() > f2) {
                    cameraSetup.setPitch(cameraSetup.getPitch() - (float)this.random.nextInt(99) * 0.001f);
                }
            }
        }
    }

    private void setRotation(float f, float f2, EntityPlayer entityPlayer) {
        KillAura.mc.field_71439_g.field_70761_aq = f;
        KillAura.mc.field_71439_g.field_70759_as = f;
        if (f >= 0.0f) {
            if (KillAura.mc.field_71439_g.field_70177_z < f) {
                while (KillAura.mc.field_71439_g.field_70177_z < f) {
                    KillAura.mc.field_71439_g.field_70177_z = (float)((double)KillAura.mc.field_71439_g.field_70177_z + (double)this.random.nextInt(99) * 1.0E-4);
                }
            } else {
                while (KillAura.mc.field_71439_g.field_70177_z > f) {
                    KillAura.mc.field_71439_g.field_70177_z = (float)((double)KillAura.mc.field_71439_g.field_70177_z - (double)this.random.nextInt(99) * 1.0E-4);
                }
            }
        } else if (KillAura.mc.field_71439_g.field_70177_z < f) {
            while (KillAura.mc.field_71439_g.field_70177_z < f) {
                KillAura.mc.field_71439_g.field_70177_z = (float)((double)KillAura.mc.field_71439_g.field_70177_z + (double)this.random.nextInt(99) * 1.0E-4);
            }
        } else {
            while (KillAura.mc.field_71439_g.field_70177_z > f) {
                KillAura.mc.field_71439_g.field_70177_z = (float)((double)KillAura.mc.field_71439_g.field_70177_z - (double)this.random.nextInt(99) * 1.0E-4);
            }
        }
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    public boolean attackCheck(Entity entity) {
        return entity instanceof EntityPlayer && ((EntityPlayer)entity).func_110143_aJ() > 0.0f && Math.abs(KillAura.mc.field_71439_g.field_70177_z - RotationUtils.getNeededRotations((EntityLivingBase)entity)[0]) % 180.0f < 190.0f && !entity.func_82150_aj() && !entity.func_110124_au().equals(KillAura.mc.field_71439_g.func_110124_au());
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent playerTickEvent) {
        if (KillAura.mc.field_71439_g == null || KillAura.mc.field_71439_g.field_70128_L) {
            return;
        }
        List list = KillAura.mc.field_71441_e.field_72996_f.stream().filter(entity -> entity != KillAura.mc.field_71439_g).filter(entity -> KillAura.mc.field_71439_g.func_70032_d(entity) <= 50.0f).filter(entity -> !entity.field_70128_L).filter(this::attackCheck).filter(entity -> !(entity instanceof EntityArmorStand)).sorted(Comparator.comparing(entity -> Float.valueOf(KillAura.mc.field_71439_g.func_70032_d(entity)))).collect(Collectors.toList());
        if (list.size() > 0) {
            float[] arrf = KillAura.getRotations((Entity)list.get(0));
            if (KillAura.mc.field_71439_g.func_70032_d((Entity)list.get(0)) > 7.0f && System.currentTimeMillis() - this.curTimeRotate >= (long)this.rotateTimer) {
                this.setRotation(arrf[0], arrf[1], (EntityPlayer)list.get(0));
                this.curTimeRotate = System.currentTimeMillis();
            }
            if ((double)KillAura.mc.field_71439_g.func_70032_d((Entity)list.get(0)) <= GrozaClient.instance.settingsManager.getSettingByName(this, "Range").getValDouble() && System.currentTimeMillis() - this.curTimeHit >= (long)this.hitDelayTimer) {
                this.setRotation(arrf[0], arrf[1], (EntityPlayer)list.get(0));
                KillAura.mc.field_71442_b.func_78764_a((EntityPlayer)KillAura.mc.field_71439_g, (Entity)list.get(0));
                KillAura.mc.field_71439_g.func_184609_a(EnumHand.MAIN_HAND);
                this.curTimeHit = System.currentTimeMillis();
            }
        }
    }
}

