package com.project.workgroup.party.injector.components;

import android.content.Context;

import com.project.workgroup.party.injector.modules.ActivityModule;

import dagger.Component;
import com.project.workgroup.party.injector.Activity;
import com.project.workgroup.party.views.activities.MainActivity;

/**
 * Created by Junior on 10/11/2015.
 */
@Activity
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class})
public interface EventsComponent extends ActivityComponent {
    void inject (MainActivity activity);

    Context activityContext();
}
