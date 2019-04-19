package com.shobhit.campusrecruitment_company;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CompanyDetails extends AppCompatActivity {

    EditText etCompanyName, etabout, etContact, etCity, etAddress;
    Button btregister;
    String companyName, about, contact, city, address;

    SharedPreferences sharedPreferences;
    String SHARED_PREFS = "Shared_Register";

    private DatabaseReference databaseRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.company_details);

        etCompanyName = findViewById(R.id.editTextCompanyName);
        etAddress = findViewById(R.id.editTextAddress);
        etCity = findViewById(R.id.editTextCity);
        etContact = findViewById(R.id.editTextContact);
        etabout = findViewById(R.id.editTextAbout);

        btregister = findViewById(R.id.buttonRegister);

        databaseRegister = FirebaseDatabase.getInstance().getReference("register");

        btregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                companyName = etCompanyName.getText().toString();
                address = etAddress.getText().toString();
                about = etabout.getText().toString();
                city = etCity.getText().toString();
                contact = etContact.getText().toString();

                if (!TextUtils.isEmpty(companyName) && !TextUtils.isEmpty(contact) && !TextUtils.isEmpty(city) &&
                        !TextUtils.isEmpty(address) && !TextUtils.isEmpty(about)) {
                    databaseRegister.push().getKey();
                    String userId = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    String email = FirebaseAuth.getInstance().getCurrentUser().getEmail();
                    CompanyRegister companyRegister = new CompanyRegister(userId, companyName, address, contact, city, about);
                    databaseRegister.child(userId).setValue(companyRegister);
                    Toast.makeText(CompanyDetails.this, "Details Added", Toast.LENGTH_LONG).show();
                    sharedPreferences = getSharedPreferences(SHARED_PREFS, MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("Email",email);
                    editor.apply();
                    startActivity(new Intent(getApplicationContext(), CompanyNavbar.class));
                }
            }
        });
    }
}