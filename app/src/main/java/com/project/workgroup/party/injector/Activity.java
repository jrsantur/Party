package com.project.workgroup.party.injector;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Junior on 10/11/2015.
 */
@Scope
@Retention(RUNTIME)
public @interface Activity {}
