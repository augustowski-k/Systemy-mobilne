package proj.sm.systemymobilne;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

/**
 * Created by augus on 11/23/2017.
 */

public class ExitAlertDialogFacade {
    private AlertDialog dialog;
    private AlertDialog.Builder dialogBuilder;
    private Activity acitvity;

    public ExitAlertDialogFacade(Activity activity){
        dialogBuilder = new AlertDialog.Builder(activity);
        this.acitvity = activity;
    }

    public void create(){
        dialogBuilder.setMessage("zakonczyc?");
        dialogBuilder.setPositiveButton("ok",BtnDialogPositiveClickListener);
        dialogBuilder.setNegativeButton("not ok",BtnDialogNegativeClickListener);
        dialogBuilder.setNeutralButton("cancel",BtnDialogNegativeClickListener);
        dialogBuilder.setTitle("tytul");
        dialogBuilder.setIcon(R.mipmap.ic_launcher_round);
        dialogBuilder.setCancelable(true);
        dialog = dialogBuilder.create();
    }

    public void display(){
        dialog.show();
    }

    private DialogInterface.OnClickListener BtnDialogPositiveClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Tools.showToast("To juz jest koniec...", acitvity);
            acitvity.finish();
        }
    };

    private DialogInterface.OnClickListener BtnDialogNegativeClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Tools.showToast("kontynuujmy",acitvity);
        }
    };
}
