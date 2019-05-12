// Generated code from Butter Knife. Do not modify!
package com.example.homedy.Search;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class FilterActivity$$ViewInjector<T extends com.example.homedy.Search.FilterActivity> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230774, "field '_searchCityButton'");
    target._searchCityButton = finder.castView(view, 2131230774, "field '_searchCityButton'");
    view = finder.findRequiredView(source, 2131230776, "field '_searchDistrictButton'");
    target._searchDistrictButton = finder.castView(view, 2131230776, "field '_searchDistrictButton'");
    view = finder.findRequiredView(source, 2131230775, "field '_searchCommuneButton'");
    target._searchCommuneButton = finder.castView(view, 2131230775, "field '_searchCommuneButton'");
    view = finder.findRequiredView(source, 2131230781, "field '_searchStreetButton'");
    target._searchStreetButton = finder.castView(view, 2131230781, "field '_searchStreetButton'");
    view = finder.findRequiredView(source, 2131230773, "field '_searchAreaButton'");
    target._searchAreaButton = finder.castView(view, 2131230773, "field '_searchAreaButton'");
    view = finder.findRequiredView(source, 2131230779, "field '_searchPriceButton'");
    target._searchPriceButton = finder.castView(view, 2131230779, "field '_searchPriceButton'");
    view = finder.findRequiredView(source, 2131230780, "field '_searchSortButton'");
    target._searchSortButton = finder.castView(view, 2131230780, "field '_searchSortButton'");
  }

  @Override public void reset(T target) {
    target._searchCityButton = null;
    target._searchDistrictButton = null;
    target._searchCommuneButton = null;
    target._searchStreetButton = null;
    target._searchAreaButton = null;
    target._searchPriceButton = null;
    target._searchSortButton = null;
  }
}
