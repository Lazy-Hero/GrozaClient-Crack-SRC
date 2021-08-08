/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$PlayerTickEvent
 */
package grozaclient.com.io.module.movement;

import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Strafe
extends Module {
    public static void strafe() {
        Strafe.strafe(Strafe.getSpeed());
    }

    public static void strafe(float f) {
        if (!Strafe.isMoving()) {
            return;
        }
        double d = Strafe.getDirection();
        Strafe.mc.field_71439_g.field_70159_w = -Math.sin(d) * (double)f;
        Strafe.mc.field_71439_g.field_70179_y = Math.cos(d) * (double)f;
    }

    public Strafe() {
        super("Strafe", "strafing", grozaclient.com.io.module.Category.Movement);
    }

    public static float getSpeed() {
        return (float)Math.sqrt(Strafe.mc.field_71439_g.field_70159_w * Strafe.mc.field_71439_g.field_70159_w + Strafe.mc.field_71439_g.field_70179_y * Strafe.mc.field_71439_g.field_70179_y);
    }

    public static double getDirection() {
        float f = Strafe.mc.field_71439_g.field_70177_z;
        if (Strafe.mc.field_71439_g.field_191988_bg < 0.0f) {
            f += 180.0f;
        }
        float f2 = 1.0f;
        if (Strafe.mc.field_71439_g.field_191988_bg < 0.0f) {
            f2 = -0.5f;
        } else if (Strafe.mc.field_71439_g.field_191988_bg > 0.0f) {
            f2 = 0.5f;
        }
        if (Strafe.mc.field_71439_g.field_70702_br > 0.0f) {
            f -= 90.0f * f2;
        }
        if (Strafe.mc.field_71439_g.field_70702_br < 0.0f) {
            f += 90.0f * f2;
        }
        return Math.toRadians(f);
    }

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent playerTickEvent) {
        Strafe.strafe();
    }

    public static boolean isMoving() {
        return Strafe.mc.field_71439_g != null && (Strafe.mc.field_71439_g.field_71158_b.field_192832_b != 0.0f || Strafe.mc.field_71439_g.field_71158_b.field_78902_a != 0.0f);
    }
}

