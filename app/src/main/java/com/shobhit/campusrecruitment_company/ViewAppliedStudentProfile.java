package com.shobhit.campusrecruitment_company;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewAppliedStudentProfile extends AppCompatActivity {

    TextView etstudentName, etage, etcontact, ethspercent, ethsyear, ethsboard, etSPercent, etSyear, etSBoard,
            etGCollegeNam , etGbranch , etCourse, etUniversity, etPercent, etYear, etback, etSkills;

    String studentId="";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_student_profile);

        Intent iin= getIntent();
        Bundle b = iin.getExtras();
        if(b!=null)
        {
            studentId =(String) b.get("companyId");
        }

        etstudentName = findViewById(R.id.textViewViewStudentName);
        etage = findViewById(R.id.textViewViewStudentAge);
        etcontact = findViewById(R.id.textViewViewStudentContact);
        ethspercent = findViewById(R.id.textViewViewStudentHPercent);
        ethsyear = findViewById(R.id.textViewViewStudentHYear);
        ethsboard = findViewById(R.id.textViewViewStudentHBoard);
        etSPercent = findViewById(R.id.textViewViewStudentSPercent);
        etSyear = findViewById(R.id.textViewViewStudentSYear);
        etSBoard = findViewById(R.id.textViewViewStudentSBoard);
        etGCollegeNam = findViewById(R.id.textViewViewStudentCollege);
        etGbranch = findViewById(R.id.textViewViewStudentBranch);
        etCourse = findViewById(R.id.textViewViewStudentCourse);
        etUniversity = findViewById(R.id.textViewViewStudentUniversity);
        etPercent = findViewById(R.id.textViewViewStudentPercent);
        etYear = findViewById(R.id.textViewViewStudentYear);
        etback = findViewById(R.id.textViewViewStudentBacks);
        etSkills = findViewById(R.id.textViewViewStudentSkills);


        DatabaseReference databaseRegister = FirebaseDatabase.getInstance().getReference("Students").child(studentId);

        System.out.println(studentId);
        databaseRegister.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                AllStudentView allStudentView = dataSnapshot.getValue(AllStudentView.class);
                System.out.println(allStudentView.getAge());
                System.out.println(allStudentView.getContact());
                System.out.println(allStudentView.getBack());
                etstudentName.setText( allStudentView.getStudentName());
                etage.setText(allStudentView.getAge());
                etcontact.setText(allStudentView.getContact());
                ethspercent.setText( allStudentView.getHspercent());
                ethsyear.setText(allStudentView.getHsyear());
                ethsboard.setText(allStudentView.getHsboard());
                etSPercent.setText( allStudentView.getsPercent());
                etSyear.setText(allStudentView.getSyear());
                etSBoard.setText(allStudentView.getgBoard());
                etGCollegeNam.setText(allStudentView.getgCollegeNam());
                etGbranch.setText( allStudentView.getGbranch());
                etCourse.setText(allStudentView.getCourse());
                etUniversity.setText(allStudentView.getUniversity());
                etPercent.setText(allStudentView.getPercent());
                etYear.setText( allStudentView.getYear());
                etback.setText(allStudentView.getBack());
                etSkills.setText(allStudentView.getSkills());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
