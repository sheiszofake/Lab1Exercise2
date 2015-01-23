package th.ac.tu.siit.cholwich.lab1exercise2;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ConvertButton(View v){
        TextView tv;
        tv = (TextView)findViewById(R.id.tvOutput);
        //The variable tv is referring to the TextView widget in the layout.

        EditText etInput = (EditText)findViewById(R.id.etInput);
        String s = etInput.getText().toString();

        RadioGroup rgFrom;
        RadioGroup rgTo;

        rgFrom = (RadioGroup)findViewById(R.id.rgFrom);
        rgTo = (RadioGroup)findViewById(R.id.rgTo);

        int selFrom = rgFrom.getCheckedRadioButtonId();
        int selTo = rgTo.getCheckedRadioButtonId();

        double con = Double.parseDouble(s);
        double output = con;


        if (selFrom == R.id.rbFrmC) { //The user wants to convert from Celsius.
            if (selTo == R.id.rbToF){
                output = con*(9.0/5.0)+32.0;
            }
            if (selTo == R.id.rbToK){
                output = con+273.15;
            }
        }
        if (selFrom == R.id.rbFrmF) { //The user wants to convert from Fahrenheit.
            if (selTo == R.id.rbToC){
                output = (con-32.0)*(5.0/9.0);
            }
            if (selTo == R.id.rbToK){
                output = (con+459.67)*(5.0/9.0);
            }
        }
        if (selFrom == R.id.rbFrmK) { //The user wants to convert from Kelvin.
            if (selTo == R.id.rbToC) {
                output = con - 273.15;
            }
            if (selTo == R.id.rbToF) {
                output = con + (9.0 / 5.0) - 459.67;
            }
        }

        tv.setText(Double.toString(output));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
