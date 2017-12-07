package proj.sm.systemymobilne.Repositories.PreferenceRepositories;

import android.content.SharedPreferences;

/**
 * Created by augus on 11/8/2017.
 */

public abstract class BasePreferenceRepository {
    protected SharedPreferences preferences;

    public int getInt(String name, int defaultVal){
        return preferences.getInt(name, defaultVal);
    }

    public void setIntPreference(String key, int value){
        SharedPreferences.Editor preferencesEditor = preferences.edit();

        preferencesEditor.putInt(key, value);
        preferencesEditor.apply();
    }

    public boolean removePreference(String key){
        SharedPreferences.Editor preferencesEditor = preferences.edit();

        if(preferences.contains(key)){
            preferencesEditor.remove(key);
            preferencesEditor.apply();
            return true;
        }
        return false;
    }
}
