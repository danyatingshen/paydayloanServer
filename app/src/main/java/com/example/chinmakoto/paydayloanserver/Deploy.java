package com.example.chinmakoto.paydayloanserver;

import android.net.wifi.hotspot2.pps.Credential;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kenai.jffi.Main;

import java.io.File;
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


import com.example.chinmakoto.paydayloanserver.DAO; //CHANGE
import com.example.chinmakoto.paydayloanserver.EIP20Interface;
import com.example.chinmakoto.paydayloanserver.Lottery;
import com.example.chinmakoto.paydayloanserver.Token;

import org.web3j.protocol.infura.InfuraHttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;


import org.web3j.tx.gas.DefaultGasProvider;

public class Deploy extends AppCompatActivity {
    public static final Logger log = LoggerFactory.getLogger(MainActivity.class);
    public static TransactionReceipt transactionReceipt;
    public static DAO dao;
    static String daoContractAddress = "0x6e8894e6ab680237faf54c2ff40e651da5d4231a";
    public static Web3j web3j;
    public static Credentials credentials;
    public static BigInteger gasP = DefaultGasProvider.GAS_PRICE;
    public static BigInteger gasL = DefaultGasProvider.GAS_LIMIT;


    public static void generateNewWallet(String password, String pathToDestination) throws Exception{
        WalletUtils.generateNewWalletFile(password, new File(pathToDestination));
    }

    public static void loadUp(Credentials cred) throws Exception {
        web3j = Web3j.build(new InfuraHttpService("https://ropsten.infura.io/9ee9974d9a7a4b7f80fa5e8f632a8aa1"));
        //web3j = new JsonRpc2_0Web3j(new HttpService("https://ropsten.infura.io/v3/9ee9974d9a7a4b7f80fa5e8f632a8aa1"));
        log.info("Connected to Ethereum client version: " + web3j.web3ClientVersion().send().getWeb3ClientVersion());

        credentials = credentials;
        log.info("Credentials loaded");

        dao = DAO.load(daoContractAddress, web3j, credentials, gasP, gasL);
    }


    public static void loadUp(String password, String pathToFile) throws Exception {
        web3j = Web3j.build(new InfuraHttpService("https://ropsten.infura.io/9ee9974d9a7a4b7f80fa5e8f632a8aa1"));
        //web3j = new JsonRpc2_0Web3j(new HttpService("https://ropsten.infura.io/v3/9ee9974d9a7a4b7f80fa5e8f632a8aa1"));
        log.info("Connected to Ethereum client version: " + web3j.web3ClientVersion().send().getWeb3ClientVersion());

        credentials =
                WalletUtils.loadCredentials(
                        password,
                        pathToFile);
        log.info("Credentials loaded");

        dao = DAO.load(daoContractAddress, web3j, credentials, gasP, gasL);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}