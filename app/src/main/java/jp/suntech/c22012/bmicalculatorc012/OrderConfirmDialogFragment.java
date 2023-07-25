package jp.suntech.c22012.bmicalculatorc012;

import static android.app.PendingIntent.getActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.Nullable;

import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;

public class OrderConfirmDialogFragment extends DialogFragment{

    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {



    //リスナ・オブジェクトの用意
    DialogButtonClickListener listener = new DialogButtonClickListener();


    //
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    //
    builder.setTitle(R.string.dialog_title);
    //
    builder.setMessage(R.string.dialog_msg);
    //
    builder.setPositiveButton(R.string.dialog_btn_ok, new DialogButtonClickListener());
    //
    AlertDialog dialog = builder.create();


    return dialog;
}


    //
    private class DialogButtonClickListener implements DialogInterface.OnClickListener{

        //String text = "";
        @Override
        public void onClick(DialogInterface dialog, int which) {

            switch(which) {
                case DialogInterface.BUTTON_POSITIVE:

                    break;
            }

        }
    }
}
