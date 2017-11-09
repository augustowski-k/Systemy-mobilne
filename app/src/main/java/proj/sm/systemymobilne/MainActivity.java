package proj.sm.systemymobilne;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Debug;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

public class MainActivity extends AppCompatActivity {

    Button stopBtn, dodaj3Btn;
    TextView communicationLbl;

    PreferenceTypes prefType = PreferenceTypes.Shared;
    BasePreferenceRepository prefRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prefRepo = PreferencesRepositoryFactory.Create(prefType, this);

        stopBtn  = (Button)findViewById(R.id.stopBtn);
        dodaj3Btn = (Button)findViewById(R.id.dodaj3Btn);
        communicationLbl = (TextView)findViewById(R.id.communicatesLbl);

        stopBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View stopBtn) {
                finish();
            }
        });

        dodaj3Btn.setOnClickListener(dodaj3Clicked);

        showToast("created");
    }

    @Override
    protected void onResume(){
        super.onResume();
        showToast("resumed");
    }

    @Override
    protected void onStart(){
        super.onStart();
        showToast("started");
    }

    @Override
    protected void onPause(){
        super.onPause();
        showToast("paused");
    }

    @Override
    protected void onStop(){
        super.onStop();
        showToast("stopped");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        showToast("destroyed");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showToast(String text){
        Context context = getApplicationContext();
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    private View.OnClickListener dodaj3Clicked = new View.OnClickListener() {
        public void onClick(View dodaj3Btn) {
            int value = prefRepo.getInt("dane",Integer.MAX_VALUE);
            if (value == Integer.MAX_VALUE){
                value = 0;
                setIntPreference("dane",0);
            }else{
                setIntPreference("dane", value += 3);
            }
            showToast(Integer.toString(value));
        }
    };

    private void setIntPreference(String key, int value){
        prefRepo.setIntPreference(key, value);
    }

    private void removePreference(String key){
        prefRepo.removePreference(key);
    }
}
