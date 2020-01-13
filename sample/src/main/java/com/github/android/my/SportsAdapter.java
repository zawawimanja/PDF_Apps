/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.android.my;

import android.content.Context;
import android.content.Intent;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;

import java.util.ArrayList;

/***
 * The adapter class for the RecyclerView, contains the sports data.
 */
class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.ViewHolder>  {

    public static final String TAG="SportsAdapter";
    private PublisherInterstitialAd interstitialAd;

    // Member variables.
    private ArrayList<Sport> mSportsData;
    private Context mContext;

    /**
     * Constructor that passes in the sports data and the context.
     *
     * @param sportsData ArrayList containing the sports data.
     * @param context Context of the application.
     */
    SportsAdapter(Context context, ArrayList<Sport> sportsData) {
        this.mSportsData = sportsData;
        this.mContext = context;
    }


    /**
     * Required method for creating the viewholder objects.
     *
     * @param parent The ViewGroup into which the new View will be added
     *               after it is bound to an adapter position.
     * @param viewType The view type of the new View.
     * @return The newly created ViewHolder.
     */
    @Override
    public SportsAdapter.ViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(mContext).
                inflate(R.layout.list_item, parent, false));
    }

    /**
     * Required method that binds the data to the viewholder.
     *
     * @param holder The viewholder into which the data should be put.
     * @param position The adapter position.
     */
    @Override
    public void onBindViewHolder(SportsAdapter.ViewHolder holder,
                                 int position) {
        // Get current sport.
        Sport currentSport = mSportsData.get(position);

        // Populate the textviews with data.
        holder.bindTo(currentSport);
    }

    /**
     * Required method for determining the size of the data set.
     *
     * @return Size of the data set.
     */
    @Override
    public int getItemCount() {
        return mSportsData.size();
    }


    /**
     * ViewHolder class that represents each row of data in the RecyclerView.
     */
    class ViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener{

        // Member Variables for the TextViews
        private TextView mTitleText;
        private TextView mInfoText;


        /**
         * Constructor for the ViewHolder, used in onCreateViewHolder().
         *
         * @param itemView The rootview of the list_item.xml layout file.
         */
        ViewHolder(View itemView) {
            super(itemView);

            // Initialize the views.
            mTitleText = itemView.findViewById(R.id.title);

            // Set the OnClickListener to the entire view.
            itemView.setOnClickListener(this);
        }

        void bindTo(Sport currentSport){
            // Populate the textviews with data.
            mTitleText.setText(currentSport.getTitle());

        }

        /**
         * Handle click to show DetailActivity.
         *
         * @param view View that is clicked.
         */
        @Override
        public void onClick(View view) {
            Sport currentSport = mSportsData.get(getAdapterPosition());
          String value=  currentSport.getTitle();
          Log.i(TAG,value);

          if(value.contains("30 Panduan Saham")){
              Intent detailIntent = new Intent(mContext, PDFViewActivity_.class);
              mContext.startActivity(detailIntent);
          }
          else  if(value.contains("Nota ST ZZFY")){
              Intent detailIntent = new Intent(mContext, Main3Activity_.class);
              mContext.startActivity(detailIntent);
          }

          else  if(value.contains("Rahsia Saham Nizam Malek")){
              Intent detailIntent = new Intent(mContext, Main4Activity_.class);
              mContext.startActivity(detailIntent);
          }


          else  if(value.contains("Sembang Asri Ahmad")){
              Intent detailIntent = new Intent(mContext, Main5Activity_.class);
              mContext.startActivity(detailIntent);
          }
          else  if(value.contains("Panduan Asas Saham")){
              Intent detailIntent = new Intent(mContext, Main6Activity_.class);
              mContext.startActivity(detailIntent);
          }
          else  if(value.contains("Tips Melabur Saham FY")){
              Intent detailIntent = new Intent(mContext, Main7Activity_.class);
              mContext.startActivity(detailIntent);
          }

          else  if(value.contains("Panduan Melabur di Bursa")){
              Intent detailIntent = new Intent(mContext, Main8Activity_.class);
              mContext.startActivity(detailIntent);
          }




        }
    }
}
