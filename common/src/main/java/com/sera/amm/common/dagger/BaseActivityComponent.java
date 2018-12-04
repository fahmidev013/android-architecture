package com.sera.amm.common.dagger;

import dagger.Component;

/**
 * Created by Fahmi Hakim on 03/12/2018.
 * for SERA
 */

@ActivityScope
@Component(dependencies = BaseAppComponent.class, modules = BaseActivityModule.class)
public interface BaseActivityComponent {

}
