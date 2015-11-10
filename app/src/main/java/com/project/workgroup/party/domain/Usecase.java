package com.project.workgroup.party.domain;

/**
 * Created by Junior on 10/11/2015.
 */

import rx.Observable;

public interface Usecase<T> {
    Observable<T> execute();
}
