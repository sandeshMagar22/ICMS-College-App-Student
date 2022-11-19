package com.example.studentsapp.faculty;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.studentsapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class FacultyFragment extends Fragment {
    private RecyclerView mpDepartment,economicsDepartment, npDepartment, ajDepartment ;
    private LinearLayout mpNoData,economicsNoData,npNoData,javaNoData;
    private List<TeacherData> list1, list2 , list3, list4;    //4 departments so 4 list
    private DatabaseReference reference , dbRef;
    private TeacherAdapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);

        mpNoData = view.findViewById(R.id.mpNoData);
        economicsNoData = view.findViewById(R.id.economicsNoData);
        npNoData = view.findViewById(R.id.npNoData);
        javaNoData = view.findViewById(R.id.javaNoData);



        mpDepartment = view.findViewById(R.id.mpDepartment);
        economicsDepartment = view.findViewById(R.id.economicsDepartment);
        npDepartment = view.findViewById(R.id.npDepartment);
        ajDepartment = view.findViewById(R.id.ajDepartment);



        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        mpDepartment();
        economicsDepartment();
        npDepartment();
        ajDepartment();

        return view;


    }

    private void mpDepartment() {
        dbRef = reference.child("Mobile Programming");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    mpNoData.setVisibility(View.VISIBLE);
                    mpDepartment.setVisibility(View.GONE);

                }else {
                    mpNoData.setVisibility(View.GONE);
                    mpDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: dataSnapshot.getChildren() ){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    mpDepartment.setHasFixedSize(true);
                    mpDepartment.setLayoutManager(new LinearLayoutManager(getContext()));

                    adapter = new TeacherAdapter(list1,getContext(),"Mobile Programming");
                    mpDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void economicsDepartment() {
        dbRef = reference.child("Economics");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    economicsNoData.setVisibility(View.VISIBLE);
                    economicsDepartment.setVisibility(View.GONE);

                }else {
                    economicsNoData.setVisibility(View.GONE);
                    economicsDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: dataSnapshot.getChildren() ){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    economicsDepartment.setHasFixedSize(true);
                    economicsDepartment.setLayoutManager(new LinearLayoutManager(getContext()));

                    adapter = new TeacherAdapter(list2,getContext(),"Economics");
                    economicsDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void npDepartment() {
        dbRef = reference.child("Network Programming");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    npNoData.setVisibility(View.VISIBLE);
                    npDepartment.setVisibility(View.GONE);

                }else {
                    npNoData.setVisibility(View.GONE);
                    npDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: dataSnapshot.getChildren() ){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    npDepartment.setHasFixedSize(true);
                    npDepartment.setLayoutManager(new LinearLayoutManager(getContext()));

                    adapter = new TeacherAdapter(list3,getContext(),"Network Programming");
                    npDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void ajDepartment() {
        dbRef = reference.child("Advanced Java");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if(!dataSnapshot.exists()){
                    javaNoData.setVisibility(View.VISIBLE);
                    ajDepartment.setVisibility(View.GONE);

                }else {
                    javaNoData.setVisibility(View.GONE);
                    ajDepartment.setVisibility(View.VISIBLE);
                    for(DataSnapshot snapshot: dataSnapshot.getChildren() ){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    ajDepartment.setHasFixedSize(true);
                    ajDepartment.setLayoutManager(new LinearLayoutManager(getContext()));

                    adapter = new TeacherAdapter(list4,getContext(),"Advanced Java");
                    ajDepartment.setAdapter(adapter);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getContext(), databaseError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

}
