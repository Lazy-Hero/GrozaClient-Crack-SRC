/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  com.sun.jna.platform.mac.MacFileUtils$FileManager
 *  net.minecraft.block.Block
 *  net.minecraft.client.Minecraft
 *  net.minecraft.client.entity.EntityPlayerSP
 *  net.minecraft.client.gui.FontRenderer
 *  net.minecraft.client.multiplayer.PlayerControllerMP
 *  net.minecraft.client.multiplayer.WorldClient
 *  net.minecraft.client.settings.GameSettings
 *  net.minecraft.entity.Entity
 *  net.minecraft.entity.player.InventoryPlayer
 *  net.minecraft.network.Packet
 *  net.minecraft.network.play.client.CPacketAnimation
 *  net.minecraft.network.play.client.CPacketPlayer
 *  net.minecraft.util.math.BlockPos
 *  net.minecraft.world.World
 */
package grozaclient.com.io.settings;

import com.sun.jna.platform.mac.MacFileUtils;
import java.lang.reflect.Field;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.network.Packet;
import net.minecraft.network.play.client.CPacketAnimation;
import net.minecraft.network.play.client.CPacketPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Wrapper {
    private static Wrapper theWrapper = new Wrapper();
    public static Minecraft mc = Minecraft.func_71410_x();
    public static volatile Wrapper INSTANCE = new Wrapper();
    public static FontRenderer fr = Minecraft.func_71410_x().field_71466_p;
    public static MacFileUtils.FileManager fileManager;

    public static Wrapper getInstance() {
        return theWrapper;
    }

    public static float getCooldown() {
        return Wrapper.mc.field_71439_g.func_184825_o(0.0f);
    }

    public static MacFileUtils.FileManager getFileManager() {
        if (fileManager == null) {
            // empty if block
        }
        return fileManager;
    }

    public static Entity getRenderEntity() {
        return mc.func_175606_aa();
    }

    public static Block getBlock(BlockPos pos) {
        return Minecraft.func_71410_x().field_71441_e.func_180495_p(pos).func_177230_c();
    }

    public static Minecraft getMinecraft() {
        return Minecraft.func_71410_x();
    }

    public static EntityPlayerSP getPlayer() {
        return Wrapper.getMinecraft().field_71439_g;
    }

    public static World getWorld() {
        return Wrapper.getMinecraft().field_71441_e;
    }

    public static <T, E> void setPrivateValue(Class<? super T> classToAccess, T instance, E value, String ... fieldNames) {
        try {
            Wrapper.findField(classToAccess, fieldNames).set(instance, value);
        }
        catch (Exception exception) {
            // empty catch block
        }
    }

    private static Field findField(Class<?> clazz, String ... fieldNames) {
        Exception failed = null;
        for (String fieldName : fieldNames) {
            try {
                Field f = clazz.getDeclaredField(fieldName);
                f.setAccessible(true);
                return f;
            }
            catch (Exception e) {
                failed = e;
            }
        }
        return null;
    }

    public Minecraft mc() {
        return Minecraft.func_71410_x();
    }

    public static EntityPlayerSP player() {
        return Wrapper.INSTANCE.mc().field_71439_g;
    }

    public WorldClient world() {
        return Wrapper.INSTANCE.mc().field_71441_e;
    }

    public GameSettings mcSettings() {
        return Wrapper.INSTANCE.mc().field_71474_y;
    }

    public FontRenderer fontRenderer() {
        return Wrapper.INSTANCE.mc().field_71466_p;
    }

    public void sendPacket(CPacketAnimation cPacketAnimation) {
        Wrapper.player().field_71174_a.func_147297_a((Packet)cPacketAnimation);
    }

    public InventoryPlayer inventory() {
        return Wrapper.player().field_71071_by;
    }

    public PlayerControllerMP controller() {
        return Wrapper.INSTANCE.mc().field_71442_b;
    }

    public void sendPacket(CPacketPlayer cPacketPlayer) {
    }
}

