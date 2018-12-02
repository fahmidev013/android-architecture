package com.sera.amm.common.dependencyInjection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Reynaldi on 12/5/2016.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ApplicationScope {
}
