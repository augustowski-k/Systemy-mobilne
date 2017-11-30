package proj.sm.systemymobilne.activities;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

import proj.sm.systemymobilne.R;

public class DynamicMenuActivity extends AppCompatActivity {
    EditText edtFirstString, edtSecondString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_menu);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        edtFirstString = (EditText)findViewById(R.id.edtFirstString);
        edtSecondString = (EditText)findViewById(R.id.edtSecondString);

        registerForContextMenu(edtFirstString);
        registerForContextMenu(edtSecondString);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        int id = v.getId();
        if (id == R.id.edtFirstString){
            initFirstStringContextMenu(menu, id);
        }
        else if(id == R.id.edtSecondString){
            initSecondStringContextMenu(menu, id);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        menu.add("Option 1");
        menu.add("Option 2");
        menu.add("Option 3");
        menu.add("Option 4");
        menu.add("Option 5");
        menu.add("Option 6");
        menu.add("Option 7");
        menu.add("Option 8");
        return true;
    }

    private void initFirstStringContextMenu(ContextMenu menu, int id) {
        menu.setHeaderTitle("First string menu");
        menu.add(0,id,0,"Hello1");
        menu.add(0,id,0,"Hello2");
    }

    private void initSecondStringContextMenu(ContextMenu menu, int id) {
        menu.setHeaderTitle("Second string menu");
        menu.add(0,id,0,"Hello1");
        menu.add(0,id,0,"Hello2");
        menu.add(0,id,0,"Hello3");
    }
}
