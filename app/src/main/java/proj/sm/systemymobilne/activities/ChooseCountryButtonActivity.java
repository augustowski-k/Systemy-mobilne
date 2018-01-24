package proj.sm.systemymobilne.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import proj.sm.systemymobilne.R;
import proj.sm.systemymobilne.Tools;

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
            Intent chooseCountryInvokeIntent = new Intent();
            chooseCountryInvokeIntent.setAction("ChooseCountry");
            Intent intentChooser = Intent.createChooser(chooseCountryInvokeIntent, "Choose wisely");
            try{
                startActivityForResult(intentChooser, 1);
            }catch (Exception e){
                Tools.showToast("error caught",v.getContext());
            }
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Intent showCountryInvokeIntent = new Intent();
        showCountryInvokeIntent.setAction("ShowCountry");
        String countryName = data.getStringExtra("CountryName");
        String countryPhone = data.getStringExtra("CountryPhone");
        showCountryInvokeIntent.putExtra("CountryName", countryName);
        showCountryInvokeIntent.putExtra("CountryPhone", countryPhone);
        startActivity(showCountryInvokeIntent);
    }
}
