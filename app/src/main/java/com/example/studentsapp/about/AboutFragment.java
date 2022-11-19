package com.example.studentsapp.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.studentsapp.R;

import java.util.ArrayList;
import java.util.List;

public class AboutFragment extends Fragment {
    private ViewPager viewPager;
    private CourseAdapter adapter;
    private List<CourseModel> list;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        list= new ArrayList<>();
        list.add(new CourseModel(R.drawable.ic_baseline_computer_24,"Bachelors in Computer Application","BCA is one of the popular IT related degrees which provides a good foundation of the variety of computer-related courses like Networking, Programming, Database, System and so on. After finishing BCA degree student can easily select any one of the concentration areas and make their career accordingly which is the main advantage of this degree."));
        list.add(new CourseModel(R.drawable.ic_baseline_sick_24,"Counselling and Psycology",  "he Master of Arts in Counseling Psychology degree program is sixty five (65) credit hours, four semester (2 years) course work designed to prepare students as professional counselor in avariety of settings including community. The required core of theory and professional issue classes blend with practicum/fieldwork/internship to integrate the academic and practical aspects of counselor training."));

        adapter = new CourseAdapter(getContext(),list);
        viewPager = view.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);


        //NOthing but just showing images using link and adapter, Tired it but didn't work may be link problem
        ImageView imageView = view.findViewById(R.id.college_image);
//        Glide.with(getContext())
//                .load("gs://my-college-app-df4e8.appspot.com/Homepage/icms.jfif")
//                .into(imageView);

       return  view;
    }
}