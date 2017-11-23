package proj.sm.systemymobilne.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import proj.sm.systemymobilne.ExitAlertDialogFacade;
import proj.sm.systemymobilne.R;

public class AlertActivity extends Activity {
    Button btnExit;
    ExitAlertDialogFacade exitDialogFacade;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
        btnExit = (Button)findViewById(R.id.btnExit);

        btnExit.setOnClickListener(BtnExitClickedListener);

    }

    private View.OnClickListener BtnExitClickedListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showExitAlert();
        }
    };

    private void showExitAlert(){
        exitDialogFacade = new ExitAlertDialogFacade(this);
        exitDialogFacade.create();
        exitDialogFacade.display();
    }
}
