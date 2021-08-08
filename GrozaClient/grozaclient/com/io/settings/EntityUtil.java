/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.item.ItemStack
 *  net.minecraft.item.ItemSword
 */
package grozaclient.com.io.settings;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class EntityUtil {
    public static int getSwordAtHotbar() {
        int i = 0;
        while (true) {
            Object mc = null;
            assert (false);
            ItemStack itemStack = mc.field_71439_g.field_71071_by.func_70301_a(i);
            if (itemStack.func_77973_b() instanceof ItemSword) {
                return i;
            }
            ++i;
        }
    }
}

