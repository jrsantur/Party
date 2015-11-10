package com.project.workgroup.party.mvp.presenter;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;

import com.project.workgroup.party.R;
import com.project.workgroup.party.domain.GetEventsUsecase;
import com.project.workgroup.party.model.entities.Event;
import com.project.workgroup.party.model.rest.exceptions.NetworkErrorException;
import com.project.workgroup.party.model.rest.exceptions.ServerErrorException;
import com.project.workgroup.party.mvp.views.EventsView;
import com.project.workgroup.party.mvp.views.View;
import com.project.workgroup.party.views.RecyclerClickListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Subscription;

/**
 * Created by Junior on 10/11/2015.
 */
public class EventListPresenter implements Presenter, RecyclerClickListener {

    private final GetEventsUsecase mGetEventsUsecase;
    private final Context mContext;
    private boolean  mIsTheEventRequestRunning;
    private Subscription mEventsSubscription;

    private List<Event> mEvents;
    private EventsView mEventsView;
    private Intent mIntent;

    @Inject
    public EventListPresenter(Context context , GetEventsUsecase eventsUsecase){
        mContext = context;
        mGetEventsUsecase = eventsUsecase;
        mEvents = new ArrayList<>();
    }

    @Override
    public void onCreate() {
        askForEvents();
    }

    @Override
    public void onPause() {
        mEventsSubscription.unsubscribe();
        mIsTheEventRequestRunning = false;
    }


    @Override
    public void attachView(View v) {
        mEventsView = (EventsView) v;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void attachIncomingIntent(Intent intent) {

    }


    @SuppressWarnings("Convert2MethodRef")
    private void askForEvents() {
        mIsTheEventRequestRunning = true;
        showLoadingUI();

        mEventsSubscription = mGetEventsUsecase.execute().subscribe(events ->{
            mEvents.addAll(events);
            mEventsView.showEventList();
            mEventsView.hideEmptyIndicator();
            mIsTheEventRequestRunning = false;
        }, error ->showErrorView(error));
    }


    private void showLoadingUI() {
        mEventsView.hideErrorView();
        mEventsView.showLoadinView();
    }

    private void showErrorView(Throwable error) {
        if(error instanceof NetworkErrorException){
            String errorMessage = mContext.getString(R.string.error_network_uknownhost);
            mEventsView.showErrorView(errorMessage);
        }else if(error instanceof ServerErrorException){
            String errorMessage = mContext.getString(R.string.error_network_marvel_server);
            mEventsView.showErrorView(errorMessage);
        }
        mEventsView.hideEmptyIndicator();
        mEventsView.hideEventsList();
    }

    private void showGenericError(){
        mEventsView.hideLoadingIndicador();
        mEventsView.showLightError();
    }


    @Override
    public void onElementClick(int position, android.view.View sharedView, ImageView characterImageView) {


    }
}
