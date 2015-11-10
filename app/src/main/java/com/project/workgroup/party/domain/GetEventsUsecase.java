package com.project.workgroup.party.domain;

import com.project.workgroup.party.model.entities.Event;
import com.project.workgroup.party.model.repository.Repository;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Junior on 10/11/2015.
 */
public class GetEventsUsecase implements Usecase<List<Event>> {

    public final static int EVENTS_lIMIT = 35;
    private final Repository mRepository;

    @Inject public GetEventsUsecase(Repository repository){
        mRepository = repository;
    }

    @Override
    public Observable<List<Event>> execute() {
        return mRepository.getEvents().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
    }


}
