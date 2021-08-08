/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraftforge.common.MinecraftForge
 *  net.minecraftforge.fml.common.Mod
 *  net.minecraftforge.fml.common.Mod$EventHandler
 *  net.minecraftforge.fml.common.event.FMLInitializationEvent
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  net.minecraftforge.fml.common.gameevent.InputEvent$KeyInputEvent
 *  org.lwjgl.input.Keyboard
 */
package grozaclient.com.io;

import grozaclient.com.io.clickgui.component.ClickGui;
import grozaclient.com.io.module.Module;
import grozaclient.com.io.module.ModuleManager;
import grozaclient.com.io.settings.SettingsManager;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

@Mod(modid="groza", name="Groza_Client", version="1.5")
public class GrozaClient {
    public static final String MODID = "groza";
    public static final String NAME = "Groza_Client";
    public static final String VERSION = "1.5";
    public static GrozaClient instance;
    public static ModuleManager moduleManager;
    public SettingsManager settingsManager;
    public ClickGui clickGui;
    public SettingsManager setmgr;

    public void init() {
        MinecraftForge.EVENT_BUS.register((Object)this);
        this.settingsManager = new SettingsManager();
        moduleManager = new ModuleManager();
        this.clickGui = new ClickGui();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        instance = new GrozaClient();
        instance.init();
    }

    @SubscribeEvent
    public void key(InputEvent.KeyInputEvent e) {
        if (Minecraft.func_71410_x().field_71441_e == null || Minecraft.func_71410_x().field_71439_g == null) {
            return;
        }
        try {
            if (Keyboard.isCreated() && Keyboard.getEventKeyState()) {
                int keyCode = Keyboard.getEventKey();
                if (keyCode <= 0) {
                    return;
                }
                for (Module m : GrozaClient.moduleManager.modules) {
                    if (m.getKey() != keyCode || keyCode <= 0) continue;
                    m.toggle(false);
                }
            }
        }
        catch (Exception q) {
            q.printStackTrace();
        }
    }
}

