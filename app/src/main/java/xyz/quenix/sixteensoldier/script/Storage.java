package xyz.quenix.sixteensoldier.script;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

public class Storage {
    public static void saveData(Context context, String key, String value){
        SharedPreferences sPref = PreferenceManager.getDefaultSharedPreferences(context);
        Editor ed = sPref.edit();
        ed.putString(key, value);
        ed.commit();
    }
    
    public static String loadData(Context context, String key){
        SharedPreferences sPref = PreferenceManager.getDefaultSharedPreferences(context);
        String loadScores = sPref.getString(key, "");
        return loadScores;
    }
}
