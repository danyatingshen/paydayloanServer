package com.example.chinmakoto.paydayloanserver.Model;

import android.net.wifi.hotspot2.pps.Credential;
import android.net.wifi.hotspot2.pps.Credential;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kenai.jffi.Main;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.JsonRpc2_0Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;

import com.example.chinmakoto.paydayloanserver.DAO;
import com.example.chinmakoto.paydayloanserver.EIP20Interface;
import com.example.chinmakoto.paydayloanserver.Lottery;
import com.example.chinmakoto.paydayloanserver.Token;

import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;

import org.web3j.tx.gas.DefaultGasProvider;

public class User {
    private String Name;
    private String Password;
    private String Phone;
    private String IsStaff;
    private String StoreId;
    private String Deploy;
    private Credentials credentials;


    public User(){

    }

    public User(String name, String password,String storeId,String deploy) {
        Name = name;
        Password = password;
        StoreId=storeId;
        Deploy=deploy;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public String getDeploy() {
        return Deploy;
    }

    public void setDeploy(String deploy) {
        Deploy = deploy;
    }

    public String getStoreId() {
        return StoreId;
    }

    public void setStoreId(String storeId) {
        StoreId = storeId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getIsStaff() {
        return IsStaff;
    }

    public void setIsStaff(String isStaff) {
        IsStaff = isStaff;
    }
}
