package proj.sm.systemymobilne.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import proj.sm.systemymobilne.R;

public class CalledActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_called);

        Intent returnIntent = new Intent();
        returnIntent.putExtra("zwrot","zwrocono mnie");
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
}
