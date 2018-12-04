package com.sera.amm.common.dagger;

import com.sera.amm.common.base.BaseApp;

import dagger.Component;

/**
 * Created by Fahmi Hakim on 9/6/17.
 */

@ApplicationScope
@Component(modules = { BaseAppModule.class})
public interface BaseAppComponent {

}
