package com.whirlwind.iroid.mtactivity.storage;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Acer on 25-Jul-17.
 */

public class AppStorage {

    private static final String APP_STORAGE = "app_storage";

    public static void insertString(String key, String value, Context context) {
        SharedPreferences.Editor edit = createSharedPreferences(context).edit();
        edit.putString(key, value).apply();
    }

    public static void insertBoolean(String key, boolean value, Context context) {
        createSharedPreferences(context).edit().putBoolean(key, value).apply();
    }


    private static SharedPreferences createSharedPreferences(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(APP_STORAGE, Context.MODE_PRIVATE);
        return sharedPreferences;
    }

    public static boolean getBoolean(String key, Context context) {
        return createSharedPreferences(context).getBoolean(key, false);
    }


    public static String getString(String key, Context context) {
        return createSharedPreferences(context).getString(key, "");
    }

    public static void clearAll(Context context) {
        createSharedPreferences(context).edit().clear().apply();
    }
}
