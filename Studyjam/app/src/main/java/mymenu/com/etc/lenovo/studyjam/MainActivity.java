package mymenu.com.etc.lenovo.studyjam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView AScore;
    private TextView BScore;

    private Button btnA1,btnA2,btnA3;
    private Button btnB1,btnB2,btnB3;
    private Button btnReset;

    private int AScoreNumber = 0, BScoreNumber = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AScore = (TextView) findViewById(R.id.AScore);
        BScore = (TextView) findViewById(R.id.BScore);

        btnA1 = (Button) findViewById(R.id.btnA1);
        btnA2 = (Button) findViewById(R.id.btnA2);
        btnA3 = (Button) findViewById(R.id.btnA3);
        btnB1 = (Button) findViewById(R.id.btnB1);
        btnB2 = (Button) findViewById(R.id.btnB2);
        btnB3 = (Button) findViewById(R.id.btnB3);

        btnReset = (Button) findViewById(R.id.btnReset);

        btnA1.setOnClickListener(new MyClickListener());
        btnA2.setOnClickListener(new MyClickListener());
        btnA3.setOnClickListener(new MyClickListener());
        btnB1.setOnClickListener(new MyClickListener());
        btnB2.setOnClickListener(new MyClickListener());
        btnB3.setOnClickListener(new MyClickListener());

        btnReset.setOnClickListener(new MyClickListener());
    }

    class MyClickListener implements View.OnClickListener {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btnA1:
                    AgetScore(1);
                    break;
                case R.id.btnA2:
                    AgetScore(2);
                    break;
                case R.id.btnA3:
                    AgetScore(3);
                    break;
                case R.id.btnB1:
                    BgetScore(1);
                    break;
                case R.id.btnB2:
                    BgetScore(2);
                    break;
                case R.id.btnB3:
                    BgetScore(3);
                    break;
                case R.id.btnReset:
                    AScoreNumber = 0;
                    BScoreNumber = 0;
                    AScore.setText(String.valueOf(AScoreNumber));
                    BScore.setText(String.valueOf(BScoreNumber));
                    break;
                default:
                    break;
            }
        }
    }

    public void AgetScore(int ScoreNumber){
        AScoreNumber += ScoreNumber;
        AScore.setText(String.valueOf(AScoreNumber));
    }

    public void BgetScore(int ScoreNumber){
        BScoreNumber += ScoreNumber;
        BScore.setText(String.valueOf(BScoreNumber));
    }
}
