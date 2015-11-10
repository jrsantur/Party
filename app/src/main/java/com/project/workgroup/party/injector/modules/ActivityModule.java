/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.project.workgroup.party.injector.modules;


import android.content.Context;

import com.project.workgroup.party.injector.Activity;

import dagger.Module;
import dagger.Provides;


@Module
public class ActivityModule {

    private final Context mContext;

    public ActivityModule(Context mContext) {

        this.mContext = mContext;
    }

    @Provides @Activity
    Context provideActivityContext() {
        return mContext;
    }
}
