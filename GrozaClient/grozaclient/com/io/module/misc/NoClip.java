/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package grozaclient.com.io.module.misc;

import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import grozaclient.com.io.module.player.EventUpdate;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class NoClip
extends Module {
    public NoClip() {
        super("NoClip", "", grozaclient.com.io.module.Category.Misc);
    }

    @SubscribeEvent
    public void onUpdate(EventUpdate event) {
        double forward = Minecraft.func_71410_x().field_71439_g.field_71158_b.field_192832_b;
        double strafe = Minecraft.func_71410_x().field_71439_g.field_71158_b.field_78902_a;
        float yaw = Minecraft.func_71410_x().field_71439_g.field_70177_z;
        if (forward == 0.0 && strafe == 0.0) {
            NoClip.mc.field_71439_g.field_70159_w = 0.0;
            NoClip.mc.field_71439_g.field_70179_y = 0.0;
        } else {
            if (forward != 0.0) {
                if (strafe > 0.0) {
                    yaw += (float)(forward > 0.0 ? -45 : 45);
                } else if (strafe < 0.0) {
                    yaw += (float)(forward > 0.0 ? 45 : -45);
                }
                strafe = 0.0;
                if (forward > 0.0) {
                    forward = 1.0;
                } else if (forward < 0.0) {
                    forward = -1.0;
                }
            }
            NoClip.mc.field_71439_g.func_70107_b(NoClip.mc.field_71439_g.field_70165_t + (forward * (double)0.3f * Math.cos(Math.toRadians(yaw + 90.0f)) + strafe * (double)0.3f * Math.sin(Math.toRadians(yaw + 90.0f))), NoClip.mc.field_71439_g.field_70163_u, NoClip.mc.field_71439_g.field_70161_v + (forward * (double)0.3f * Math.sin(Math.toRadians(yaw + 90.0f)) - strafe * (double)0.3f * Math.cos(Math.toRadians(yaw + 90.0f))));
        }
    }
}

