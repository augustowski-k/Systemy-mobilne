package proj.sm.systemymobilne.Repositories.PreferenceRepositories;

import android.app.Activity;
import android.content.Context;

/**
 * Created by augus on 10/26/2017.
 */

public class PreferencesRepository extends BasePreferenceRepository {

    public PreferencesRepository(Activity activity){
        preferences =  activity.getPreferences(Context.MODE_PRIVATE);
    }
}
