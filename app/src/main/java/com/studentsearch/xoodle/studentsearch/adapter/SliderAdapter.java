package com.studentsearch.xoodle.studentsearch.adapter;

/**
 * Created by kaushal on 7/7/17.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.studentsearch.xoodle.studentsearch.R;
import com.studentsearch.xoodle.studentsearch.StudentData;
import java.util.ArrayList;

public class SliderAdapter extends RecyclerView.Adapter<SliderCard> {
  private final int count;
  private final View.OnClickListener listener;
  private Context context;
  private ArrayList<StudentData> studentList;

  public SliderAdapter(Context context, ArrayList<StudentData> studentList, View.OnClickListener listener) {
    this.count = studentList.size();
    this.context = context;
    this.listener = listener;
    this.studentList = studentList;
  }

  @Override
  public SliderCard onCreateViewHolder(ViewGroup parent, int viewType) {
    final View view = LayoutInflater
            .from(parent.getContext())
            .inflate(R.layout.layout_slider_card, parent, false);
    if (listener != null) {
      view.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
          listener.onClick(view);
        }
      });
    }
    return new SliderCard(view, context);
  }

  @Override
  public void onBindViewHolder(SliderCard holder, int position) {
    holder.setContent(position, studentList.get(position));
  }

  @Override
  public void onViewRecycled(SliderCard holder) {
    holder.clearContent();
  }

  @Override
  public int getItemCount() {
    return count;
  }
}