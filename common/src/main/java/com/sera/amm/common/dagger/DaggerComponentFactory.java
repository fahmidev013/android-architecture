package com.sera.amm.common.dagger;

/**
 * Created by Fahmi Hakim on 9/6/17.
 */

public interface DaggerComponentFactory<T> {
  T makeComponent();
}