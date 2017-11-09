package proj.sm.systemymobilne;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class CofeeActivity extends AppCompatActivity {
    TextView cofeeTV;
    RadioGroup drinkRG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cofee);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //cofeeCB.setOnCheckedChangeListener(cofeeOnCheckedChanged);

        drinkRG = (RadioGroup)findViewById(R.id.dringRG);
        drinkRG.setOnCheckedChangeListener(dringOnCheckedChanged);

        cofeeTV = (TextView)findViewById(R.id.cofeeTV);
        init();
    }

    private void init(){
        //cofeeOnCheckedChanged.onCheckedChanged(cofeeCB,cofeeCB.isChecked());
    }

    private RadioGroup.OnCheckedChangeListener dringOnCheckedChanged = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
            RadioButton rButton = (RadioButton) group.findViewById(checkedId);
            cofeeTV.setText(rButton.getText());
        }
    };
}
