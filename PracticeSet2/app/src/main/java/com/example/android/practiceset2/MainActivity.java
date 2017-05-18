package com.example.android.practiceset2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This activity keeps track of the basketball score for 2 team
 */
public class MainActivity extends AppCompatActivity {

    // Tracks the score for teamA
    int scoreTeamA = 0;

    // Tracks the score for teamB
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Increase the score for team A by 3 point.
     */
    public void addThreeForTeamA(View view) {
        scoreTeamA += 3;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for team A by 2 point.
     */
    public void addTwoForTeamA(View view) {
        scoreTeamA += 2;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for team A by 1 point.
     */
    public void addOneForTeamA(View view) {
        scoreTeamA += 1;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for team B by 3 point.
     */
    public void addThreeForTeamB(View view) {
        scoreTeamB += 3;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the score for team B by 2 point.
     */
    public void addTwoForTeamB(View view) {
        scoreTeamB += 2;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the score for team B by 1 point.
     */
    public void addOneForTeamB(View view) {
        scoreTeamB += 1;
        displayForTeamB(scoreTeamB);
    }

    /**
     *  Display the given score for team A
     */
    public void displayForTeamA(int score) {
        TextView textTeamAScore = (TextView) findViewById(R.id.text_team_a_score);
        textTeamAScore.setText(String.valueOf(score));
    }

    /**
     *  Display the given score for team B
     */
    public void displayForTeamB(int score) {
        TextView textTeamBScore = (TextView) findViewById(R.id.text_team_b_score);
        textTeamBScore.setText(String.valueOf(score));
        Toast toast = Toast.makeText(this, "Hi", Toast.LENGTH_LONG);
    }

    /**
     * Reset the score for both teams back to 0
     */
    public void reset(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
}
