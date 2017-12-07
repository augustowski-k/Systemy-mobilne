package proj.sm.systemymobilne.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import proj.sm.systemymobilne.R;
import proj.sm.systemymobilne.Tools;

public class ChildActivity extends AppCompatActivity {
    Button btnFinishChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child);

        btnFinishChild = (Button)findViewById(R.id.btnFinishChild);
        btnFinishChild.setOnClickListener(onChildFinishClickedListener);

        Tools.showToast("created", this);
    }

    @Override
    protected void onResume(){
        super.onResume();
        Tools.showToast("resumed", this);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Tools.showToast("started", this);
    }

    @Override
    protected void onPause(){
        super.onPause();
        Tools.showToast("paused", this);
    }

    @Override
    protected void onStop(){
        super.onStop();
        Tools.showToast("stopped", this);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Tools.showToast("destroyed", this);
    }

    private View.OnClickListener onChildFinishClickedListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Tools.showToast("finishing child", v.getContext());
            finish();
        }
    };
}
