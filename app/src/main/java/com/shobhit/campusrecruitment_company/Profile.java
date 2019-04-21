package com.shobhit.campusrecruitment_company;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    TextView tvCompanyName, tvabout, tvaddress, tvcity, tvcontact;
    String companyId;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.company_profile, container, false);

        companyId = FirebaseAuth.getInstance().getCurrentUser().getUid();
        tvCompanyName = linearLayout.findViewById(R.id.textViewjobsCompanyName);
        tvabout = linearLayout.findViewById(R.id.textView4jobCompanyAbout);
        tvaddress = linearLayout.findViewById(R.id.textViewjobCompanyAddress);
        tvcity = linearLayout.findViewById(R.id.textViewjobCompanyCity);
        tvcontact = linearLayout.findViewById(R.id.textViewjobCompanyContact);

        DatabaseReference databaseCompany = FirebaseDatabase.getInstance().getReference("register").child(companyId);

        databaseCompany.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                CompanyProfileModel applyJobModel = dataSnapshot.getValue(CompanyProfileModel.class);
                tvCompanyName.setText(applyJobModel.getName());
                tvcontact.setText(applyJobModel.getContact());
                tvabout.setText(applyJobModel.getAbout());
                tvaddress.setText(applyJobModel.getAddress());
                tvcity.setText(applyJobModel.getCity());

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return linearLayout;
    }
}
