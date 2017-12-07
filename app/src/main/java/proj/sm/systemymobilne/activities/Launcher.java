package proj.sm.systemymobilne.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import proj.sm.systemymobilne.PreferenceTypes;
import proj.sm.systemymobilne.R;
import proj.sm.systemymobilne.Repositories.PreferenceRepositories.BasePreferenceRepository;
import proj.sm.systemymobilne.Repositories.PreferenceRepositories.PreferencesRepositoryFactory;

public class Launcher extends Activity {

    Button odejmij3Btn, stopBtn;
    private PreferenceTypes prefType = PreferenceTypes.Shared;
    private BasePreferenceRepository prefRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        prefRepo = PreferencesRepositoryFactory.Create(prefType, this);

        stopBtn  = (Button)findViewById(R.id.launcerStopBtn);
        odejmij3Btn = (Button)findViewById(R.id.odejmij3Btn);

        stopBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View stopBtn) {
                finish();
            }
        });

        odejmij3Btn.setOnClickListener(odejmij3Clicked);
    }

    private void showToast(String text){
        Context context = getApplicationContext();
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    private View.OnClickListener odejmij3Clicked = new View.OnClickListener() {
        public void onClick(View odejmij3Btn) {
            int value = prefRepo.getInt("dane", Integer.MAX_VALUE);
            if (value == Integer.MAX_VALUE){
                value = 0;
                setIntPreference("dane",value);
            }else{
                setIntPreference("dane", value -= 3);
            }
            showToast(Integer.toString(value));
        }
    };

    private void setIntPreference(String key, int value){
        prefRepo.setIntPreference(key,value);
    }

    private void removePreference(String key){
        prefRepo.removePreference(key);
    }
}
