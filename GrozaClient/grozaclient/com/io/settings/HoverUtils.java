/*
 * Decompiled with CFR 0.150.
 */
package grozaclient.com.io.settings;

public class HoverUtils {
    public static boolean isHovered(int x, int y, int width, int height, int mouseX, int mouseY) {
        return mouseX > x && mouseY > y && mouseX < width && mouseY < height;
    }
}

