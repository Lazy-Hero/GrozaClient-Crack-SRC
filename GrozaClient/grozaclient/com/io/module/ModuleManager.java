/*
 * Decompiled with CFR 0.150.
 */
package grozaclient.com.io.module;

import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import grozaclient.com.io.module.combat.AntiBot;
import grozaclient.com.io.module.combat.AuraTest;
import grozaclient.com.io.module.combat.AutoTotem;
import grozaclient.com.io.module.combat.HitBox;
import grozaclient.com.io.module.combat.KillAura;
import grozaclient.com.io.module.combat.TargetStrafe;
import grozaclient.com.io.module.combat.TriggerBot;
import grozaclient.com.io.module.combat.Velocity;
import grozaclient.com.io.module.combat.wTap;
import grozaclient.com.io.module.gui.ClickGUI;
import grozaclient.com.io.module.gui.HUD;
import grozaclient.com.io.module.gui.Keystrokes;
import grozaclient.com.io.module.gui.Logo;
import grozaclient.com.io.module.gui.OldLogo;
import grozaclient.com.io.module.gui.PlayerHud;
import grozaclient.com.io.module.misc.AutoRespawn;
import grozaclient.com.io.module.misc.BowSpam;
import grozaclient.com.io.module.misc.KTLeave;
import grozaclient.com.io.module.misc.MCF;
import grozaclient.com.io.module.misc.NoClip;
import grozaclient.com.io.module.misc.NoPush;
import grozaclient.com.io.module.movement.AirJump;
import grozaclient.com.io.module.movement.AutoWalkShift;
import grozaclient.com.io.module.movement.Fly;
import grozaclient.com.io.module.movement.GuiWalk;
import grozaclient.com.io.module.movement.Jesus;
import grozaclient.com.io.module.movement.NoJumpDelay;
import grozaclient.com.io.module.movement.NoSlowDown;
import grozaclient.com.io.module.movement.Speed;
import grozaclient.com.io.module.movement.Spider;
import grozaclient.com.io.module.movement.Sprint;
import grozaclient.com.io.module.movement.Strafe;
import grozaclient.com.io.module.movement.WaterJump;
import grozaclient.com.io.module.player.Blink;
import grozaclient.com.io.module.player.NoFall;
import grozaclient.com.io.module.player.Test;
import grozaclient.com.io.module.player.Tracers;
import grozaclient.com.io.module.render.AntiFire;
import grozaclient.com.io.module.render.Esp;
import grozaclient.com.io.module.render.ItemESP;
import grozaclient.com.io.module.render.NoHurtCam;
import grozaclient.com.io.module.render.NoRender;
import grozaclient.com.io.module.render.PenisESP;
import grozaclient.com.io.module.render.PlayerESP;
import grozaclient.com.io.module.render.TwoDMode;
import grozaclient.com.io.module.render.ViewModel;
import grozaclient.com.io.module.render.WallHack;
import java.util.ArrayList;

public class ModuleManager {
    public ArrayList<Module> modules = new ArrayList();

    public ModuleManager() {
        this.modules.clear();
        this.modules.add(new ClickGUI());
        this.modules.add(new MCF());
        this.modules.add(new AutoWalkShift());
        this.modules.add(new TargetStrafe());
        this.modules.add(new Speed());
        this.modules.add(new AuraTest());
        this.modules.add(new NoJumpDelay());
        this.modules.add(new AutoRespawn());
        this.modules.add(new NoSlowDown());
        this.modules.add(new TriggerBot());
        this.modules.add(new Keystrokes());
        this.modules.add(new NoHurtCam());
        this.modules.add(new PlayerHud());
        this.modules.add(new AutoTotem());
        this.modules.add(new WaterJump());
        this.modules.add(new ViewModel());
        this.modules.add(new NoClip());
        this.modules.add(new PlayerESP());
        this.modules.add(new WallHack());
        this.modules.add(new Velocity());
        this.modules.add(new TwoDMode());
        this.modules.add(new NoRender());
        this.modules.add(new PenisESP());
        this.modules.add(new Esp());
        this.modules.add(new ItemESP());
        this.modules.add(new Tracers());
        this.modules.add(new AirJump());
        this.modules.add(new KTLeave());
        this.modules.add(new OldLogo());
        this.modules.add(new BowSpam());
        this.modules.add(new KillAura());
        this.modules.add(new AntiBot());
        this.modules.add(new AntiFire());
        this.modules.add(new NoFall());
        this.modules.add(new Sprint());
        this.modules.add(new Strafe());
        this.modules.add(new Spider());
        this.modules.add(new HitBox());
        this.modules.add(new NoPush());
        this.modules.add(new Jesus());
        this.modules.add(new Blink());
        this.modules.add(new Logo());
        this.modules.add(new wTap());
        this.modules.add(new Test());
        this.modules.add(new HUD());
        this.modules.add(new Fly());
        this.modules.add(new GuiWalk());
    }

    public Module getModule(Class<AuraTest> name) {
        for (Module m : this.modules) {
            if (!m.getName().equalsIgnoreCase(String.valueOf(name))) continue;
            return m;
        }
        return null;
    }

    public ArrayList<Module> getModuleList() {
        return this.modules;
    }

    public ArrayList<Module> getModulesInCategory(Category c) {
        ArrayList<Module> mods = new ArrayList<Module>();
        for (Module m : this.modules) {
            if (m.getCategory() != c) continue;
            mods.add(m);
        }
        return mods;
    }
}

