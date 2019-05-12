// Generated code from Butter Knife. Do not modify!
package com.example.homedy.Post;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class PostFragment$$ViewInjector<T extends com.example.homedy.Post.PostFragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230832, "field '_newPostButton'");
    target._newPostButton = finder.castView(view, 2131230832, "field '_newPostButton'");
  }

  @Override public void reset(T target) {
    target._newPostButton = null;
  }
}
