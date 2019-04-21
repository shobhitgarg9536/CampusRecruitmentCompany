package com.shobhit.campusrecruitment_company;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class TotalApplicants extends AppCompatActivity {

    private DatabaseReference databasejobs,databaseAppliedJobs;
    ListView lvJobs;
    List<AllStudentView> listJobs;
    String jobId;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.total_applicants);
        lvJobs = findViewById(R.id.listJobs);

        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        if(b!=null)
        {
            jobId =(String) b.get("jobId");
        }
        listJobs = new ArrayList<>();

        //String studentId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        databasejobs = FirebaseDatabase.getInstance().getReference("jobs").child(jobId).child("applied student id");


        databasejobs.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                listJobs.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    System.out.println(postSnapshot.getKey());
                    databaseAppliedJobs = FirebaseDatabase.getInstance().getReference("Students").child(postSnapshot.getKey());

                    databaseAppliedJobs.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            AllStudentView allStudentView = dataSnapshot.getValue(AllStudentView.class);
                            listJobs.add(allStudentView);
                            AllStudentViewArray allStudentViewArray = new AllStudentViewArray(TotalApplicants.this, listJobs);
                            lvJobs.setAdapter(allStudentViewArray);

                            lvJobs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    String studentId = listJobs.get(position).getUserId();
                                    //System.out.println(jobId);
                                    Intent i = new Intent(TotalApplicants.this, ViewAppliedStudentProfile.class);
                                    i.putExtra("studentId",studentId);
                                    startActivity(i);
                                }
                            });
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }



            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}