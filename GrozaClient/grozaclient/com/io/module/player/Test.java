/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.math.RayTraceResult$Type
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package grozaclient.com.io.module.player;

import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.RayTraceResult;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Test
extends Module {
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent playerTickEvent) {
        if (Minecraft.func_71410_x().field_71476_x != null && Minecraft.func_71410_x().field_71476_x.field_72313_a == RayTraceResult.Type.BLOCK) {
            int n = Minecraft.func_71410_x().field_71476_x.func_178782_a().func_177958_n();
            int n2 = Minecraft.func_71410_x().field_71476_x.func_178782_a().func_177956_o();
            int n3 = Minecraft.func_71410_x().field_71476_x.func_178782_a().func_177952_p();
            Minecraft.func_71410_x().field_71439_g.func_70107_b((double)n, (double)(n2 + 4), (double)n3);
        }
    }

    public Test() {
        super("Test", "", grozaclient.com.io.module.Category.Exploit);
    }
}

