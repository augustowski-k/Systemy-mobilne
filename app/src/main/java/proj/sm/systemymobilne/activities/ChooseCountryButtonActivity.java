package proj.sm.systemymobilne.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import proj.sm.systemymobilne.R;

public class ChooseCountryButtonActivity extends AppCompatActivity {
    Button btnChooseCountryInvoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_country_button);
        btnChooseCountryInvoke = (Button)findViewById(R.id.btnChooseCountryInvoke);
        btnChooseCountryInvoke.setOnClickListener(chooseCountryInvokeClicked);
    }

    private View.OnClickListener chooseCountryInvokeClicked = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent chooseCountryInvokeIntent = new Intent(v.getContext(), ChooseCountryListActivity.class);
            startActivityForResult(chooseCountryInvokeIntent, 1);
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Intent showCountryInvokeIntent = new Intent(this.getApplicationContext(), ChooseCountryTextViewActivity.class);
        String countryName = data.getStringExtra("CountryName");
        showCountryInvokeIntent.putExtra("CountryName", countryName);
        startActivity(showCountryInvokeIntent);
    }
}
