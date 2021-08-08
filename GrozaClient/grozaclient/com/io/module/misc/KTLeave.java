/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketPlayer$Position
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package grozaclient.com.io.module.misc;

import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class KTLeave
extends Module {
    private double toAdd;

    @Override
    public void onEnable() {
        super.onEnable();
        this.toAdd = KTLeave.mc.field_71439_g.field_70163_u + 100.0;
    }

    @Override
    public void onDisable() {
        super.onDisable();
        KTLeave.mc.field_71439_g.field_70145_X = false;
    }

    public KTLeave() {
        super("KTLeave", "100 blocks upper", grozaclient.com.io.module.Category.Misc);
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent playerTickEvent) {
        if (KTLeave.mc.field_71439_g.field_70163_u >= this.toAdd - 5.0 && KTLeave.mc.field_71439_g.field_70163_u <= this.toAdd + 5.0) {
            KTLeave.mc.field_71439_g.field_70145_X = true;
            KTLeave.mc.field_71439_g.field_70181_x = 0.0;
            return;
        }
        KTLeave.mc.field_71439_g.field_70145_X = false;
        KTLeave.mc.field_71439_g.func_70107_b(KTLeave.mc.field_71439_g.field_70165_t, this.toAdd, KTLeave.mc.field_71439_g.field_70161_v);
        KTLeave.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new CPacketPlayer.Position(KTLeave.mc.field_71439_g.field_70165_t, this.toAdd, KTLeave.mc.field_71439_g.field_70161_v, true));
    }
}

