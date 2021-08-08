/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.EntityLivingBase
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketEntityAction
 *  net.minecraft.network.play.client.CPacketEntityAction$Action
 *  net.minecraftforge.event.entity.player.AttackEntityEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package grozaclient.com.io.module.combat;

import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketEntityAction;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class wTap
extends Module {
    public wTap() {
        super("wTap", "automatically push enemy", grozaclient.com.io.module.Category.Rage);
    }

    @SubscribeEvent
    public void onAttack(AttackEntityEvent attackEntityEvent) {
        if (attackEntityEvent.getTarget() instanceof EntityLivingBase) {
            if (wTap.mc.field_71439_g.func_70051_ag()) {
                wTap.mc.field_71439_g.func_70031_b(false);
            }
            wTap.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new CPacketEntityAction((Entity)wTap.mc.field_71439_g, CPacketEntityAction.Action.START_SPRINTING));
            wTap.mc.field_71439_g.func_70031_b(true);
        }
    }
}

