/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package grozaclient.com.io.module.misc;

import grozaclient.com.io.friend.FriendManager;
import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import grozaclient.com.io.settings.ChatUtil;
import grozaclient.com.io.settings.TimerUtil;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class MCF
extends Module {
    TimerUtil timerUtil = new TimerUtil();

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent playerTickEvent) {
        if (Minecraft.func_71410_x().field_71476_x != null && Minecraft.func_71410_x().field_71476_x.field_72308_g instanceof EntityPlayer && MCF.mc.field_71474_y.field_74322_I.func_151470_d() && this.timerUtil.hasReached(100.0)) {
            String string = Minecraft.func_71410_x().field_71476_x.field_72308_g.func_70005_c_();
            if (!FriendManager.isFriend(string)) {
                FriendManager.addFriend(string, string);
                ChatUtil.sendChatMessage("Added " + string + " as a friend.");
                this.timerUtil.reset();
                return;
            }
            if (this.timerUtil.hasReached(100.0)) {
                FriendManager.removeFriend(string);
                ChatUtil.sendChatMessage("Removed " + string + ".");
                this.timerUtil.reset();
            }
        }
    }

    public MCF() {
        super("MiddleClickFriend", "", grozaclient.com.io.module.Category.Misc);
    }
}

