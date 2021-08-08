/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraftforge.client.event.RenderPlayerEvent$Post
 *  net.minecraftforge.client.event.RenderPlayerEvent$Pre
 *  net.minecraftforge.fml.common.eventhandler.SubscribeEvent
 *  org.lwjgl.opengl.GL11
 */
package grozaclient.com.io.module.render;

import grozaclient.com.io.module.Category;
import grozaclient.com.io.module.Module;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class WallHack
extends Module {
    public WallHack() {
        super("WallHack", "", grozaclient.com.io.module.Category.Exploit);
    }

    @SubscribeEvent
    public void onRenderEntityPre(RenderPlayerEvent.Pre pre) {
        GL11.glEnable((int)32823);
        GL11.glPolygonOffset((float)1.0f, (float)-1100000.0f);
        GL11.glDisable((int)2896);
    }

    @SubscribeEvent
    public void onRenderEntityPost(RenderPlayerEvent.Post post) {
        GL11.glDisable((int)32823);
        GL11.glPolygonOffset((float)1.0f, (float)1100000.0f);
        GL11.glEnable((int)2896);
    }
}

