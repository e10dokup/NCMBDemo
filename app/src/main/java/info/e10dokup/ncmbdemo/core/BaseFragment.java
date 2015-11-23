package info.e10dokup.ncmbdemo.core;

import android.support.v4.app.Fragment;

/**
 * Created by e10dokup on 2015/10/10
 **/
public abstract class BaseFragment extends Fragment {
    private static final String TAG = BaseFragment.class.getSimpleName();
    private final BaseFragment self = this;

    boolean mFirstTime = true;
    boolean mAutoTracking = true;

    public void setAutoTracking(boolean autoTracking) {
        mAutoTracking = autoTracking;
    }

    public String getTrackingParams() {
        return "";
    }

    public void replaceFragment(BaseFragment fragment, boolean recordBackstack) {
        getBaseActivity().replaceFragment(fragment, recordBackstack);
    }

    public void popFragment() {
        getBaseActivity().popFragment();
    }

    public boolean requireAuth() {
        return true;
    }

    public boolean onBackPressed() {
        // Overwrite this!!
        return false;
    }

    public BaseActivity getBaseActivity() {
        return (BaseActivity) getActivity();
    }

}