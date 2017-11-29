package proj.sm.systemymobilne.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import proj.sm.systemymobilne.R;
import proj.sm.systemymobilne.Tools;

public class TextEditActivity extends Activity {
    private EditText edtDate, edtPhone, edtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_edit);
        edtDate = (EditText)findViewById(R.id.edtDate);
        edtName = (EditText)findViewById(R.id.edtName);
        edtPhone = (EditText)findViewById(R.id.edtPhone);

        edtPhone.setOnEditorActionListener(goEditActionListener);
    }

    private TextView.OnEditorActionListener goEditActionListener = new TextView.OnEditorActionListener() {
        @Override
        public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
            if(actionId == EditorInfo.IME_ACTION_GO){
                Tools.showToast("It's " + edtDate.getText().toString() + " better call " + edtName.getText().toString() + " on following number: " + edtPhone.getText().toString(),v.getContext());
                return true;
            }
            return false;
        }
    };
}
