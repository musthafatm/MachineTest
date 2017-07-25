package com.whirlwind.iroid.mtactivity.storage;

import android.content.Context;

/**
 * Created by Acer on 25-Jul-17.
 */

public class AppstorageFactory {

    private static final String USER_NAME = "username";
    private static final String PASSWORD = "password";
    private static final String IS_USER_LOGGED = "is_user_logged";

    public static void insertUsername(String username, Context context) {
        AppStorage.insertString(USER_NAME, username, context);

    }

    public static void insertPassword(String password, Context context) {
        AppStorage.insertString(PASSWORD, password, context);
    }

    public static void setUserLogged(boolean isUserLogged, Context context) {
        AppStorage.insertBoolean(IS_USER_LOGGED, isUserLogged, context);
    }

    public static boolean isUserLogged(Context context) {
        return AppStorage.getBoolean(IS_USER_LOGGED, context);
    }

    public static String getUsername(Context context) {
        return AppStorage.getString(USER_NAME, context);
    }

    public static String getPassword(Context context) {
        return AppStorage.getString(PASSWORD, context);
    }

    public static void clearAll(Context context) {
        AppStorage.clearAll(context);
    }
}
