/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.gui.Gui
 */
package grozaclient.com.io.clickgui.component;

import grozaclient.com.io.GrozaClient;
import grozaclient.com.io.clickgui.component.Component;
import grozaclient.com.io.clickgui.component.components.Button;
import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import java.awt.Color;
import java.util.ArrayList;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;

public class Frame {
    public ArrayList<Component> components = new ArrayList();
    public Category category;
    private boolean open;
    private int width;
    private int y;
    private int x;
    private int barHeight;
    private boolean isDragging;
    public int dragX;
    public int dragY;

    public Frame(Category cat) {
        this.category = cat;
        this.width = 90;
        this.x = 5;
        this.y = 5;
        this.barHeight = 13;
        this.dragX = 0;
        this.open = true;
        this.isDragging = false;
        int tY = this.barHeight;
        GrozaClient instance = GrozaClient.instance;
        for (Module mod : GrozaClient.moduleManager.getModulesInCategory(this.category)) {
            Button modButton = new Button(mod, this, tY);
            this.components.add(modButton);
            tY += 12;
        }
    }

    public ArrayList<Component> getComponents() {
        return this.components;
    }

    public void setX(int newX) {
        this.x = newX;
    }

    public void setY(int newY) {
        this.y = newY;
    }

    public void setDrag(boolean drag) {
        this.isDragging = drag;
    }

    public boolean isOpen() {
        return this.open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public void renderFrame(FontRenderer fontRenderer) {
        Gui.func_73734_a((int)this.x, (int)this.y, (int)(this.x + this.width), (int)(this.y + this.barHeight), (int)new Color(56, 255, 197, 150).getRGB());
        fontRenderer.func_175063_a(this.category.name(), (float)(this.x + 2), (float)this.y + 2.5f, -1);
        fontRenderer.func_175063_a(this.open ? "-" : "+", (float)(this.x + this.width - 10), (float)this.y + 2.5f, -1);
        if (this.open && !this.components.isEmpty()) {
            Gui.func_73734_a((int)this.x, (int)(this.y + this.barHeight), (int)(this.x + 1), (int)(this.y + this.barHeight + 12 * this.components.size()), (int)new Color(42, 255, 222, 150).getRGB());
            Gui.func_73734_a((int)this.x, (int)(this.y + this.barHeight + 12 * this.components.size()), (int)(this.x + this.width), (int)(this.y + this.barHeight + 12 * this.components.size() + 1), (int)new Color(65, 255, 212, 150).getRGB());
            Gui.func_73734_a((int)(this.x + this.width), (int)(this.y + this.barHeight), (int)(this.x + this.width - 1), (int)(this.y + this.barHeight + 12 * this.components.size()), (int)new Color(60, 255, 231, 150).getRGB());
            for (Component component : this.components) {
                component.renderComponent();
            }
        }
    }

    public void refresh() {
        int off = this.barHeight;
        for (Component comp : this.components) {
            comp.setOff(off);
            off += comp.getHeight();
        }
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public int getWidth() {
        return this.width;
    }

    public void updatePosition(int mouseX, int mouseY) {
        if (this.isDragging) {
            this.setX(mouseX - this.dragX);
            this.setY(mouseY - this.dragY);
        }
    }

    public boolean isWithinHeader(int x, int y) {
        return x >= this.x && x <= this.x + this.width && y >= this.y && y <= this.y + this.barHeight;
    }
}

