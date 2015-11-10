package com.project.workgroup.party.model.repository;

import com.project.workgroup.party.model.entities.Event;

import java.util.List;

import rx.Observable;

/**
 * Created by Junior on 10/11/2015.
 */
public interface Repository {

    Observable<Event> getEvent(final int eventId);
    Observable<List<Event>> getEvents();
}
