package info.e10dokup.ncmbdemo;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;

import com.nifty.cloud.mb.core.NCMB;
import com.nifty.cloud.mb.core.NCMBUser;

import info.e10dokup.ncmbdemo.core.BaseActivity;
import info.e10dokup.ncmbdemo.core.BaseFragment;
import info.e10dokup.ncmbdemo.core.MyApplication;
import info.e10dokup.ncmbdemo.fragment.MainFragment;
import info.e10dokup.ncmbdemo.fragment.SignUpFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        { // Inject values
            MyApplication app = (MyApplication) getApplication();
            app.getComponent().inject(this);
        }

        NCMB.initialize(this, getString(R.string.ncmb_app_key), getString(R.string.ncmb_cli_key));

        NCMBUser user = NCMBUser.getCurrentUser();
        if(user.getUserName() == null) {
            replaceFragment(new SignUpFragment(), false);
        } else {
            replaceFragment(new MainFragment(), false);
        }
    }

    @Override
    public void replaceFragment(BaseFragment fragment, boolean recordBackstack) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.container, fragment);
        if (recordBackstack) transaction.addToBackStack(null);
        transaction.commit();
    }

    @Override
    public void popFragment() {
        FragmentManager manager = getSupportFragmentManager();
        manager.popBackStack();
    }
}
