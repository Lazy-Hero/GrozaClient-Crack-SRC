/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.client.event.InputUpdateEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package grozaclient.com.io.module.movement;

import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AutoWalkShift
extends Module {
    @SubscribeEvent
    public void onUpdateInput(InputUpdateEvent event) {
        event.getMovementInput().field_192832_b = 1.0f;
    }

    public AutoWalkShift() {
        super("AutoWalkShift", "", grozaclient.com.io.module.Category.Movement);
    }

    @Override
    public boolean onRenderWorldLast(float f) {
        return false;
    }
}

