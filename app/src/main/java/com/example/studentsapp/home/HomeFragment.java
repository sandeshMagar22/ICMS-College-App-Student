package com.example.studentsapp.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.studentsapp.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;


public class HomeFragment extends Fragment {

    private SliderLayout sliderLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        sliderLayout = view.findViewById(R.id.slider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(1);

        setSliderViews();
        return view;
    }
   //For 5 of the images
    private void setSliderViews() {
        for(int i =0; i<5; i++){
            DefaultSliderView sliderView = new DefaultSliderView(getContext());
            switch(i){
                case 0:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-college-app-df4e8.appspot.com/o/Homepage%2Fgate.jpg?alt=media&token=dc04c031-e73d-47df-b12b-f7913aeb6e26");
                    break;

                case 1:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-college-app-df4e8.appspot.com/o/Homepage%2Fbca.jfif?alt=media&token=b8122c85-18d3-4d89-912f-3453529f645c");
                    break;

                case 2:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-college-app-df4e8.appspot.com/o/Homepage%2Fprachanda.jpg?alt=media&token=a4486924-8af4-4832-bf9e-78e4f0d1be7a");
                    break;

                case 3:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-college-app-df4e8.appspot.com/o/Homepage%2FGPkoirala.jpg?alt=media&token=06122339-99ad-4839-89ed-03a583c7757f");
                    break;

                case 4:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-college-app-df4e8.appspot.com/o/Homepage%2Ftihar.jpg?alt=media&token=519893d0-9dd7-45a7-9817-6d2d1184fbb0");
                    break;

            }
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);

            sliderLayout.addSliderView(sliderView);

        }
    }
}