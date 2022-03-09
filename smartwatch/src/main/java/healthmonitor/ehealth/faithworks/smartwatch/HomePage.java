package healthmonitor.ehealth.faithworks.smartwatch;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HomePage extends Activity {

    Button stable , send ;
    TextView alertSent ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        send = findViewById(R.id.btn_send);
        stable = findViewById(R.id.btn_stable);
        alertSent= findViewById(R.id.txt_alert);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stable.setVisibility(View.GONE);
                send.setVisibility(View.GONE);
                alertSent.setVisibility(View.VISIBLE);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        startActivity(new Intent(HomePage.this , DeteScreen.class));
                    }
                }, 5000);
            }
        });
    }
}