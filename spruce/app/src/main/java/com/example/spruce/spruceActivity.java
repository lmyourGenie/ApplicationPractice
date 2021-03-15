package com.example.spruce;

import android.app.Activity;
import android.app.AppComponentFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.willowtreeapps.spruce.Spruce;
import com.willowtreeapps.spruce.SpruceAnimator;
import com.willowtreeapps.spruce.animation.DefaultAnimations;
import com.willowtreeapps.spruce.sort.DefaultSort;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.inflate;

public class spruceActivity extends AppCompatActivity {

    private ListView listView;
    private SpruceAnimator spruceAnimator;

    public static spruceActivity newInstance() {
        return new spruceActivity();
    }

    @Nullable
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_view);

        listView = findViewById(R.id.list_view);

        // Create the animator after the list view has finished laying out
        listView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                initSpruce();
            }
        });

        // Mock data objects
        List<ExampleData> placeHolderList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            placeHolderList.add(new ExampleData());
        }

        // Remove default dividers and set adapter
        listView.setDivider(null);
        listView.setDividerHeight(0);
        listView.setAdapter(new ListViewAdapter(placeHolderList));

        //return inflate(R.layout.list_view, container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (spruceAnimator != null) {
            spruceAnimator.start();
        }
    }

    private void initSpruce() {
        spruceAnimator = new Spruce.SpruceBuilder(listView)
                .sortWith(new DefaultSort(100))
                .animateWith(DefaultAnimations.dynamicFadeIn(listView),
                        DefaultAnimations.dynamicTranslationUpwards(listView))
                .start();
    }


    private class ListViewAdapter extends BaseAdapter {

        private final List<ExampleData> placeholderList;
        private final LayoutInflater inflater;

        ListViewAdapter(List<ExampleData> placeholderList) {
            this.placeholderList = placeholderList;
            this.inflater = LayoutInflater.from(getApplicationContext());
        }

        @Override
        public int getCount() {
            return placeholderList.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View vi = convertView;
            ViewHolder vh;

            if (convertView == null) {
                vi = inflater.inflate(R.layout.view_placeholder, null);
                vh = new ViewHolder((RelativeLayout) vi);
                vi.setTag(vh);
            }

            return vi;
        }

        class ViewHolder implements View.OnClickListener {

            private final RelativeLayout parent;

            ViewHolder(RelativeLayout parent) {
                this.parent = parent;
                this.parent.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                initSpruce();
            }
        }
    }

}
