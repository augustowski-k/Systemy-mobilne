package proj.sm.systemymobilne;

import android.app.Activity;

/**
 * Created by augus on 11/8/2017.
 */

public class PreferencesRepositoryFactory {

    public static BasePreferenceRepository Create(PreferenceTypes type, Activity activity){
        switch (type){
            case Local:
                return new PreferencesRepository(activity);
            case DefaultShared:
                return new DefaultSharedPreferencesRepository(activity);
            case Shared:
                return new SharedPreferencesRepository(activity);
            default:
                return null;
        }
    }
}
