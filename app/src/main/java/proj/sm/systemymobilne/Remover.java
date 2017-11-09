package proj.sm.systemymobilne;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Remover extends AppCompatActivity {
    Button rmDataBtn;
    PreferenceTypes prefType = PreferenceTypes.Shared;
    BasePreferenceRepository prefRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remover);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        prefRepo = PreferencesRepositoryFactory.Create(prefType,this);

        rmDataBtn = (Button)findViewById(R.id.removeData);
        rmDataBtn.setOnClickListener(rmDataClicked);
    }

    private void showToast(String text){
        Context context = getApplicationContext();
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    private View.OnClickListener rmDataClicked = new View.OnClickListener() {
        public void onClick(View odejmij3Btn) {
            boolean wasPresent = prefRepo.removePreference("dane");
            if(wasPresent){
                showToast("Dane zostaly usuniete");
            }else{
                showToast("nie było żadnych danych");
            }
            finish();
        }
    };
}
