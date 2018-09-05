package com.dawn.modules;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LayoutAnimationController;

import com.dawn.R;
import com.util.LogUtil;
import com.view.RecyclerViewItemDecoration;

public class RecycleViewAnimActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_anim);
        recyclerView = findViewById(R.id.anim_recycler);
        RecyclerViewItemDecoration decoration = new RecyclerViewItemDecoration(60, Color.parseColor("#ffffff"));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(decoration);
        adapter = new MyAdapter(recyclerView);
        recyclerView.setAdapter(adapter);

    }

    private void runLayoutAnimation(final RecyclerView recyclerView) {
        final Context context = recyclerView.getContext();
        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down);

        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }


    static class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        private int lastAnimatedPosition = -1;
        private boolean animationsLocked = false;
        private boolean delayEnterAnimation = true;
        private int state;

        private RecyclerView recyclerView;

        public MyAdapter(RecyclerView recyclerView) {
            this.recyclerView = recyclerView;
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    state = newState;
                }

                @Override
                public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                }
            });
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_anim_re_layout, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
//            runEnterAnimation(holder.itemView, position);
            LogUtil.i("===onBindViewHolder=====>");
        }

        @Override
        public void onViewAttachedToWindow(ViewHolder holder) {
            super.onViewAttachedToWindow(holder);
            LogUtil.i("===onViewAttachedToWindow=====>" + holder.getAdapterPosition());
            runEnterAnimation(holder.itemView, holder.getAdapterPosition());
        }

        @Override
        public int getItemCount() {
            return 20;
        }

        class ViewHolder extends RecyclerView.ViewHolder {

            public ViewHolder(View itemView) {
                super(itemView);
            }
        }


        public void runEnterAnimation(View view, int position) {
            if (position > lastAnimatedPosition) {
                view.setTranslationY(100);
            } else {
                view.setTranslationY(-100);

            }
            lastAnimatedPosition = position;

            view.animate()
                    .translationY(0)
                    .setStartDelay(20 * (position) )
                    .setInterpolator(new DecelerateInterpolator(0.5f))
                    .setDuration(700)
                    .start();
        }
    }


}
