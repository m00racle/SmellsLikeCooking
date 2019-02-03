package com.mooracle.smellslikecooking.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;

public class Fold extends Visibility {
    @Override
    public Animator onAppear(ViewGroup sceneRoot, View view, TransitionValues startValues, TransitionValues endValues) {
        return createFoldAnimator(view, false);
    }

    @Override
    public Animator onDisappear(ViewGroup sceneRoot, View view, TransitionValues startValues, TransitionValues endValues) {
        return createFoldAnimator(view, true);
    }

    private Animator createFoldAnimator(View view, Boolean folding){
        //setting the start condition:
        int start = view.getTop();

        //setting the end condition of the animation:
        int end = view.getTop() + view.getMeasuredHeight() - 1;

        //check if the view is folded or not:
        if (folding){
            int temp = start;
            start = end;
            end = temp;
        }

        //set the initial condition:
        view.setBottom(start);

        return ObjectAnimator.ofInt(view, "bottom", start, end);
    }
}
