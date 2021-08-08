/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.entity.EntityOtherPlayerMP
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package grozaclient.com.io.module.player;

import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Blink
extends Module {
    private EntityOtherPlayerMP oldPlayer;

    @Override
    public void onEnable() {
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent playerTickEvent) {
    }

    public Blink() {
        super("Blink", "Simulates lag. For other players it looks like you are teleporting.", grozaclient.com.io.module.Category.Exploit);
    }

    @Override
    public void onDisable() {
    }
}

