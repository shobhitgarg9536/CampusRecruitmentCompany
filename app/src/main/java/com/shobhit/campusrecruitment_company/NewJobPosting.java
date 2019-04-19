package com.shobhit.campusrecruitment_company;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class NewJobPosting  extends Fragment {

    EditText etContactPerson, etNoOfVacancy, etVacancyName, etPostName, etDateOfInterview;
    Button btPostJob;

    String contactPerson, noOfVacancy, vacancyName, postName, dateOfInterview;

    private DatabaseReference databaseJobs;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.new_job_posting, container, false);
        etContactPerson = linearLayout.findViewById(R.id.editTextContactPerson);
        etNoOfVacancy = linearLayout.findViewById(R.id.editTextNoOfVacancy);
        etVacancyName = linearLayout.findViewById(R.id.editTextVacancyName);
        etPostName = linearLayout.findViewById(R.id.editTextPostName);
        etDateOfInterview = linearLayout.findViewById(R.id.editTextDateOfInterView);
        btPostJob = linearLayout.findViewById(R.id.buttonPostJob);

        databaseJobs = FirebaseDatabase.getInstance().getReference("jobs");

        btPostJob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactPerson = etContactPerson.getText().toString();
                noOfVacancy = etNoOfVacancy.getText().toString();
                vacancyName = etVacancyName.getText().toString();
                postName = etPostName.getText().toString();
                dateOfInterview = etDateOfInterview.getText().toString();
                if(!TextUtils.isEmpty(contactPerson) && !TextUtils.isEmpty(noOfVacancy) && !TextUtils.isEmpty(vacancyName) &&
                        !TextUtils.isEmpty(postName) && !TextUtils.isEmpty(dateOfInterview) ){
                    String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    NewJobPostingModel newJobPostingModel = new NewJobPostingModel(userId, contactPerson,vacancyName,postName,
                                                                                 noOfVacancy,dateOfInterview);
                    String id = databaseJobs.push().getKey();
                    databaseJobs.child(id).setValue(newJobPostingModel);
                   // startActivity(new Intent(getApplicationContext(), CompanyNavbar.class));

                }
            }
        });

        return linearLayout;
    }
}
