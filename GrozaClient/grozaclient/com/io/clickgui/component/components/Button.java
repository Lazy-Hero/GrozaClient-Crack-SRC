/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Gui
 */
package grozaclient.com.io.clickgui.component.components;

import grozaclient.com.io.GrozaClient;
import grozaclient.com.io.clickgui.component.ClickGui;
import grozaclient.com.io.clickgui.component.Component;
import grozaclient.com.io.clickgui.component.Frame;
import grozaclient.com.io.clickgui.component.components.sub.Checkbox;
import grozaclient.com.io.clickgui.component.components.sub.Keybind;
import grozaclient.com.io.clickgui.component.components.sub.ModeButton;
import grozaclient.com.io.clickgui.component.components.sub.Slider;
import grozaclient.com.io.clickgui.component.components.sub.VisibleButton;
import grozaclient.com.io.module.Module;
import grozaclient.com.io.settings.Settinga;
import java.awt.Color;
import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public class Button
extends Component {
    public Module mod;
    public Frame parent;
    public int offset;
    private boolean isHovered;
    private ArrayList<Component> subcomponents;
    public boolean open;
    private int height;

    public Button(Module mod, Frame parent, int offset) {
        this.mod = mod;
        this.parent = parent;
        this.offset = offset;
        this.subcomponents = new ArrayList();
        this.open = false;
        this.height = 12;
        int opY = offset + 12;
        if (GrozaClient.instance.settingsManager.getSettingsByMod(mod) != null) {
            for (Settinga s : GrozaClient.instance.settingsManager.getSettingsByMod(mod)) {
                if (s.isCombo()) {
                    this.subcomponents.add(new ModeButton(s, this, mod, opY));
                    opY += 12;
                }
                if (s.isSlider()) {
                    this.subcomponents.add(new Slider(s, this, opY));
                    opY += 12;
                }
                if (!s.isCheck()) continue;
                this.subcomponents.add(new Checkbox(s, this, opY));
                opY += 12;
            }
        }
        this.subcomponents.add(new Keybind(this, opY));
        this.subcomponents.add(new VisibleButton(this, mod, opY));
    }

    @Override
    public void setOff(int newOff) {
        this.offset = newOff;
        int opY = this.offset + 12;
        for (Component comp : this.subcomponents) {
            comp.setOff(opY);
            opY += 12;
        }
    }

    @Override
    public void renderComponent() {
        Gui.func_73734_a((int)this.parent.getX(), (int)(this.parent.getY() + this.offset), (int)(this.parent.getX() + this.parent.getWidth()), (int)(this.parent.getY() + 12 + this.offset), (int)(this.isHovered ? (this.mod.isToggled() ? new Color(0, 239, 100, 150).getRGB() : new Color(0, 239, 220, 150).getRGB()) : (this.mod.isToggled() ? new Color(14, 14, 14, 150).getRGB() : new Color(14, 14, 14, 150).getRGB())));
        Minecraft.func_71410_x().field_71466_p.func_175063_a(this.mod.getName(), (float)(this.parent.getX() + 2), (float)(this.parent.getY() + this.offset + 2), this.mod.isToggled() ? new Color(0, 239, 220).getRGB() : -1);
        if (this.subcomponents.size() > 2) {
            Minecraft.func_71410_x().field_71466_p.func_175063_a(this.open ? "<" : ">", (float)(this.parent.getX() + this.parent.getWidth() - 10), (float)(this.parent.getY() + this.offset + 2), -1);
        }
        if (this.open && !this.subcomponents.isEmpty()) {
            for (Component comp : this.subcomponents) {
                comp.renderComponent();
            }
            Gui.func_73734_a((int)(this.parent.getX() + 2), (int)(this.parent.getY() + this.offset + 12), (int)(this.parent.getX() + 3), (int)(this.parent.getY() + this.offset + (this.subcomponents.size() + 1) * 12), (int)ClickGui.color);
        }
    }

    @Override
    public int getHeight() {
        if (this.open) {
            return 12 * (this.subcomponents.size() + 1);
        }
        return 12;
    }

    @Override
    public void updateComponent(int mouseX, int mouseY) {
        this.isHovered = this.isMouseOnButton(mouseX, mouseY);
        if (!this.subcomponents.isEmpty()) {
            for (Component comp : this.subcomponents) {
                comp.updateComponent(mouseX, mouseY);
            }
        }
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {
        if (this.isMouseOnButton(mouseX, mouseY) && button == 0) {
            this.mod.toggle(false);
        }
        if (this.isMouseOnButton(mouseX, mouseY) && button == 1) {
            this.open = !this.open;
            this.parent.refresh();
        }
        for (Component comp : this.subcomponents) {
            comp.mouseClicked(mouseX, mouseY, button);
        }
    }

    @Override
    public void mouseReleased(int mouseX, int mouseY, int mouseButton) {
        for (Component comp : this.subcomponents) {
            comp.mouseReleased(mouseX, mouseY, mouseButton);
        }
    }

    @Override
    public void keyTyped(char typedChar, int key) {
        for (Component comp : this.subcomponents) {
            comp.keyTyped(typedChar, key);
        }
    }

    public boolean isMouseOnButton(int x, int y) {
        return x > this.parent.getX() && x < this.parent.getX() + this.parent.getWidth() && y > this.parent.getY() + this.offset && y < this.parent.getY() + 12 + this.offset;
    }
}

