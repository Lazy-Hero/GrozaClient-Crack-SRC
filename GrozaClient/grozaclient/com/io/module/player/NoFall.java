/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package grozaclient.com.io.module.player;

import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class NoFall
extends Module {
    public NoFall() {
        super("NoFall", "disable fall damage", grozaclient.com.io.module.Category.Exploit);
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent playerTickEvent) {
        if (NoFall.mc.field_71439_g.field_70143_R > 3.0f) {
            NoFall.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new CPacketPlayer(true));
            NoFall.mc.field_71439_g.field_70122_E = true;
            NoFall.mc.field_71439_g.field_70181_x = -0.48876887;
            NoFall.mc.field_71439_g.field_70143_R = 0.0f;
        }
    }
}

