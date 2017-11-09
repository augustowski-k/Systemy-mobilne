package proj.sm.systemymobilne.Repositories;

import android.app.Activity;
import android.content.Context;

import proj.sm.systemymobilne.Repositories.BasePreferenceRepository;

/**
 * Created by augus on 10/26/2017.
 */

public class PreferencesRepository extends BasePreferenceRepository {

    public PreferencesRepository(Activity activity){
        preferences =  activity.getPreferences(Context.MODE_PRIVATE);
    }
}
