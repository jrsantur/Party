package com.project.workgroup.party.views.fragments;


import android.app.ActivityOptions;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.project.workgroup.party.R;
import com.project.workgroup.party.model.entities.Event;
import com.project.workgroup.party.mvp.presenter.EventListPresenter;
import com.project.workgroup.party.mvp.views.EventsView;
import com.project.workgroup.party.views.RecyclerClickListener;

import java.util.List;

import javax.inject.Inject;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EventsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EventsFragment extends Fragment  implements EventsView, RecyclerClickListener{


    @Inject
    EventListPresenter eventListPresenter;


    public static EventsFragment newInstance(String param1, String param2) {
        EventsFragment fragment = new EventsFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializePresenter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_eents, container, false);
    }


    @Override
    public void bindEventList(List<Event> events) {
    }


    @Override
    public void showEventList() {

    }

    @Override
    public void hideEventsList() {

    }

    @Override
    public void hideLoadingIndicador() {

    }

    @Override
    public void showLoadinView() {

    }

    @Override
    public void hideLoadinView() {

    }

    @Override
    public void showLightError() {

    }

    @Override
    public void showErrorView(String errorMenssage) {

    }

    @Override
    public void hideErrorView() {

    }

    @Override
    public void showEmptyIndicator() {

    }

    @Override
    public void hideEmptyIndicator() {

    }

    @Override
    public void updateEventList(int eventsLimit) {

    }

    @Override
    public ActivityOptions getActivityOptions(int position, View clickView) {
        return null;
    }

    @Override
    public void onElementClick(int position, View sharedView, ImageView characterImageView) {

    }

    private void initializePresenter(){
        eventListPresenter.attachView(this);
        eventListPresenter.onCreate();
    }
}
