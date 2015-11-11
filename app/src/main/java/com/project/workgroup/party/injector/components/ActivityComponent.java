package com.project.workgroup.party.injector.components;

import android.content.Context;

import com.project.workgroup.party.injector.Activity;
import com.project.workgroup.party.injector.modules.ActivityModule;

import dagger.Component;

/**
 * Created by Junior on 10/11/2015.
 */
@Activity
@Component(dependencies = AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    Context context();
}
