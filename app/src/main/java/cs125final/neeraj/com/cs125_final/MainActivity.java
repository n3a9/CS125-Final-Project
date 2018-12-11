package cs125final.neeraj.com.cs125_final;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String date;
    String dateText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Date date = new Date();
        final String urlDate = new SimpleDateFormat("MM/d").format(date);
        final TextView txtView = findViewById(R.id.text);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try  {
                    URL url = new URL("http://numbersapi.com/" + urlDate + "/date");
                    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                    final String dateText = in.readLine();
                    in.close();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            txtView.setText(dateText);
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

        final Button button = findViewById(R.id.simpleButton);
        button.setText("Give me another interesting fact about today");
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try  {
                            URL url = new URL("http://numbersapi.com/" + urlDate + "/date");
                            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                            final String dateText = in.readLine();
                            in.close();
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    txtView.setText(dateText);
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
            }
        });

        final EditText editText = findViewById(R.id.dateText);
        editText.setText("Enter a custom date.");
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    final String inputDate = (editText.getText().toString());
                    Thread thread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try  {
                                URL url = new URL("http://numbersapi.com/" + inputDate + "/date");
                                BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
                                final String dateText = in.readLine();
                                in.close();
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        txtView.setText(dateText);
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
                    handled = true;
                }
                return handled;
            }
        });
    }
}
