/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.GuiScreen
 */
package grozaclient.com.io.module.gui;

import grozaclient.com.io.GrozaClient;
import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import net.minecraft.client.gui.GuiScreen;

public class ClickGUI
extends Module {
    public ClickGUI() {
        super("ClickGUI", "", grozaclient.com.io.module.Category.Gui);
        this.setKey(54);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        mc.func_147108_a((GuiScreen)GrozaClient.instance.clickGui);
        this.setToggled(false);
    }
}

