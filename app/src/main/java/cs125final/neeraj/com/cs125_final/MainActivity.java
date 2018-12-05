package cs125final.neeraj.com.cs125_final;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Date date = new Date();


        final String urlDate = new SimpleDateFormat("MM/d").format(date);

        final TextView txtView = (TextView) findViewById(R.id.text);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try  {
                    URL url = new URL("http://numbersapi.com/" + urlDate + "/date");
                    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                    final String str = in.readLine();
                    System.out.println(str);
                    in.close();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            txtView.setText(str);
                        }
                    });
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        txtView.setGravity(Gravity.CENTER);
        txtView.setTextSize(20);
        //setContentView(txtView);

        final Button button = (Button) findViewById(R.id.simpleButton);
        button.setText("Give me another interesting fact about today");
        button.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Log.d("tag", "button was clicked");
                Intent i = new Intent(MainActivity.this, MainActivity.class);

                startActivity(i);
                finish();
            }

        });

        final Button button2 = (Button) findViewById(R.id.simpleButton2);
        button2.setText("Enter a custom date");




    }


}
