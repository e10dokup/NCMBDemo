package info.e10dokup.androidquicktemplate.core;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by e10dokup on 2015/10/10
 **/
public abstract class BaseActivity extends AppCompatActivity {
    private static final String TAG = BaseActivity.class.getSimpleName();
    private final BaseActivity self = this;

    public MyApplication getMyApplication() {
        return (MyApplication) getApplication();
    }

    public abstract void replaceFragment(BaseFragment fragment, boolean recordBackstack);

    public abstract void popFragment();

    public void onFragmentResumed(BaseFragment fragment) {
    }
}