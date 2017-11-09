package proj.sm.systemymobilne.Repositories;

import android.app.Activity;
import android.preference.PreferenceManager;

import proj.sm.systemymobilne.Repositories.BasePreferenceRepository;

/**
 * Created by augus on 11/8/2017.
 */

public class DefaultSharedPreferencesRepository extends BasePreferenceRepository {

    public DefaultSharedPreferencesRepository(Activity activity){
        preferences = PreferenceManager.getDefaultSharedPreferences(activity.getApplicationContext());
    }
}
