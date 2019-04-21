package com.shobhit.campusrecruitment_company;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

class AllStudentViewArray extends ArrayAdapter<AllStudentView>

    {
        private Activity context;
        List<AllStudentView> listjobPostingModels;

    public AllStudentViewArray(Activity context, List<AllStudentView> allStudentViews) {
        super(context, R.layout.view_student_layout, allStudentViews);
        this.context = context;
        this.listjobPostingModels = allStudentViews;
    }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(R.layout.view_student_layout, null, true);

        TextView studentName = listViewItem.findViewById(R.id.textViewStudentName);
        TextView studentCollege = listViewItem.findViewById(R.id.textViewStudentCollege);
        TextView studentAggregate = listViewItem.findViewById(R.id.textViewStudentAggregate);
        TextView studentYear = listViewItem.findViewById(R.id.textViewStudentYear);

        AllStudentView allStudentView = listjobPostingModels.get(position);


        studentName.setText(allStudentView.getStudentName());
        studentCollege.setText(allStudentView.getgCollegeNam());
        studentAggregate.setText(allStudentView.getPercent());
        studentYear.setText(allStudentView.getYear());

        return listViewItem;
    }
    }

