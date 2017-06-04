package cn.studyjams.s2.sj0119.UPlan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.stepstone.stepper.StepperLayout;

public class PlanDetailActivity extends AppCompatActivity {

    private StepperLayout mStepperLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan_detail);

//        mStepperLayout = (StepperLayout) findViewById(R.id.stepperLayout);
//        mStepperLayout.setAdapter(new MyStepperAdapter(getSupportFragmentManager(), this));
    }
}
