package com.project.workgroup.party.mvp.views;

import android.app.ActivityOptions;

import com.project.workgroup.party.model.entities.Event;

import java.util.List;

/**
 * Created by Junior on 10/11/2015.
 */
public interface EventsView extends View {

    void bindEventList(List<Event> events);

    void showEventList();

    void hideEventsList();

    void hideLoadingIndicador();

    void showLoadinView();

    void hideLoadinView();

    void showLightError();

    void showErrorView(String errorMenssage);

    void hideErrorView();

    void showEmptyIndicator();

    void hideEmptyIndicator();

    void updateEventList(int eventsLimit);

    ActivityOptions getActivityOptions (int position, android.view.View clickView);
}
