package proj.sm.systemymobilne;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

/**
 * Created by augus on 10/26/2017.
 */

public class PreferencesRepository extends BasePreferenceRepository{

    public PreferencesRepository(Activity activity){
        preferences =  activity.getPreferences(Context.MODE_PRIVATE);
    }
}
