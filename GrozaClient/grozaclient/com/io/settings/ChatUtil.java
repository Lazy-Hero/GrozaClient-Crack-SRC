/*
 * Decompiled with CFR 0.150.
 * 
 * Could not load the following classes:
 *  net.minecraft.client.Minecraft
 *  net.minecraft.util.text.ITextComponent
 *  net.minecraft.util.text.TextComponentString
 */
package grozaclient.com.io.settings;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;

public class ChatUtil {
    public static void sendChatMessage(String string) {
        Minecraft.func_71410_x().field_71439_g.func_145747_a((ITextComponent)new TextComponentString("\u00a79Grozaclient: \u00a77" + string));
    }

    public static void error(String string) {
        Minecraft.func_71410_x().field_71439_g.func_145747_a((ITextComponent)new TextComponentString("\u00a78\u00a7l[\u00a73\u00a7lRage R8:\u00a78\u00a7l] \u00a7c\u00a7lERROR: \u00a7c" + string));
    }

    public static void info(String string) {
        Minecraft.func_71410_x().field_71439_g.func_145747_a((ITextComponent)new TextComponentString("\u00a78\u00a7l[\u00a73\u00a7lRage R8:\u00a78\u00a7l] \u00a7e" + string));
    }

    public static void warning(String string) {
        string = "Could not find empty slot. Operation has been aborted.";
        Minecraft.func_71410_x().field_71439_g.func_145747_a((ITextComponent)new TextComponentString("\u00a78\u00a7l[\u00a73\u00a7lRage R8:\u00a78\u00a7l] \u00a7b\u00a7lWARNING: \u00a7b" + string));
    }

    public static void clear(int n) {
        for (int i = 0; i < n; ++i) {
            Minecraft.func_71410_x().field_71439_g.func_145747_a((ITextComponent)new TextComponentString(""));
        }
    }

    public static void syntax(String string) {
        Minecraft.func_71410_x().field_71439_g.func_145747_a((ITextComponent)new TextComponentString("\u00a78\u00a7l[\u00a73\u00a7lRage R8:\u00a78\u00a7l] \u00a7a\u00a7lSYNTAX: \u00a7a" + string));
    }
}

