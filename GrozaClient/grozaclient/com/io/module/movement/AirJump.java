/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$PositionRotation
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package grozaclient.com.io.module.movement;

import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AirJump
extends Module {
    public AirJump(String name, String description, Category category) {
        super(name, description, category);
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent playerTickEvent) {
        if (AirJump.mc.field_71474_y.field_74314_A.func_151468_f()) {
            AirJump.mc.field_71439_g.field_70181_x = 0.413213;
            double d = AirJump.mc.field_71439_g.field_70165_t;
            double d2 = AirJump.mc.field_71439_g.field_70163_u;
            double d3 = AirJump.mc.field_71439_g.field_70161_v;
            AirJump.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new CPacketPlayer.PositionRotation(d, d2 + 0.413213, d3, AirJump.mc.field_71439_g.field_70177_z, AirJump.mc.field_71439_g.field_70125_A, true));
            AirJump.mc.field_71439_g.func_180426_a(d, d2 + 0.413213, d3, AirJump.mc.field_71439_g.field_70177_z, AirJump.mc.field_71439_g.field_70125_A, 1, false);
        }
    }

    public AirJump() {
        super("AirJump", "you can AirJump", grozaclient.com.io.module.Category.Movement);
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}

