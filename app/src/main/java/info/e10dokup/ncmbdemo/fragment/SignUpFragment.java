package info.e10dokup.ncmbdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.nifty.cloud.mb.core.DoneCallback;
import com.nifty.cloud.mb.core.NCMBException;
import com.nifty.cloud.mb.core.NCMBUser;

import butterknife.Bind;
import butterknife.ButterKnife;
import info.e10dokup.ncmbdemo.R;
import info.e10dokup.ncmbdemo.core.BaseFragment;
import info.e10dokup.ncmbdemo.core.MyApplication;

/**
 * Created by e10dokup on 2015/11/20
 **/
public class SignUpFragment extends BaseFragment {
    private static final String TAG = SignUpFragment.class.getSimpleName();
    private final SignUpFragment self = this;

    @Bind(R.id.edit_id)
    EditText mIdEdit;
    @Bind(R.id.edit_pass)
    EditText mPassEdit;
    @Bind(R.id.btn_signup)
    Button mSignUpButton;
    @Bind(R.id.btn_goto_login)
    Button mGotoLoginButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_signup, container, false);

        { // Inject values
            MyApplication app = (MyApplication) getBaseActivity().getMyApplication();
            app.getComponent().inject(this);
        }

        ButterKnife.bind(this, view);
        mSignUpButton.setOnClickListener(mOnClickListener);
        mGotoLoginButton.setOnClickListener(mGotoButtonListener);

        return view;
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String id = mIdEdit.getText().toString();
            String pass = mPassEdit.getText().toString();
            NCMBUser user = new NCMBUser();
            user.setUserName(id);
            user.setPassword(pass);
            user.signUpInBackground(new DoneCallback() {
                @Override
                public void done(NCMBException e) {
                    if (e != null) {
                        Log.d(TAG, e.getCode());
                    } else {
                        Toast.makeText(getBaseActivity(), "Sign up succeeded!", Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    };

    private View.OnClickListener mGotoButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            getBaseActivity().replaceFragment(new LoginFragment(), false);
        }
    };
}