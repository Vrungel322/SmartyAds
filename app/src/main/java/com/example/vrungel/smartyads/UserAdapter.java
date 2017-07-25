package com.example.vrungel.smartyads;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.example.vrungel.smartyads.data.UserModel;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vrungel on 25.07.2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserAdapterViewHolder> {

  private ArrayList<UserModel> mUserModels = new ArrayList<>();

  public void addListUserModels(List<UserModel> goodsEntities) {
    //mUserModels.clear();
    mUserModels.addAll(goodsEntities);
    notifyDataSetChanged();
  }

  @Override public UserAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new UserAdapterViewHolder(
        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false));
  }

  @Override public void onBindViewHolder(UserAdapterViewHolder holder, int position) {
    holder.mTextViewName.setText(mUserModels.get(position).getName());
    holder.mTextViewSurname.setText(mUserModels.get(position).getSurname());
  }

  @Override public int getItemCount() {
    return mUserModels.size();
  }

  static class UserAdapterViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tvName) TextView mTextViewName;
    @BindView(R.id.tvSurname) TextView mTextViewSurname;

    UserAdapterViewHolder(View view) {
      super(view);
      ButterKnife.bind(this, view);
    }
  }
}
