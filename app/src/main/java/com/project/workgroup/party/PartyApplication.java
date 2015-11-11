package com.project.workgroup.party;

import android.app.Application;

import com.project.workgroup.party.injector.AppModule;
import com.project.workgroup.party.injector.components.AppComponent;


/**
 * Created by Junior on 10/11/2015.
 */
public class PartyApplication extends Application {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {

        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector() {

        mAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public AppComponent getAppComponent() {

        return mAppComponent;
    }
}
