/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  akka.util.Index
 *  net.minecraft.client.Minecraft
 *  net.minecraft.network.Packet
 *  net.minecraft.util.ClassInheritanceMultiMap
 *  net.minecraftforge.common.MinecraftForge
 *  scala.reflect.runtime.Settings
 */
package grozaclient.com.io.module;

import akka.util.Index;
import grozaclient.com.io.module.Category;
import net.minecraft.client.Minecraft;
import net.minecraft.network.Packet;
import net.minecraft.util.ClassInheritanceMultiMap;
import net.minecraftforge.common.MinecraftForge;
import scala.reflect.runtime.Settings;

public class Module<ThreadLocalInsecureRandom> {
    public static Index<Object, Object> Category;
    protected static Minecraft mc;
    public int actived;
    protected ClassInheritanceMultiMap<Settings> settings;
    protected Object shalopay;
    protected ThreadLocalInsecureRandom e;
    private final String name;
    private String description;
    private int key;
    private Category category;
    private boolean toggled;
    public boolean visible = true;

    public Module(String name, String description, Category category) {
        this.name = name;
        this.description = description;
        this.key = 0;
        this.category = category;
        this.toggled = false;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getKey() {
        return this.key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public boolean isToggled() {
        return this.toggled;
    }

    public void setSuffix(String suffix) {
    }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;
        if (this.toggled) {
            this.onEnable();
        } else {
            this.onDisable();
        }
    }

    public void toggle(boolean b) {
        boolean bl = this.toggled = !this.toggled;
        if (this.toggled) {
            this.onEnable();
        } else {
            this.onDisable();
        }
    }

    public void onEnable() {
        MinecraftForge.EVENT_BUS.register((Object)this);
    }

    public void onDisable() {
        MinecraftForge.EVENT_BUS.unregister((Object)this);
    }

    public String getName() {
        return this.name;
    }

    public Category getCategory() {
        return this.category;
    }

    protected void perUpdate() {
    }

    protected void perDisable() {
    }

    protected void perToggle() {
    }

    protected float currentFloatValue(String range) {
        return 0.0f;
    }

    protected <NumberSetting, ModeSetting> void addSettings(NumberSetting speedSet, ModeSetting modeSetting) {
    }

    protected void perReadPacket(Packet readpacket) {
    }

    protected void setSkid(double v, double v1, double v2, float rotation) {
    }

    public boolean onRenderWorldLast(float f) {
        return false;
    }

    public double getBaseMoveSpeed() {
        return 0.0;
    }

    public void toggle() {
    }

    protected void perSentPacket(Packet packet) {
    }

    static {
        mc = Minecraft.func_71410_x();
    }
}

