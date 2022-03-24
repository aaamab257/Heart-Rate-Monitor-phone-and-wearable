package healthmonitor.ehealth.faithworks.smartwatch;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DeteScreen extends Activity {
    Button cancel , send ;
    TextView alertSent  ,  txtCounter , txtAlert;
    long maxCounter = 15000;
    long diff = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dete_screen);
        send = findViewById(R.id.btn_send);
        cancel = findViewById(R.id.btn_cancel);
        alertSent= findViewById(R.id.txt_alertSent);
        txtCounter = findViewById(R.id.txt_counter);
        txtAlert = findViewById(R.id.txt_alert);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(DeteScreen.this).create();
                alertDialog.setTitle("Are You Sure ?");
                alertDialog.setMessage("Selecting false alert means that no alert will be send to emergency list");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "False Alert",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.dismiss();
                                cancel.setVisibility(View.GONE);
                                send.setVisibility(View.GONE);
                                txtCounter.setVisibility(View.GONE);
                                txtAlert.setVisibility(View.GONE);
                                alertSent.setText("Alert Canceled");
                                alertSent.setVisibility(View.VISIBLE);
                                startActivity(new Intent(DeteScreen.this, HomePage.class));

                            }
                        });
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        /*cancel.setVisibility(View.GONE);
                        send.setVisibility(View.GONE);
                        txtCounter.setVisibility(View.GONE);
                        txtAlert.setVisibility(View.GONE);
                        alertSent.setVisibility(View.VISIBLE);*/
                    }
                });
                alertDialog.show();
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel.setVisibility(View.GONE);
                send.setVisibility(View.GONE);
                txtCounter.setVisibility(View.GONE);
                txtAlert.setVisibility(View.GONE);
                alertSent.setVisibility(View.VISIBLE);
            }
        });
        new CountDownTimer(maxCounter , diff ) {

            public void onTick(long millisUntilFinished) {
                long diff = maxCounter - millisUntilFinished;
                txtCounter.setText(diff  / 1000 +" SEC" );
                //here you can have your logic to set text to edittext
            }

            public void onFinish() {
                cancel.setVisibility(View.GONE);
                send.setVisibility(View.GONE);
                txtCounter.setVisibility(View.GONE);
                txtAlert.setVisibility(View.GONE);
                alertSent.setVisibility(View.VISIBLE);
            }

        }.start();
    }
}