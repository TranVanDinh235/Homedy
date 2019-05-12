// Generated code from Butter Knife. Do not modify!
package com.example.homedy.Account;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class AccountFragment$$ViewInjector<T extends com.example.homedy.Account.AccountFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230782, "field '_signoutButton'");
    target._signoutButton = finder.castView(view, 2131230782, "field '_signoutButton'");
    view = finder.findRequiredView(source, 2131230784, "field '_updateButton'");
    target._updateButton = finder.castView(view, 2131230784, "field '_updateButton'");
  }

  @Override public void reset(T target) {
    target._signoutButton = null;
    target._updateButton = null;
  }
}
