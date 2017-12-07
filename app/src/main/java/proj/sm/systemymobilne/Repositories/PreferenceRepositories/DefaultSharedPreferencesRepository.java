package proj.sm.systemymobilne.Repositories.PreferenceRepositories;

import android.app.Activity;
import android.preference.PreferenceManager;

/**
 * Created by augus on 11/8/2017.
 */

public class DefaultSharedPreferencesRepository extends BasePreferenceRepository {

    public DefaultSharedPreferencesRepository(Activity activity){
        preferences = PreferenceManager.getDefaultSharedPreferences(activity.getApplicationContext());
    }
}
