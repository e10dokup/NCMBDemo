package info.e10dokup.ncmbdemo.core;

import dagger.Component;
import info.e10dokup.ncmbdemo.MainActivity;
import info.e10dokup.ncmbdemo.fragment.LoginFragment;
import info.e10dokup.ncmbdemo.fragment.SignUpFragment;

@Component(
        modules = MyModule.class
)
public interface AppComponent {
    void inject(MainActivity mainActivity);
}
