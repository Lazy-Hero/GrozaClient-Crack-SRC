/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.gui.Gui
 */
package grozaclient.com.io.clickgui.component.components.sub;

import grozaclient.com.io.clickgui.component.Component;
import grozaclient.com.io.clickgui.component.components.Button;
import grozaclient.com.io.settings.Settinga;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public class Checkbox
extends Component {
    private boolean hovered;
    private Settinga op;
    private Button parent;
    private int offset;
    private int x;
    private int y;

    public Checkbox(Settinga option, Button button, int offset) {
        this.op = option;
        this.parent = button;
        this.x = button.parent.getX() + button.parent.getWidth();
        this.y = button.parent.getY() + button.offset;
        this.offset = offset;
    }

    @Override
    public void renderComponent() {
        Gui.func_73734_a((int)(this.parent.parent.getX() + 2), (int)(this.parent.parent.getY() + this.offset), (int)(this.parent.parent.getX() + this.parent.parent.getWidth() * 1), (int)(this.parent.parent.getY() + this.offset + 12), (int)(this.hovered ? -14540254 : -15658735));
        Gui.func_73734_a((int)this.parent.parent.getX(), (int)(this.parent.parent.getY() + this.offset), (int)(this.parent.parent.getX() + 2), (int)(this.parent.parent.getY() + this.offset + 12), (int)-15658735);
        Minecraft.func_71410_x().field_71466_p.func_175063_a(this.op.getName(), (float)(this.parent.parent.getX() + 10 + 4), (float)(this.parent.parent.getY() + this.offset + 2), -1);
        Gui.func_73734_a((int)(this.parent.parent.getX() + 3 + 4), (int)(this.parent.parent.getY() + this.offset + 3), (int)(this.parent.parent.getX() + 9 + 4), (int)(this.parent.parent.getY() + this.offset + 9), (int)-6710887);
        if (this.op.getValBoolean()) {
            Gui.func_73734_a((int)(this.parent.parent.getX() + 4 + 4), (int)(this.parent.parent.getY() + this.offset + 4), (int)(this.parent.parent.getX() + 8 + 4), (int)(this.parent.parent.getY() + this.offset + 8), (int)-10066330);
        }
    }

    @Override
    public void setOff(int newOff) {
        this.offset = newOff;
    }

    @Override
    public void updateComponent(int mouseX, int mouseY) {
        this.hovered = this.isMouseOnButton(mouseX, mouseY);
        this.y = this.parent.parent.getY() + this.offset;
        this.x = this.parent.parent.getX();
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int button) {
        if (this.isMouseOnButton(mouseX, mouseY) && button == 0 && this.parent.open) {
            this.op.setValBoolean(!this.op.getValBoolean());
        }
    }

    public boolean isMouseOnButton(int x, int y) {
        return x > this.x && x < this.x + 88 && y > this.y && y < this.y + 12;
    }
}

