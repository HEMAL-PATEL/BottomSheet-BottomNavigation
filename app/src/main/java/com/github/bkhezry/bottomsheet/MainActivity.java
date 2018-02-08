package com.github.bkhezry.bottomsheet;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.aspsine.fragmentnavigator.FragmentNavigator;

import com.github.bkhezry.bottomsheet.adapter.FragmentAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

  @BindView(R.id.bottom_sheet)
  View layoutBottomSheet;
  @BindView(R.id.navigation)
  BottomNavigationView navigation;

  private FragmentNavigator fragmentNavigator;
  private BottomSheetBehavior sheetBehavior;

  public BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
    = new BottomNavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
      sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
      switch (item.getItemId()) {
        case R.id.navigation_basic:
          fragmentNavigator.showFragment(0);
          break;
        case R.id.navigation_list:
          fragmentNavigator.showFragment(1);
          break;
        case R.id.navigation_about:
          fragmentNavigator.showFragment(2);
          break;
      }
      return true;
    }

  };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    Toolbar toolbar = findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    fragmentNavigator = new FragmentNavigator(getSupportFragmentManager(), new FragmentAdapter(), R.id.contentFrameLayout);
    navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    fragmentNavigator.showFragment(0);

    sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);
    sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
      @Override
      public void onStateChanged(@NonNull View bottomSheet, int newState) {
        switch (newState) {
          case BottomSheetBehavior.STATE_HIDDEN:
            break;
          case BottomSheetBehavior.STATE_EXPANDED:
            break;
          case BottomSheetBehavior.STATE_COLLAPSED:
            break;
          case BottomSheetBehavior.STATE_DRAGGING:
            break;
          case BottomSheetBehavior.STATE_SETTLING:
            break;
        }
      }

      @Override
      public void onSlide(@NonNull View bottomSheet, float slideOffset) {
      }
    });
  }

  /**
   * manually opening / closing bottom sheet on linear layout click
   */
  @OnClick(R.id.linear_layout)
  public void toggleBottomSheet() {
    if (sheetBehavior.getState() != BottomSheetBehavior.STATE_HIDDEN) {
      sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
    } else {
      sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }
  }
}
