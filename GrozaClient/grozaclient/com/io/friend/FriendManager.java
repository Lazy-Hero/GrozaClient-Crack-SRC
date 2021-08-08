/*
 * Decompiled with CFR 0.150.
 */
package grozaclient.com.io.friend;

import grozaclient.com.io.friend.Friend;
import java.util.ArrayList;

public class FriendManager {
    public static ArrayList friends = new ArrayList();

    public static Friend getFriend(String string) {
        for (Object friendw : friends) {
            Friend friend = (Friend)friendw;
            if (!friend.name.equalsIgnoreCase(string)) continue;
            return friend;
        }
        return null;
    }

    public static void removeFriend(String string) {
        if (FriendManager.getFriend(string) != null) {
            friends.remove(FriendManager.getFriend(string));
        }
    }

    public static boolean isFriend(String string) {
        return FriendManager.getFriend(string) != null;
    }

    public static void addFriend(String string, String string2) {
        friends.add(new Friend(string, string2));
    }
}

