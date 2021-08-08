/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.client.event.RenderGameOverlayEvent$Text
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 */
package grozaclient.com.io.module.gui;

import grozaclient.com.io.GrozaClient;
import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import grozaclient.com.io.settings.RenderUtils;
import grozaclient.com.io.settings.Settinga;
import java.awt.Color;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Keystrokes
extends Module {
    public int color;
    public Settinga keyX;
    public Settinga keyY;
    public Settinga mouseButtons;

    public static Color rainbow(int speed, int r, float wh) {
        float hex = (System.currentTimeMillis() + (long)r) % (long)speed;
        return Color.getHSBColor(hex / (float)speed, wh, 1.0f);
    }

    public Keystrokes() {
        super("Keystrokes", "", grozaclient.com.io.module.Category.Gui);
        GrozaClient.instance.settingsManager.rSetting(new Settinga("X", this, 90.0, -1000.0, 2000.0, true));
        GrozaClient.instance.settingsManager.rSetting(new Settinga("Y", this, 90.0, -1000.0, 2000.0, true));
    }

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Text e) {
        if (!Keystrokes.mc.field_71474_y.field_74330_P) {
            int x = (int)GrozaClient.instance.settingsManager.getSettingByName(this, "X").getValDouble();
            int y = (int)GrozaClient.instance.settingsManager.getSettingByName(this, "Y").getValDouble();
            this.color = new Color(51, 51, 51, 255).getRGB();
            RenderUtils.drawRect(x + 20, y + 111, x + 41, y + 130, -1879048192);
            RenderUtils.drawRect(x + 1, y + 130, x + 61, y + 150, -1879048192);
            if (Keystrokes.mc.field_71474_y.field_74351_w.func_151470_d()) {
                RenderUtils.drawRect(x + 21, y + 112, x + 40, y + 130, this.color);
            }
            if (Keystrokes.mc.field_71474_y.field_74368_y.func_151470_d()) {
                RenderUtils.drawRect(x + 21, y + 131, x + 40, y + 149, this.color);
            }
            if (Keystrokes.mc.field_71474_y.field_74370_x.func_151470_d()) {
                RenderUtils.drawRect(x + 2, y + 131, x + 20, y + 149, this.color);
            }
            if (Keystrokes.mc.field_71474_y.field_74366_z.func_151470_d()) {
                RenderUtils.drawRect(x + 41, y + 131, x + 60, y + 149, this.color);
            }
            RenderUtils.drawRect(x + 30, y + 170, x + 61, y + 150, -1879048192);
            RenderUtils.drawRect(x + 1, y + 170, x + 30, y + 150, -1879048192);
            if (Keystrokes.mc.field_71474_y.field_74312_F.func_151470_d()) {
                RenderUtils.drawRect(x + 2, y + 150, x + 30, y + 169, this.color);
            }
            if (Keystrokes.mc.field_71474_y.field_74313_G.func_151470_d()) {
                RenderUtils.drawRect(x + 60, y + 150, x + 31, y + 169, this.color);
            }
            Keystrokes.mc.field_71466_p.func_78276_b("LMB", x + 7, y + 156, -1);
            Keystrokes.mc.field_71466_p.func_78276_b("RMB", x + 37, y + 156, -1);
            Keystrokes.mc.field_71466_p.func_78276_b("W", x + 28, y + 117, -1);
            Keystrokes.mc.field_71466_p.func_78276_b("A", x + 8, y + 136, -1);
            Keystrokes.mc.field_71466_p.func_78276_b("S", x + 28, y + 136, -1);
            Keystrokes.mc.field_71466_p.func_78276_b("D", x + 48, y + 136, -1);
        }
    }
}

