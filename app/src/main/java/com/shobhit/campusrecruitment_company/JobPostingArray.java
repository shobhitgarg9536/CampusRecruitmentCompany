package com.shobhit.campusrecruitment_company;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import java.util.List;

public class JobPostingArray  extends ArrayAdapter<JobPostingModel> {
    private Activity context;
    List<JobPostingModel> listjobPostingModels;

    public JobPostingArray(Activity context, List<JobPostingModel> jobPostingModels) {
        super(context, R.layout.company_job_layout, jobPostingModels);
        this.context = context;
        this.listjobPostingModels = jobPostingModels;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.company_job_layout, null, true);

        TextView companyName = listViewItem.findViewById(R.id.textViewJobCompanyname);
        TextView vacancyName = listViewItem.findViewById(R.id.textViewJobVacancyName);
        TextView noOfVacancy = listViewItem.findViewById(R.id.textViewJobNoOfVacancy);
        TextView dateOfInterview = listViewItem.findViewById(R.id.textViewJobDateOfInterview);

        JobPostingModel jobPostingModel = listjobPostingModels.get(position);


        companyName.setText(jobPostingModel.getCompanyName());
        vacancyName.setText(jobPostingModel.getVacancyName());
        noOfVacancy.setText(jobPostingModel.getNoOfVacancy());
        dateOfInterview.setText(jobPostingModel.getDateOfInterview());

        return listViewItem;
    }
}

