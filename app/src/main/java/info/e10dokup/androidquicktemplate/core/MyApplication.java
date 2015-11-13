package info.e10dokup.androidquicktemplate.core;

import android.app.Application;

/**
 * Created by e10dokup on 2015/10/09
 **/
public class MyApplication extends Application{
    private static final String TAG = MyApplication.class.getSimpleName();
    private final MyApplication self = this;

    private AppComponent mComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mComponent = DaggerAppComponent.builder()
                .myModule(new MyModule(this))
                .build();
        // mComponent.injectApplication(this);
    }

    public AppComponent getComponent() {
        return mComponent;
    }
}