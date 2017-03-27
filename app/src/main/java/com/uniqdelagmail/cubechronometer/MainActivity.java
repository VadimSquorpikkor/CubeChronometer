package com.uniqdelagmail.cubechronometer;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Chronometer mChronometer;

    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    TextView textView6;
    TextView textView7;
    TextView textView8;
    TextView textView9;
    TextView textView10;
    TextView textView11;
    TextView textView12;
    TextView textView13;
    TextView textView15;
    TextView textView;
    TextView textView19;
    TextView textView16;

    ImageButton imageButton;
    SharedPreferences sPref;
    SharedPreferences sPref2;
    SharedPreferences sPref3;
    final String SAVED_TEXT = "saved_text";
    final String SAVED_TEXT2 = "saved_text2";
    final String SAVED_TEXT3 = "saved_text3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);

        mChronometer = (Chronometer) findViewById(R.id.chronometer);
        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);
        textView6 = (TextView) findViewById(R.id.textView6);
        textView7 = (TextView) findViewById(R.id.textView7);
        textView8 = (TextView) findViewById(R.id.textView8);
        textView9 = (TextView) findViewById(R.id.textView9);
        textView10 = (TextView) findViewById(R.id.textView10);
        textView11 = (TextView) findViewById(R.id.textView11);
        textView12 = (TextView) findViewById(R.id.textView12);
        textView13 = (TextView) findViewById(R.id.textView13);
        textView15 = (TextView) findViewById(R.id.textView15);
        textView19 = (TextView) findViewById(R.id.textView19);
        textView = (TextView) findViewById(R.id.textView);
        textView16 = (TextView) findViewById(R.id.textView16);

        imageButton = (ImageButton) findViewById(R.id.imageButton);
        textView13.setText("0.00");
        textView12.setText("100");
        textView19.setText("100");
        textView1.setTextColor(Color.RED);

        loadText();

        Intent intent = getIntent();
        if((intent.getStringExtra("average"))!=null){
            textView19.setText(intent.getStringExtra("average"));
            saveText(textView12);
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.menu_about:
                switchToAboutActivity();
                return true;

            case R.id.menu_restart:
                theEndOfGameAlert(textView12);
                return true;
            //case R.id.menu_retry:

            //    return true;
            //case R.id.menu_max_att:

            //    return true;
            case R.id.menu_set_average:
                setAverageIWishAlert(textView12);
                return true;
            case R.id.menu_min_time:
                setTheBestTime(textView19);
                return true;
            //case R.id.menu_min_average_time:
            //    setTheBestAverageTime(textView19);
            //    return true;
        }
        return super.onOptionsItemSelected(item);
    }

    int i=1;

    public void moveValueToTextView() {
        long elapsedMillis = SystemClock.elapsedRealtime() - mChronometer.getBase();
        long sec = (elapsedMillis / 1000);
        textView1.setTextColor(Color.BLACK);
        textView2.setTextColor(Color.BLACK);
        textView3.setTextColor(Color.BLACK);
        textView4.setTextColor(Color.BLACK);
        textView5.setTextColor(Color.BLACK);
        textView6.setTextColor(Color.BLACK);
        textView7.setTextColor(Color.BLACK);
        textView8.setTextColor(Color.BLACK);
        textView9.setTextColor(Color.BLACK);
        textView10.setTextColor(Color.BLACK);

            switch (i) {
                case 1:
                    textView1.setText(String.valueOf(sec));
                    textView2.setTextColor(Color.RED);
                    break;
                case 2:
                    textView2.setText(String.valueOf(sec));
                    textView3.setTextColor(Color.RED);
                    break;
                case 3:
                    textView3.setText(String.valueOf(sec));
                    textView4.setTextColor(Color.RED);
                    break;
                case 4:
                    textView4.setText(String.valueOf(sec));
                    textView5.setTextColor(Color.RED);
                    break;
                case 5:
                    textView5.setText(String.valueOf(sec));
                    textView6.setTextColor(Color.RED);
                    break;
                case 6:
                    textView6.setText(String.valueOf(sec));
                    textView7.setTextColor(Color.RED);
                    break;
                case 7:
                    textView7.setText(String.valueOf(sec));
                    textView8.setTextColor(Color.RED);
                    break;
                case 8:
                    textView8.setText(String.valueOf(sec));
                    textView9.setTextColor(Color.RED);
                    break;
                case 9:
                    textView9.setText(String.valueOf(sec));
                    textView10.setTextColor(Color.RED);
                    break;
                case 10:
                    textView10.setText(String.valueOf(sec));
                    //textView10.setTextColor(Color.RED);
                    textView13.setText("0.0");

                    break;
                default:
                    textView10.setText(String.valueOf(sec));
                    textView10.setTextColor(Color.RED);

            }

            //i++;
        textView11.setText(String.format("%.2f", theAverageValue()).replace(",","."));
    }

    double average = 0;
    double sumOfAllTimes = 0;

    public double theAverageValue(){
        sumOfAllTimes =
                        Double.parseDouble(textView1.getText().toString())+
                        Double.parseDouble(textView2.getText().toString())+
                        Double.parseDouble(textView3.getText().toString())+
                        Double.parseDouble(textView4.getText().toString())+
                        Double.parseDouble(textView5.getText().toString())+
                        Double.parseDouble(textView6.getText().toString())+
                        Double.parseDouble(textView7.getText().toString())+
                        Double.parseDouble(textView8.getText().toString())+
                        Double.parseDouble(textView9.getText().toString())+
                        Double.parseDouble(textView10.getText().toString());
        average = sumOfAllTimes/i;
        if(average>Double.parseDouble(textView12.getText().toString())){
            textView11.setTextColor(Color.RED);
            textView.setTextColor(Color.RED);
        }
        else if(average==Double.parseDouble(textView12.getText().toString())){
            textView11.setTextColor(Color.BLUE);
            textView.setTextColor(Color.BLUE);
        }
        else {
            textView11.setTextColor(getResources().getColor(R.color.green));
            textView.setTextColor(getResources().getColor(R.color.green));
        }

        return average;
    }

    String value = "0";

    public void countTimeLeft(){
        double averageIWishToGet = Double.parseDouble(textView12.getText().toString());
        double countLeftInteger = (10*averageIWishToGet-sumOfAllTimes)/(10-(i));
        if(countLeftInteger<=0){
            looserAlert(textView12);
            textView13.setText(String.format("%.2f", countLeftInteger).replace(",","."));
        }
        else if(countLeftInteger<averageIWishToGet){
            textView13.setText(String.format("%.2f", countLeftInteger).replace(",","."));
            textView13.setTextColor(Color.RED);
            textView15.setTextColor(Color.RED);
        }
        else if(countLeftInteger==averageIWishToGet){
            textView13.setText(String.format("%.2f", countLeftInteger).replace(",","."));
            textView13.setTextColor(Color.BLUE);
            textView15.setTextColor(Color.BLUE);
        }
        else{
            textView13.setText(String.format("%.2f", countLeftInteger).replace(",","."));
            textView13.setTextColor(getResources().getColor(R.color.green));
            textView15.setTextColor(getResources().getColor(R.color.green));
        }


    }

    public void setTheBestTime (View view){
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        alert.setTitle("Ввести лучшее время");
        alert.setView(input);
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                value = input.getText().toString().trim();
                textView16.setText("Лучшее время: " + value);
                saveText(textView12);
            }
       });

          alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.cancel();
            }
        });
        alert.show();
    }

    public boolean bigButtonChoice = true;

    public void bigButtonClick (View view){
            if (bigButtonChoice == true) {
                mChronometer.setBase(SystemClock.elapsedRealtime());
                mChronometer.start();
                bigButtonChoice = false;
                imageButton.setImageResource(R.drawable.red_but2);
            } else {
                mChronometer.stop();
                moveValueToTextView();
                bigButtonChoice = true;
                imageButton.setImageResource(R.drawable.green_but2);
                if(i<10){
                    countTimeLeft();
                    i++;
                }
                else {
                    imageButton.setEnabled(false);
                    if(average<(Double.parseDouble(textView19.getText().toString()))){
                        setTheBestAverageTime();
                        victoryNewAverageAlert(textView12);
                    }
                    else {
                        theEndOfGameAlert(textView12);
                    }
                    }
                }
    }


    public void saveText(View view) {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, textView12.getText().toString());
        ed.commit();

        sPref2 = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed2 = sPref2.edit();
        ed2.putString(SAVED_TEXT2, textView19.getText().toString());
        ed2.commit();

        sPref3 = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed3 = sPref3.edit();
        ed3.putString(SAVED_TEXT3, textView16.getText().toString());
        ed3.commit();

        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }

    void loadText() {
        try {
            sPref = getPreferences(MODE_PRIVATE);
            String savedText = sPref.getString(SAVED_TEXT, "");
            if(savedText==""){savedText="50";}
            textView12.setText(savedText);


            sPref2 = getPreferences(MODE_PRIVATE);
            String savedText2 = sPref2.getString(SAVED_TEXT2, "");
            if(savedText2==""){savedText2="50";}
            textView19.setText(savedText2);

            sPref3 = getPreferences(MODE_PRIVATE);
            String savedText3 = sPref3.getString(SAVED_TEXT3, "");
            if(savedText3==""){savedText3="Лучшее время:   ";}
            textView16.setText(savedText3);

            Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            textView12.setText("50");
            textView12.setText("50");
            textView12.setText("Лучшее время: 50");
           // showTheAlert(textView12);
        //    wouldYouSetTheAverage(textView12);
        }

    }

    public void looserAlert (View view){
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Поздравляю! Ты -- Лошара!!");

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.cancel();
            }
        });
        alert.show();
    }

    public void restartApp(){
        i=1;
        double sumOfAllTimes = 0;
        imageButton.setEnabled(true);
        textView1.setTextColor(Color.RED);
        textView2.setTextColor(Color.BLACK);
        textView3.setTextColor(Color.BLACK);
        textView4.setTextColor(Color.BLACK);
        textView5.setTextColor(Color.BLACK);
        textView6.setTextColor(Color.BLACK);
        textView7.setTextColor(Color.BLACK);
        textView8.setTextColor(Color.BLACK);
        textView9.setTextColor(Color.BLACK);
        textView10.setTextColor(Color.BLACK);
        textView11.setTextColor(Color.BLACK);
        textView13.setTextColor(Color.BLACK);
        textView1.setText("0.00");
        textView2.setText("0.00");
        textView3.setText("0.00");
        textView4.setText("0.00");
        textView5.setText("0.00");
        textView6.setText("0.00");
        textView7.setText("0.00");
        textView8.setText("0.00");
        textView9.setText("0.00");
        textView10.setText("0.00");
        textView11.setText("0.00");
        textView13.setText("0.00");
    }

    public void theEndOfGameAlert (View view){
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Среднее время = "+String.format("%.2f" , average)+" сек");
        alert.setMessage("Перезапустить?");

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                restartApp();
                dialog.cancel();
            }
        });

        alert.setNegativeButton("Ай, нет", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.cancel();
                //finish();
            }
        });
        alert.show();
    }

    public void setAverageIWishAlert (View view){
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        //alert.setTitle("Среднее время = "+average+" сек");
        alert.setMessage("Ввести значение в секундах");
        alert.setView(input);
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                value = input.getText().toString().trim();
                if(value.equals("16777216")){
                    openTneSecretActivity();
                }
                else {
                    if (Double.parseDouble(value) >= Double.parseDouble(textView19.getText().toString())) {
                        textView12.setText(value);
                        theEndOfGameAlert(textView12);
                        saveText(textView12);
                    } else {
                        itsAWrongWishAlert(textView12);
                    }
                }
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.cancel();
            }
        });
        alert.show();
    }

    public void itsAWrongWishAlert (View view){
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setMessage("Значение не может быть меньше 'лучшего среднего'! Нужно сначала поставить рекорд 'лучшего среднего'.");
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                setAverageIWishAlert(textView12);
                dialog.cancel();
            }
        });
        alert.show();
    }

    public void switchToAboutActivity() {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    public void openTneSecretActivity() {
        Intent intent = new Intent(this, SetParamActivity.class);
        startActivity(intent);
        finish();
    }

    public void setTheBestAverageTime(){
       // textView19.setText(String.format("%2.f" , average));
        textView19.setText(textView11.getText());
        saveText(textView12);
    }

    public void victoryNewAverageAlert (View view){
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setMessage("Поздравляю! Новый рекорд среднего времени: "+String.format("%.2f" , average)+" сек! Перезапустить?");

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                restartApp();
                dialog.cancel();
            }
        });

        alert.setNegativeButton("Ай, нет", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.cancel();
                //finish();
            }
        });
        alert.show();
    }
}
