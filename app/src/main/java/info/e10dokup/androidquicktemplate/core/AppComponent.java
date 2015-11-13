package info.e10dokup.androidquicktemplate.core;

import dagger.Component;
import info.e10dokup.androidquicktemplate.MainActivity;

@Component(
        modules = MyModule.class
)
public interface AppComponent {
    void inject(MainActivity mainActivity);
}
