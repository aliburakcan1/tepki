package com.tepki.tepki3;

import android.app.Application;

/**
 * Created by x on 08.02.2018.
 */

public class MyApplication extends Application {

    private int someVariable;

    public int getSomeVariable() {
        return someVariable;
    }

    public void setSomeVariable(int someVariable) {
        this.someVariable = someVariable;
    }
}
