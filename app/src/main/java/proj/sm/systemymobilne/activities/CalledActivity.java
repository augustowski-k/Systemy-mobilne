package proj.sm.systemymobilne.activities;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import proj.sm.systemymobilne.IIntentAlertListener;
import proj.sm.systemymobilne.IntentAlertDialogFacade;
import proj.sm.systemymobilne.R;
import proj.sm.systemymobilne.Tools;

public class CalledActivity extends AppCompatActivity implements IIntentAlertListener {
    EditText edtCalledFirstNum, edtCalledSecondNum;
    IntentAlertDialogFacade intentDialogFacade;
    Intent returnIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_called);

        edtCalledFirstNum = (EditText)findViewById(R.id.edtCalledFirstNum);
        edtCalledSecondNum = (EditText)findViewById(R.id.edtCalledSecondNum);
        edtCalledSecondNum.setOnEditorActionListener(secondStringEditorActionListener);
    }

    private TextView.OnEditorActionListener secondStringEditorActionListener= new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if (actionId == EditorInfo.IME_ACTION_GO){
                EditTextFilled();
                return true;
            }
            return false;
        }
    };

    private void EditTextFilled(){
        returnIntent = new Intent();
        intentDialogFacade = new IntentAlertDialogFacade(this);
        intentDialogFacade.setListener(this);
        intentDialogFacade.create();
        intentDialogFacade.display();
    }

    @Override
    public void OnAlertDecision() {
        if(intentDialogFacade.getStatus() == IntentAlertDialogFacade.Status.accepted){
            setResult(Activity.RESULT_OK,returnIntent);
            Tools.showToast(edtCalledFirstNum.getText() + "/" + edtCalledSecondNum.getText(), this);
        }
        if(intentDialogFacade.getStatus() == IntentAlertDialogFacade.Status.discarded){
            setResult(Integer.MAX_VALUE);
        }
        if(intentDialogFacade.getStatus() == IntentAlertDialogFacade.Status.canceled){
            setResult(Activity.RESULT_CANCELED);
        }
        finish();
    }
}
