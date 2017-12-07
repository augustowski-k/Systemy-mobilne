package proj.sm.systemymobilne.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import proj.sm.systemymobilne.R;

public class MotherActivity extends AppCompatActivity {
    Button btnInvokeChildActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mother);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        btnInvokeChildActivity = (Button)findViewById(R.id.btnChildActivityInvoke);
        btnInvokeChildActivity.setOnClickListener(invokeChildActivityClickListener);
    }

    private View.OnClickListener invokeChildActivityClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(v.getContext(), ChildActivity.class);
            startActivity(intent);
        }
    };
}

