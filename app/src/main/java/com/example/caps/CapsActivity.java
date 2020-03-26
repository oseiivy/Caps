//Student Name: Ivy Osei
//This lab was done individually

package com.example.caps;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CapsActivity extends AppCompatActivity {
    private Game game;
    private String question;
    private String answer;
    private int score;
    private int qNum = 1;
    private String qa;
    private String log = "";
    private ToneGenerator tone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caps_layout);
        game = new Game();
        this.tone = new ToneGenerator(AudioManager.STREAM_ALARM, 100);
        ask();


    }

    private void ask(){
        qa= game.qa();
        question = qa.substring(0,qa.indexOf("\n"));
        answer = qa.substring(qa.indexOf("\n")+1,qa.length());
        ((TextView)findViewById(R.id.question)).setText(question);
    }

    public void onDone(View V){
        String yourAns = (((EditText)findViewById(R.id.answer)).getText().toString()).toUpperCase();

        // if answer is right or wrong make new
        if (yourAns.equals(answer.toUpperCase())){
            score++;
            ((TextView)findViewById(R.id.score)).setText( "Score = " + score);
            tone.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD,200);
        }
        else {
            tone.startTone(ToneGenerator.TONE_CDMA_ABBR_REORDER,200);
        }


        // stirng var for log
        log =  "Q# " + qNum + ": " + question + "\n" +
                "your answer: " + yourAns + "\n" +
                "correct answer: " + answer + "\n" + "\n" + log ;

        // set text view of log to be the log string
        ((TextView)findViewById(R.id.log)).setText(log);

        // change nummber of string
        qNum++;
        ((TextView)findViewById(R.id.qNum)).setText( "Q# " + qNum);

        if (qNum == 10){
            ((TextView)findViewById(R.id.qNum)).setText( "Game Over");
            findViewById(R.id.done).setEnabled(false);
        }
        else {
            ask();
        }
        ((TextView)findViewById(R.id.answer)).setText("");

    }

}