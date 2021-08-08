/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.entity.player.EntityPlayer
 *  net.minecraft.init.Items
 *  net.minecraft.inventory.ClickType
 *  net.minecraft.inventory.ContainerPlayer
 *  net.minecraft.inventory.EntityEquipmentSlot
 *  net.minecraft.item.ItemStack
 *  net.minecraft.util.NonNullList
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package grozaclient.com.io.module.combat;

import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ClickType;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class AutoTotem
extends Module {
    private final int OFFHAND_SLOT = 45;

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent playerTickEvent) {
        ItemStack itemStack = AutoTotem.mc.field_71439_g.func_184582_a(EntityEquipmentSlot.OFFHAND);
        NonNullList nonNullList = Minecraft.func_71410_x().field_71439_g.field_71071_by.field_70462_a;
        for (int i = 0; i < nonNullList.size(); ++i) {
            if (nonNullList.get(i) == ItemStack.field_190927_a || itemStack != null && itemStack.func_77973_b() == Items.field_190929_cY || ((ItemStack)nonNullList.get(i)).func_77973_b() != Items.field_190929_cY) continue;
            new ItemStack(Items.field_190929_cY);
            this.b(i);
            break;
        }
    }

    public AutoTotem() {
        super("AutoTotem", "automatically use totems", grozaclient.com.io.module.Category.Rage);
    }

    public void b(int n) {
        n = 0;
        if (AutoTotem.mc.field_71439_g.field_71070_bA instanceof ContainerPlayer && AutoTotem.mc.field_71439_g.field_70173_aa % 5 == 0) {
            AutoTotem.mc.field_71442_b.func_187098_a(0, 45, 0, ClickType.PICKUP, (EntityPlayer)AutoTotem.mc.field_71439_g);
            int n2 = n + 36;
            AutoTotem.mc.field_71442_b.func_187098_a(0, n2, 0, ClickType.PICKUP, (EntityPlayer)AutoTotem.mc.field_71439_g);
        }
    }
}

