package com.github.bkhezry.bottomsheet.adapter;

import android.support.v4.app.Fragment;

import com.aspsine.fragmentnavigator.FragmentNavigatorAdapter;

import com.github.bkhezry.bottomsheet.fragment.AboutFragment;
import com.github.bkhezry.bottomsheet.fragment.BasicFragment;

public class FragmentAdapter implements FragmentNavigatorAdapter {
  private static final String TABS[] = {"Basic", "Search", "About"};

  @Override
  public Fragment onCreateFragment(int position) {
    Fragment mFragment = null;
    switch (position) {
      case 0:
        mFragment = new BasicFragment().newInstance(getTag(position));
        break;
      case 1:
        mFragment = new BasicFragment().newInstance(getTag(position));
        break;
      case 2:
        mFragment = new AboutFragment().newInstance(getTag(position));
        break;
    }
    return mFragment;
  }

  @Override
  public String getTag(int position) {
    return TABS[position];
  }

  @Override
  public int getCount() {
    return TABS.length;
  }
}
