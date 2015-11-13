package info.e10dokup.androidquicktemplate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import info.e10dokup.androidquicktemplate.core.BaseActivity;
import info.e10dokup.androidquicktemplate.core.BaseFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void replaceFragment(BaseFragment fragment, boolean recordBackstack) {

    }

    @Override
    public void popFragment() {

    }
}
