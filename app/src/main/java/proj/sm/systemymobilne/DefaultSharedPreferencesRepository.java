package proj.sm.systemymobilne;

import android.app.Activity;
import android.app.Application;
import android.preference.PreferenceManager;

/**
 * Created by augus on 11/8/2017.
 */

public class DefaultSharedPreferencesRepository extends BasePreferenceRepository {

    public DefaultSharedPreferencesRepository(Activity activity){
        preferences = PreferenceManager.getDefaultSharedPreferences(activity.getApplicationContext());
    }
}
