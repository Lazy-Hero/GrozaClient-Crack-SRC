/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 *  net.minecraft.client.gui.inventory.GuiContainer
 *  net.minecraft.util.math.MathHelper
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.TickEvent$ClientTickEvent
 *  org.lwjgl.input.Keyboard
 */
package grozaclient.com.io.module.movement;

import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import grozaclient.com.io.settings.Utils;
import grozaclient.com.io.settings.Wrapper;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

public class GuiWalk
extends Module {
    public GuiWalk() {
        super("GuiWalk", "1", grozaclient.com.io.module.Category.Movement);
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        if (!(Wrapper.INSTANCE.mc().field_71462_r instanceof GuiContainer) && !(Wrapper.INSTANCE.mc().field_71462_r instanceof GuiScreen)) {
            return;
        }
        double speed = 0.05;
        if (!Wrapper.player().field_70122_E) {
            speed /= 4.0;
        }
        this.handleJump();
        this.handleForward(speed);
        if (!Wrapper.player().field_70122_E) {
            speed /= 2.0;
        }
        this.handleBack(speed);
        this.handleLeft(speed);
        this.handleRight(speed);
    }

    void moveForward(double speed) {
        float direction = Utils.getDirection();
        Wrapper.player().field_70159_w -= (double)MathHelper.func_76126_a((float)direction) * speed;
        Wrapper.player().field_70179_y += (double)MathHelper.func_76134_b((float)direction) * speed;
    }

    void moveBack(double speed) {
        float direction = Utils.getDirection;
        Wrapper.player().field_70159_w += (double)MathHelper.func_76126_a((float)direction) * speed;
        Wrapper.player().field_70179_y -= (double)MathHelper.func_76134_b((float)direction) * speed;
    }

    void moveLeft(double speed) {
        float direction = Utils.getDirection();
        Wrapper.player().field_70179_y += (double)MathHelper.func_76126_a((float)direction) * speed;
        Wrapper.player().field_70159_w += (double)MathHelper.func_76134_b((float)direction) * speed;
    }

    void moveRight(double speed) {
        float direction = Utils.getDirection();
        Wrapper.player().field_70179_y -= (double)MathHelper.func_76126_a((float)direction) * speed;
        Wrapper.player().field_70159_w -= (double)MathHelper.func_76134_b((float)direction) * speed;
    }

    void handleForward(double speed) {
        if (!Keyboard.isKeyDown((int)Wrapper.INSTANCE.mcSettings().field_74351_w.func_151463_i())) {
            return;
        }
        this.moveForward(speed);
    }

    void handleBack(double speed) {
        if (!Keyboard.isKeyDown((int)Wrapper.INSTANCE.mcSettings().field_74368_y.func_151463_i())) {
            return;
        }
        this.moveBack(speed);
    }

    void handleLeft(double speed) {
        if (!Keyboard.isKeyDown((int)Wrapper.INSTANCE.mcSettings().field_74370_x.func_151463_i())) {
            return;
        }
        this.moveLeft(speed);
    }

    void handleRight(double speed) {
        if (!Keyboard.isKeyDown((int)Wrapper.INSTANCE.mcSettings().field_74366_z.func_151463_i())) {
            return;
        }
        this.moveRight(speed);
    }

    void handleJump() {
        if (Wrapper.player().field_70122_E && Keyboard.isKeyDown((int)Wrapper.INSTANCE.mcSettings().field_74314_A.func_151463_i())) {
            Wrapper.player().func_70664_aZ();
        }
    }
}

