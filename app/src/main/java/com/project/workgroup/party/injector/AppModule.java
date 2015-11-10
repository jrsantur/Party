package com.project.workgroup.party.injector;

import com.project.workgroup.party.PartyApplication;
import com.project.workgroup.party.model.repository.Repository;
import com.project.workgroup.party.model.rest.RestRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Junior on 10/11/2015.
 */
@Module
public class AppModule {

    private final PartyApplication mPartyApplication;

    public AppModule(PartyApplication partyApplication){
        this.mPartyApplication = partyApplication;
    }

    @Provides @Singleton PartyApplication providerPartyApplication(){
        return mPartyApplication;
    }
    @Provides @Singleton
    Repository providerDataRepository (RestRepository restRepository){
        return restRepository;
    }

}
