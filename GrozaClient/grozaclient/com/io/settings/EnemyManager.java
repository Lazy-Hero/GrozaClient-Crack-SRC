/*
 * Decompiled with CFR 0.150.
 */
package grozaclient.com.io.settings;

import java.util.ArrayList;

public class EnemyManager {
    public static ArrayList<String> enemysList = new ArrayList();
    public static ArrayList<String> murders = new ArrayList();
    public static ArrayList<String> detects = new ArrayList();

    public static void addEnemy(String enemyname) {
        if (!enemysList.contains(enemyname)) {
            enemysList.add(enemyname);
        }
    }

    public static void removeEnemy(String enemyname) {
        if (enemysList.contains(enemyname)) {
            enemysList.remove(enemyname);
        }
    }

    public static void clear() {
        if (!enemysList.isEmpty()) {
            enemysList.clear();
        }
    }
}

