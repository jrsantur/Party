package com.project.workgroup.party.injector.components;

import com.project.workgroup.party.PartyApplication;
import com.project.workgroup.party.injector.AppModule;
import com.project.workgroup.party.model.repository.Repository;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Junior on 10/11/2015.
 */
@Singleton @Component (modules = AppModule.class)
public interface AppComponent {
    PartyApplication app();
    Repository dataRepository();
}
