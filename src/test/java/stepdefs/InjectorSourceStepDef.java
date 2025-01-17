package stepdefs;

import com.google.inject.Guice;
import com.google.inject.Injector;

import io.cucumber.guice.InjectorSource;

public class InjectorSourceStepDef implements InjectorSource {
    @Override
    public Injector getInjector() {
        return Guice.createInjector();
    }
} 
