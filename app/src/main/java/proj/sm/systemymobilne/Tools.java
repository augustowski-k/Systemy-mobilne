package proj.sm.systemymobilne;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by augus on 11/9/2017.
 */

public class Tools {
    public static void showToast(String text, Context context){
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }
}
