package com.sera.androidarchitecture.utils;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;

/**
 * Created by Fahmi Hakim on 06/12/2018.
 * for SERA
 */
public class AnimatorHelper {


    public static void startAnim(ObjectAnimator animator, View... view) {

    }

    public static void startAnim(AnimatorSet animatorSet, View... view) {

    }

    public static void playTogether(ObjectAnimator... animator) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(200);
        animatorSet.playTogether(animator);
        animatorSet.start();

    }

    public static void bindView(ObjectAnimator animator, final View view) {

        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                view.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}
