package proj.sm.systemymobilne.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import proj.sm.systemymobilne.R;
import proj.sm.systemymobilne.Tools;

public class CallingActivity extends AppCompatActivity {
    Button btnGetNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calling);

        btnGetNumber = (Button)findViewById(R.id.btnGetNumber);
        btnGetNumber.setOnClickListener(getNumberClickListener);
    }

    private View.OnClickListener getNumberClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent getNumberIntent = new Intent(v.getContext(), CalledActivity.class);
            startActivityForResult(getNumberIntent, 1);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == Activity.RESULT_OK){
            Tools.showToast("zaakceptowane", this);
            finish();
        }
        else if(resultCode == Activity.RESULT_CANCELED){
            Tools.showToast("koniec",this);
            finish();
        }else if(resultCode == Integer.MAX_VALUE){
            Tools.showToast("Ponow", this);
        }
    }
}
