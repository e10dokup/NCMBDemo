package info.e10dokup.ncmbdemo.core;

import android.content.Context;
import android.support.annotation.NonNull;

import dagger.Module;

/**
 * Created by e10dokup on 2015/10/09
 **/
@Module
public class MyModule {
    private static final String TAG = MyModule.class.getSimpleName();
    private final MyModule self = this;

    private Context mContext;

    public MyModule(@NonNull Context context) {
        mContext = context;
    }
}