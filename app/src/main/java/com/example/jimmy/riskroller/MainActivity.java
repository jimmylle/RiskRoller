package com.example.jimmy.riskroller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private int defenseDiceAmount = 0;
    private int offenseDiceAmount = 0;

    public void rollResults(View view) {
        setDefenseResults();
        setOffenseResults();
    }

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

    private void setDefenseResults() {
        Random rand = new Random();
        int rand1 = rand.nextInt(6) + 1;
        int rand2 = rand.nextInt(6) + 1;
        rand1 = Math.max(rand1, rand2);
        rand2 = Math.min(rand1,rand2);
        TextView defenseview1 = (TextView) findViewById(R.id.defense_first_number);
        TextView defenseview2 = (TextView) findViewById(R.id.defense_second_number);
        if (defenseDiceAmount == 0) {
            return;
        } else if (defenseDiceAmount == 1) {
            defenseview1.setText(Integer.toString(rand1));
            defenseview2.setText(Integer.toString(0));
        } else {
            defenseview1.setText(Integer.toString(rand1));
            defenseview2.setText(Integer.toString(rand2));
        }
    }

    private void setOffenseResults() {
        Random rand = new Random();
        int rand1 = rand.nextInt(6) + 1;
        int rand2 = rand.nextInt(6) + 1;
        int rand3 = rand.nextInt(6) + 1;

        int max = Math.max(rand1,Math.max(rand2,rand3));
        int min = Math.min(rand1, Math.min(rand2, rand3));
        int mid = ((rand1 + rand2 +rand3) - (max + min));

        TextView offenseview1 = (TextView) findViewById(R.id.offense_first_number);
        TextView offenseview2 = (TextView) findViewById(R.id.offense_second_number);
        TextView offenseview3 = (TextView) findViewById(R.id.offense_third_number);

        if (offenseDiceAmount == 0) {
            return;
        } else if (offenseDiceAmount == 1) {
            offenseview1.setText(Integer.toString(max));
            offenseview2.setText(Integer.toString(0));
            offenseview3.setText(Integer.toString(0));
        } else if(offenseDiceAmount == 2) {
            offenseview1.setText(Integer.toString(max));
            offenseview2.setText(Integer.toString(mid));
            offenseview3.setText(Integer.toString(0));
        } else {
            offenseview1.setText(Integer.toString(max));
            offenseview2.setText(Integer.toString(mid));
            offenseview3.setText(Integer.toString(min));
        }
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
