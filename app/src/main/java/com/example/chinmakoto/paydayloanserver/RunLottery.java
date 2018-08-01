package com.example.chinmakoto.paydayloanserver;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chinmakoto.paydayloanserver.Common.Common;
import com.example.chinmakoto.paydayloanserver.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RunLottery extends AppCompatActivity {
    String Wallet;
    String LotteryRewardPrice="";


    Button btnRunLottery;


    FirebaseDatabase database;
    DatabaseReference foods;
    DatabaseReference users;
    DatabaseReference lotteries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run_lottery);

        final ArrayList<String> LotteryList = new ArrayList<String>();

        database = FirebaseDatabase.getInstance();


        users=database.getReference("User");


        btnRunLottery=(Button)findViewById(R.id.btnRunLotteryforFun);


        foods = FirebaseDatabase.getInstance().getReference("Food");

        DatabaseReference foodsRef=foods.child(Common.currentUser.getStoreId()).child("Price");

        foodsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ////GET THE PRICE:
                LotteryRewardPrice=dataSnapshot.getValue(String.class);
                ////GET THE LIST:
                ///////////////////////////////////////////////////
                lotteries=FirebaseDatabase.getInstance().getReference("Lottery");

                Query lotteryQuery = lotteries.orderByChild("foodId").equalTo(Common.currentUser.getStoreId());

                lotteryQuery.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot LotterySnapshot: dataSnapshot.getChildren()) {
                            String item=LotterySnapshot.child("walletAccount").getValue(String.class);
                            //Toast.makeText(Lottery.this,"wallet is: "+item,Toast.LENGTH_LONG).show();
                            LotteryList.add(item);
                            //Toast.makeText(Lottery.this,"List is: "+LotteryList,Toast.LENGTH_LONG).show();

                        }
                        Toast.makeText(RunLottery.this,"Final is: "+LotteryList,Toast.LENGTH_LONG).show();
                        Toast.makeText(RunLottery.this,"price is: "+LotteryRewardPrice,Toast.LENGTH_LONG).show();
                        Toast.makeText(RunLottery.this,"deploy: "+Common.currentUser.getDeploy(),Toast.LENGTH_LONG).show();

                        btnRunLottery.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //if (Common.currentUser.getDeploy().toString()=="false")

                                    //call deploy


                                    //run lottery
                                //}else
                                    {
                                        //run lottery
                                    }

                            }
                        });




                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });



            }


            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });

    }
}
