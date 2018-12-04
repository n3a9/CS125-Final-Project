package cs125final.neeraj.com.cs125_final;

import java.text.DateFormat;
import java.util.Date;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
        TextView txtView = new TextView(this);
        txtView.setText("Current Date and Time:" + currentDateTimeString);
        txtView.setGravity(Gravity.CENTER);
        txtView.setTextSize(20);
        setContentView(txtView);
    }
}
