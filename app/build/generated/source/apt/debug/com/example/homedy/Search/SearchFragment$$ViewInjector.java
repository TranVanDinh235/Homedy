// Generated code from Butter Knife. Do not modify!
package com.example.homedy.Search;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class SearchFragment$$ViewInjector<T extends com.example.homedy.Search.SearchFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230777, "field '_filterButton'");
    target._filterButton = finder.castView(view, 2131230777, "field '_filterButton'");
  }

  @Override public void reset(T target) {
    target._filterButton = null;
  }
}
