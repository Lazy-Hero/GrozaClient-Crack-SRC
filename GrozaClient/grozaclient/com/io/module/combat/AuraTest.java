/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.util.EnumHand
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package grozaclient.com.io.module.combat;

import grozaclient.com.io.GrozaClient;
import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import grozaclient.com.io.settings.RUtils;
import grozaclient.com.io.settings.Settinga;
import java.util.Comparator;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumHand;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AuraTest
extends Module {
    public EntityPlayer dedinside;

    public AuraTest() {
        super("AuraTest", "", grozaclient.com.io.module.Category.Rage);
        GrozaClient.instance.settingsManager.rSetting(new Settinga("Range", this, 3.8, 3.0, 6.0, false));
    }

    @Override
    public void onEnable() {
        this.dedinside = null;
        super.onEnable();
    }

    @Override
    public void onDisable() {
        this.dedinside = null;
        super.onDisable();
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent e) {
        float range = (float)GrozaClient.instance.settingsManager.getSettingByName(this, "Range").getValDouble();
        EntityPlayer target = AuraTest.mc.field_71441_e.field_73010_i.stream().filter(entityPlayer -> entityPlayer != AuraTest.mc.field_71439_g && !entityPlayer.func_82150_aj()).min(Comparator.comparing(entityPlayer -> Float.valueOf(entityPlayer.func_70032_d((Entity)AuraTest.mc.field_71439_g)))).filter(entityPlayer -> entityPlayer.func_70032_d((Entity)AuraTest.mc.field_71439_g) <= range).orElse(null);
        if (target != null) {
            AuraTest.mc.field_71439_g.func_70031_b(false);
            if (AuraTest.mc.field_71439_g.func_184825_o(0.0f) == 1.0f) {
                if (AuraTest.mc.field_71439_g.func_70032_d((Entity)target) <= range) {
                    AuraTest.mc.field_71439_g.field_70125_A = RUtils.rotations((Entity)target)[1] - 15.0f;
                    AuraTest.mc.field_71439_g.field_70177_z = RUtils.rotations((Entity)target)[0];
                    if (AuraTest.mc.field_71439_g.field_70143_R > 0.0f) {
                        AuraTest.mc.field_71442_b.func_78764_a((EntityPlayer)AuraTest.mc.field_71439_g, (Entity)target);
                        AuraTest.mc.field_71439_g.func_184609_a(EnumHand.MAIN_HAND);
                        AuraTest.mc.field_71439_g.func_184821_cY();
                    }
                }
            }
        }
    }
}

