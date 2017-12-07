package proj.sm.systemymobilne.Repositories.PreferenceRepositories;

import android.app.Activity;
import android.content.Context;

/**
 * Created by augus on 11/8/2017.
 */

public class SharedPreferencesRepository extends BasePreferenceRepository {

    public SharedPreferencesRepository(Activity activity){
        preferences = activity.getSharedPreferences("Base", Context.MODE_PRIVATE);
    }
}
