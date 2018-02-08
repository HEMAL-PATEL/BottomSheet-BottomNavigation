package com.github.bkhezry.bottomsheet.fragment;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;

import com.github.bkhezry.bottomsheet.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BasicFragment extends Fragment {
  @BindView(R.id.title_text_view)
  AppCompatTextView titleTextView;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_basic,
      container, false);
    ButterKnife.bind(this, view);
    String title = getArguments().getString("title");
    titleTextView.setText(title);
    return view;
  }

  public Fragment newInstance(String title) {
    Fragment basic = new BasicFragment();
    Bundle bundle = new Bundle();
    bundle.putString("title", title);
    basic.setArguments(bundle);
    return basic;
  }
}
