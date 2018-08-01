package com.example.chinmakoto.paydayloanserver;

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
    public static Web3j web3j;
    public static Credentials credentials;
    public static BigInteger gasP = DefaultGasProvider.GAS_PRICE;
    public static BigInteger gasL = DefaultGasProvider.GAS_LIMIT;

    public Deploy() throws Exception {

    }
    /**

     public static Credentials logIn() throws Exception {
     Web3j web3j = new JsonRpc2_0Web3j(new HttpService("https://ropsten.infura.io/v3/9ee9974d9a7a4b7f80fa5e8f632a8aa1"));
     log.info("Connected to Ethereum client version: "
     + web3j.web3ClientVersion().send().getWeb3ClientVersion());
     Credentials credentials =
     WalletUtils.loadCredentials(
     "<hello>",
     "/Users/lucyyu540/Library/Ethereum/testnet/keystore/<UTC--2018-07-31T14-35-24.353000000Z--56e50d0ecada2fd6de5aba3fc5e6e597875b012d.json>");
     log.info("Credentials loaded");
     return credentials;
     }
     */


    public static void deploy() throws Exception {
        web3j = Web3j.build(new InfuraHttpService("https://ropsten.infura.io/9ee9974d9a7a4b7f80fa5e8f632a8aa1"));
        //web3j = new JsonRpc2_0Web3j(new HttpService("https://ropsten.infura.io/v3/9ee9974d9a7a4b7f80fa5e8f632a8aa1"));
        //log.info("Connected to Ethereum client version: " + web3j.web3ClientVersion().send().getWeb3ClientVersion());
        credentials =
                WalletUtils.loadCredentials(
                        "<hello>",
                        "/Users/chinmakoto/LucyWallet.json");
        log.info("Credentials loaded");

        //deployed
        log.info("Deploying smart contract");
        BigInteger totalSupply = BigInteger.valueOf(1000);

        Token token = Token.deploy(
                web3j, credentials,
                gasP, gasL, totalSupply).send();
        String tokenContractAddress = token.getContractAddress();
        log.info("Token contract deployed to address " + tokenContractAddress);

        Lottery lottery = Lottery.deploy(
                web3j, credentials,
                gasP, gasL).send();
        String lotteryContractAddress = lottery.getContractAddress();
        log.info("Lottery contract deployed to address " + lotteryContractAddress);

        dao = DAO.deploy(
                web3j, credentials,
                gasP, gasL, lotteryContractAddress, tokenContractAddress).send();
        String daoContractAddress = dao.getContractAddress();
        log.info("DAO contract deployed to address " + daoContractAddress);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}