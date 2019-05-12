// Generated code from Butter Knife. Do not modify!
package com.example.homedy.Post;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class DialogPostFragment$$ViewInjector<T extends com.example.homedy.Post.DialogPostFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230897, "field '_numberPicker'");
    target._numberPicker = finder.castView(view, 2131230897, "field '_numberPicker'");
  }

  @Override public void reset(T target) {
    target._numberPicker = null;
  }
}
