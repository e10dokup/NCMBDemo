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

import com.nifty.cloud.mb.core.LoginCallback;
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
public class LoginFragment extends BaseFragment {
    private static final String TAG = LoginFragment.class.getSimpleName();
    private final LoginFragment self = this;

    @Bind(R.id.edit_id)
    EditText mIdEdit;
    @Bind(R.id.edit_pass)
    EditText mPassEdit;
    @Bind(R.id.btn_login)
    Button mLoginButton;
    @Bind(R.id.btn_goto_signup)
    Button mGotoSignUpButton;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this, view);
        mLoginButton.setOnClickListener(mOnClickListener);
        mGotoSignUpButton.setOnClickListener(mGotoButtonListener);

        return view;
    }

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String id = mIdEdit.getText().toString();
            String pass = mPassEdit.getText().toString();
            NCMBUser user = new NCMBUser();
            try{
                user.loginInBackground(id, pass, new LoginCallback() {
                    @Override
                    public void done(NCMBUser ncmbUser, NCMBException e) {
                        if (e != null) {
                            Log.d(TAG, e.getCode());
                        } else {
                            Toast.makeText(getBaseActivity(), "Login succeeded!", Toast.LENGTH_SHORT).show();
                            getBaseActivity().replaceFragment(new MainFragment(), false);
                        }
                    }
                });
            } catch(NCMBException e) {
                Log.d(TAG, e.getCode());
            }

        }
    };

    private View.OnClickListener mGotoButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            getBaseActivity().replaceFragment(new SignUpFragment(), false);
        }
    };
}