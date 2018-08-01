package com.example.chinmakoto.paydayloanserver;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.chinmakoto.paydayloanserver.Model.DaoAddress;
import com.example.chinmakoto.paydayloanserver.Model.User;
import com.google.android.gms.common.internal.service.Common;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.HashMap;
import java.util.Map;

public class SignIn extends AppCompatActivity {
    EditText edtPhone,edtPassword;
    Button btnSignIn;

    FirebaseDatabase db;
    DatabaseReference users;

    FirebaseDatabase database;
    DatabaseReference DAOdb;

    String DAO_address;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        edtPassword = (MaterialEditText)findViewById(R.id.edtPassword);
        edtPhone = (MaterialEditText)findViewById(R.id.edtPhone);
        btnSignIn = (Button)findViewById(R.id.btnSignIn);

        //init Firebase:
        db = FirebaseDatabase.getInstance();
        users=db.getReference("User");

        database = FirebaseDatabase.getInstance();
        DAOdb = database.getReference("DAO");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ProgressDialog mDialog = new ProgressDialog(SignIn.this);
                mDialog.setMessage("Please Waiting...");
                mDialog.show();

                users.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        //check if user not exist in database:
                        if (dataSnapshot.child(edtPhone.getText().toString()).exists()){
                            //Get user information:
                            mDialog.dismiss();
                            User user = dataSnapshot.child(edtPhone.getText().toString()).getValue(User.class);
                            user.setPhone(edtPhone.getText().toString());//set phone
                            if (Boolean.parseBoolean(user.getIsStaff())) {

                                if (user.getPassword().equals(edtPassword.getText().toString())) {


                                    if (user.getDeploy().isEmpty())
                                    {
                                        //deployed:
                                        try {
                                            Deploy.deploy();
                                        }
                                        catch (java.lang.Exception e) {
                                            //dont know whats supposed to happen OTL life has failed.
                                        }

                                        //Save the deployed address to the firebase:
                                        String theAddress = Deploy.dao.getContractAddress();
                                        DaoAddress address=new DaoAddress(theAddress);
                                        DAOdb.child(String.valueOf(System.currentTimeMillis())).setValue(address);



                                        //push and change the COMMON.currentuser.deploy to true
                                        String key= user.getPhone();
                                        DatabaseReference deployRef=users.child(key);
                                        Map<String,Object> deployUpdate=new HashMap<>();
                                        String deploytrue="true";//TODO add final to the true
                                        deployUpdate.put("Deploy",deploytrue);
                                        deployRef.updateChildren(deployUpdate);
                                        Toast.makeText(SignIn.this,"depoly status is now: "+user.getDeploy(),Toast.LENGTH_LONG).show();

                                    }else
                                    {

                                        String KEY=DAOdb.getKey();
                                        DatabaseReference addressRef=DAOdb.child(KEY).child("address");
                                        addressRef.addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                                DAO_address=dataSnapshot.getValue(String.class);
                                                Deploy.dao = DAO.load(DAO_address, Deploy.web3j, Deploy.credentials, Deploy.gasP, Deploy.gasL);

                                            }

                                            @Override
                                            public void onCancelled(@NonNull DatabaseError databaseError) {

                                            }
                                        });


                                    }

                                    Toast.makeText(SignIn.this, "Sign in Successfully", Toast.LENGTH_SHORT).show();
                                    Intent homeIntent= new Intent(SignIn.this,Home.class);
                                    com.example.chinmakoto.paydayloanserver.Common.Common.currentUser =user;
                                    startActivity(homeIntent);
                                    finish();

                                } else {
                                    Toast.makeText(SignIn.this, "Wrong Password or Staff name, please try again.", Toast.LENGTH_SHORT).show();
                                }
                            }else
                            {
                                Toast.makeText(SignIn.this, "Please Login with Staff account", Toast.LENGTH_SHORT).show();
                            }

                        }
                        else{
                            mDialog.dismiss();
                            Toast.makeText(SignIn.this,"User not in the Database",Toast.LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

    }
}
