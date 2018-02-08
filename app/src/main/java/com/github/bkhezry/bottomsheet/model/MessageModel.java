package com.github.bkhezry.bottomsheet.model;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.github.bkhezry.bottomsheet.R;
import com.mikepenz.fastadapter.items.AbstractItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MessageModel extends AbstractItem<MessageModel, MessageModel.MyViewHolder> {
  private String id;
  private String title;

  public MessageModel(String id, String title) {
    this.id = id;
    this.title = title;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @NonNull
  @Override
  public MyViewHolder getViewHolder(@NonNull View v) {
    return new MessageModel.MyViewHolder(v);
  }

  @Override
  public int getType() {
    return R.id.fastadapter_sampleitem_id;
  }

  @Override
  public void unbindView(@NonNull MessageModel.MyViewHolder holder) {
    super.unbindView(holder);

  }

  @Override
  public int getLayoutRes() {
    return R.layout.recycler_view_item;
  }

  @Override
  public void bindView(@NonNull MessageModel.MyViewHolder viewHolder, @NonNull List<Object> payloads) {
    //call super so the selection is already handled for you
    super.bindView(viewHolder, payloads);
    viewHolder.title.setText(title);
    viewHolder.idText.setText(id);

  }

  class MyViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.title_text_view)
    TextView title;
    @BindView(R.id.id_text_view)
    TextView idText;

    MyViewHolder(View view) {
      super(view);
      ButterKnife.bind(this, view);
    }
  }
}
