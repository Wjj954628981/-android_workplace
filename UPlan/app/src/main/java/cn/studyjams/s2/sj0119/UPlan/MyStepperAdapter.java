//package cn.studyjams.s2.sj0119.UPlan;
//
//import android.content.Context;
//import android.os.Bundle;
//import android.support.annotation.IntRange;
//import android.support.annotation.NonNull;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//
//import com.stepstone.stepper.Step;
//import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter;
//import com.stepstone.stepper.viewmodel.StepViewModel;
//
//public  class MyStepperAdapter extends AbstractFragmentStepAdapter {
//
//    public MyStepperAdapter(FragmentManager fm, Context context) {
//        super(fm, context);
//    }
//
//    @Override
//    public Step createStep(int position) {
//        final StepFragmentSample step = new StepFragmentSample();
//        Bundle b = new Bundle();
//        b.putInt(CURRENT_STEP_POSITION_KEY, position);
//        step.setArguments(b);
//        return step;
//    }
//
//    @Override
//    public int getCount() {
//        return 3;
//    }
//
//    @NonNull
//    @Override
//    public StepViewModel getViewModel(@IntRange(from = 0) int position) {
//        StepViewModel.Builder builder = new StepViewModel.Builder(context)
//                .setTitle(R.string.tab_title);
//        switch (position) {
//            case 0:
//                builder
//                        .setNextButtonLabel("This way")
//                        .setBackButtonLabel("Cancel")
//                        .setNextButtonEndDrawableResId(R.drawable.ms_forward_arrow)
//                        .setBackButtonStartDrawableResId(StepViewModel.NULL_DRAWABLE);
//                break;
//            case 1:
//                builder
//                        .setNextButtonLabel(R.string.go_to_summary)
//                        .setBackButtonLabel("Go to first")
//                        .setBackButtonStartDrawableResId(R.drawable.ms_back_arrow);
//                break;
//            case 2:
//                builder.setBackButtonLabel("Go back");
//                break;
//            default:
//                throw new IllegalArgumentException("Unsupported position: " + position);
//        }
//        return builder.create();
//    }
//}