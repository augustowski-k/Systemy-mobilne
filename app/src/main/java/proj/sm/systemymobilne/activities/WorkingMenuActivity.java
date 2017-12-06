package proj.sm.systemymobilne.activities;

import android.graphics.Color;
import android.renderscript.ScriptGroup;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

import proj.sm.systemymobilne.R;
import proj.sm.systemymobilne.Tools;

public class WorkingMenuActivity extends AppCompatActivity {
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

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v.getId() == R.id.edtFirstString){
            inflateFirstStringMenu(menu);
        }else if(v.getId() == R.id.edtSecondString){
            inflateSecondStringMenu(menu);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getGroupId() == R.id.secondStringEditMenuInputType){
            secondStringEditMenuItemSelected(item);
        }
        else if(item.getGroupId() == R.id.firstStringEditMenuColor){
            firstStringEditMenuItemSelected(item);
        }
        return true;
    }

    private void firstStringEditMenuItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.blueFirstStringEdit){
            edtFirstString.setTextColor(Color.BLUE);
        }
        else if(item.getItemId() == R.id.redFirstStringEdit){
            edtFirstString.setTextColor(Color.RED);
        }
        Tools.showToast("Context menu for first string edit. " + item.getTitle(), this);
    }

    private void secondStringEditMenuItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.dateSecondStringEdit){
            edtSecondString.setInputType(InputType.TYPE_CLASS_DATETIME);
        }
        else if(item.getItemId() == R.id.phoneSecondStringEdit){
            edtSecondString.setInputType(InputType.TYPE_CLASS_PHONE);
        }
        else if(item.getItemId() == R.id.passwordSecondStringEdit){
            edtSecondString.setInputType(InputType.TYPE_TEXT_VARIATION_WEB_PASSWORD);
        }
        Tools.showToast("Context menu for second string edit. " + item.getTitle(), this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.keyboardOff){
            edtFirstString.setInputType(InputType.TYPE_NULL);
            edtSecondString.setInputType(InputType.TYPE_NULL);

        }else if(item.getItemId() == R.id.firstStringTedDisabled){
            edtFirstString.setEnabled(false);
        }
        Tools.showToast("Options menu, item: '" + item.getTitle() + "' selected", this);
        return true;
    }

    private void inflateFirstStringMenu(ContextMenu menu) {
        menu.setHeaderTitle("Wybierz kolor");
        getMenuInflater().inflate(R.menu.edt_first_string_ctx_menu, menu);
    }

    private void inflateSecondStringMenu(ContextMenu menu) {
        menu.setHeaderTitle("Wybierz tryb wprowadzania");
        getMenuInflater().inflate(R.menu.edt_second_string_ctx_menu, menu);
    }
}
