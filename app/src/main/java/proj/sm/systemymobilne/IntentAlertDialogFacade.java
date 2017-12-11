package proj.sm.systemymobilne;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by augus on 12/11/2017.
 */

public class IntentAlertDialogFacade {
    private AlertDialog dialog;
    private AlertDialog.Builder dialogBuilder;
    private Activity acitvity;
    private Status status;
    private List<IIntentAlertListener> listeners = new ArrayList<>();
    public enum Status{
        accepted, discarded, canceled
    }

    public IntentAlertDialogFacade(Activity activity){
        dialogBuilder = new AlertDialog.Builder(activity);
        this.acitvity = activity;
    }

    public void create(){
        dialogBuilder.setMessage("akceptujesz liczby?");
        dialogBuilder.setPositiveButton("tak",BtnDialogPositiveClickListener);
        dialogBuilder.setNegativeButton("nie",BtnDialogNegativeClickListener);
        dialogBuilder.setNeutralButton("odrzuć",BtnDialogNeutralClickListener);
        dialog = dialogBuilder.create();
    }

    public void display(){
        dialog.show();
    }

    public Status getStatus(){
        return status;
    }

    public void setListener(IIntentAlertListener listener){
        listeners.add(listener);
    }

    private DialogInterface.OnClickListener BtnDialogPositiveClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            status = Status.accepted;
            dialogDecisionListenersInvoke();
        }
    };

    private DialogInterface.OnClickListener BtnDialogNegativeClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            status = Status.discarded;
            dialogDecisionListenersInvoke();
        }
    };

    private DialogInterface.OnClickListener BtnDialogNeutralClickListener = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            status = Status.canceled;
            dialogDecisionListenersInvoke();
        }
    };

    private void dialogDecisionListenersInvoke(){
        for (IIntentAlertListener listener:
             listeners) {
            listener.OnAlertDecision();
        }
    }
}
