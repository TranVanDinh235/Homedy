// Generated code from Butter Knife. Do not modify!
package com.example.homedy.Post;

import android.view.View;
import butterknife.ButterKnife.Finder;
import butterknife.ButterKnife.Injector;

public class DialogPost2Fragment$$ViewInjector<T extends com.example.homedy.Post.DialogPost2Fragment> implements Injector<T> {
  @Override public void inject(final Finder finder, final T target, Object source) {
    View view;
    view = finder.findRequiredView(source, 2131230759, "field '_cammeraDialogButton'");
    target._cammeraDialogButton = finder.castView(view, 2131230759, "field '_cammeraDialogButton'");
    view = finder.findRequiredView(source, 2131230762, "field '_imageFileDialogButton'");
    target._imageFileDialogButton = finder.castView(view, 2131230762, "field '_imageFileDialogButton'");
  }

  @Override public void reset(T target) {
    target._cammeraDialogButton = null;
    target._imageFileDialogButton = null;
  }
}
