package com.example.jimmy.riskroller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private int defenseDiceAmount = 0;
    private int offenseDiceAmount = 0;


    public void decreaseDefenseDice(View view) {
        if (defenseDiceAmount <= 1) {
            return;
        }
        defenseDiceAmount--;
        setDefenseDiceAmount();
    }

    public void increaseDefenseDice(View view) {
        if (defenseDiceAmount == 2) {
            return;
        }
        defenseDiceAmount++;
        setDefenseDiceAmount();
    }

    public void decreaseOffenseDice(View view) {
        if (offenseDiceAmount <= 1) {
            return;
        }
        offenseDiceAmount--;
        setOffenseDiceAmount();
    }

    public void increaseOffenseDice(View view) {
        if (offenseDiceAmount == 3) {
            return;
        }
        offenseDiceAmount += 1;
        setOffenseDiceAmount();
    }

    private void setDefenseDiceAmount() {
        TextView defenseDiceValue = (TextView) findViewById(R.id.defense_dice_amount);
        defenseDiceValue.setText(Integer.toString(defenseDiceAmount));
    }

    private void setOffenseDiceAmount() {
        TextView offenseDiceValue = (TextView) findViewById(R.id.offense_dice_amount);
        offenseDiceValue.setText(Integer.toString(offenseDiceAmount));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
