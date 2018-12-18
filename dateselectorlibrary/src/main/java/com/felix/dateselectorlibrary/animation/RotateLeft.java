package com.felix.dateselectorlibrary.animation;

import android.animation.ObjectAnimator;
import android.view.View;


/**
 * Created by lee on 2014/7/31.
 */
public class RotateLeft extends BaseEffects{

    @Override
    protected void setupAnimation(View view) {
        getAnimatorSet().playTogether(
                ObjectAnimator.ofFloat(view, "rotationY", 90, 0).setDuration(mDuration),
                ObjectAnimator.ofFloat(view, "translationX", -300, 0).setDuration(mDuration),
                ObjectAnimator.ofFloat(view, "alpha", 0, 1).setDuration(mDuration*3/2)

        );
    }
}
