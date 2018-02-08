package com.github.bkhezry.bottomsheet.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.bkhezry.bottomsheet.R;
import com.github.bkhezry.bottomsheet.model.MessageModel;
import com.mikepenz.fastadapter.commons.adapters.FastItemAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutFragment extends Fragment {
  @BindView(R.id.recycler_view)
  RecyclerView recyclerView;
  private FastItemAdapter<MessageModel> fastItemAdapter;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_about,
      container, false);
    ButterKnife.bind(this, view);
    RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 1);
    recyclerView.setLayoutManager(mLayoutManager);
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    recyclerView.setNestedScrollingEnabled(false);
    fastItemAdapter = new FastItemAdapter<>();
    recyclerView.setAdapter(fastItemAdapter);
    generateData();
    return view;
  }

  private void generateData() {
    fastItemAdapter.clear();

    fastItemAdapter.add(new MessageModel("1- ", "android-image-picker"));
    fastItemAdapter.add(new MessageModel("2- ", "Android-ObservableScrollView"));
    fastItemAdapter.add(new MessageModel("3- ", "android-oss"));
    fastItemAdapter.add(new MessageModel("4- ", "Android-ReactiveLocation"));
    fastItemAdapter.add(new MessageModel("5- ", "android-slidingactivity"));
    fastItemAdapter.add(new MessageModel("6- ", "AndroidTagView"));
    fastItemAdapter.add(new MessageModel("7- ", "AndroidViewAnimations"));
    fastItemAdapter.add(new MessageModel("8- ", "android_connectionbuddy"));
    fastItemAdapter.add(new MessageModel("9- ", "AppIntro"));
    fastItemAdapter.add(new MessageModel("10- ", "AppUpdater"));
    fastItemAdapter.add(new MessageModel("11- ", "Baboon"));
  }

  public Fragment newInstance(String title) {
    Fragment basic = new AboutFragment();
    Bundle bundle = new Bundle();
    bundle.putString("title", title);
    basic.setArguments(bundle);
    return basic;
  }
}
