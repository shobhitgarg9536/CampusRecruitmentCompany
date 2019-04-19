package com.shobhit.campusrecruitment_company;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class JobPosting extends Fragment {

    private DatabaseReference databaseJobs;
    ListView lvJobs;
    List<JobPostingModel> listJobs;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.job_posting, container, false);
        lvJobs = linearLayout.findViewById(R.id.listJobs);

        listJobs = new ArrayList<>();

        databaseJobs = FirebaseDatabase.getInstance().getReference("jobs");
        String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();

        databaseJobs.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                listJobs.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    JobPostingModel jobPostingModel = postSnapshot.getValue(JobPostingModel.class);
                    String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    String companyId = jobPostingModel.getCompanyId();
                    if(userId.equals(companyId))
                    listJobs.add(jobPostingModel);
                }
                //System.out.print("\n\n\n"+listJobs.size());
                JobPostingArray jobPostingArray = new JobPostingArray(getActivity(), listJobs);
                lvJobs.setAdapter(jobPostingArray);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return linearLayout;
    }
}
