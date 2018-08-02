package com.example.chinmakoto.paydayloanserver;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.DynamicArray;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.5.0.
 */
public class Lottery extends Contract {
    private static final String BINARY = "0x608060405234801561001057600080fd5b5061079a806100206000396000f30060806040526004361061006d576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680633b6dde13146100725780638debd12b146100c9578063ab57900914610159578063b9ad86ab146101b0578063ff9bd95914610233575b600080fd5b34801561007e57600080fd5b506100b3600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506102cb565b6040518082815260200191505060405180910390f35b3480156100d557600080fd5b50610157600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001909291908035906020019082018035906020019080806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050919291929050505061032f565b005b34801561016557600080fd5b5061019a600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061051c565b6040518082815260200191505060405180910390f35b3480156101bc57600080fd5b506101f1600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610567565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561023f57600080fd5b50610274600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506105d2565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156102b757808201518184015260208101905061029c565b505050509050019250505060405180910390f35b60008060008060008573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600101805490509150814281151561032257fe5b0690508092505050919050565b6000606060405190810160405280848152602001838152602001600073ffffffffffffffffffffffffffffffffffffffff168152506000808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206000820151816000015560208201518160010190805190602001906103c89291906106a1565b5060408201518160020160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555090505061041c846102cb565b90506000808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206001018181548110151561046c57fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166000808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050505050565b60008060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600001549050919050565b60008060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169050919050565b60606000808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060010180548060200260200160405190810160405280929190818152602001828054801561069557602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001906001019080831161064b575b50505050509050919050565b82805482825590600052602060002090810192821561071a579160200282015b828111156107195782518260006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550916020019190600101906106c1565b5b509050610727919061072b565b5090565b61076b91905b8082111561076757600081816101000a81549073ffffffffffffffffffffffffffffffffffffffff021916905550600101610731565b5090565b905600a165627a7a723058208116ce71144a179cd8a5ed27307700c9c5a89c3cd4637b2986f0d41fc99de8700029";

    public static final String FUNC_RUNLOTTERY = "runLottery";

    public static final String FUNC_GETRANDOMNUMBER = "getRandomNumber";

    public static final String FUNC_GETLOTTERYWINNER = "getLotteryWinner";

    public static final String FUNC_GETLOTTERYPOOL = "getLotteryPool";

    public static final String FUNC_GETLOTTERYENTRANCES = "getLotteryEntrances";

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("3", "0x8b68fb2e3d0eda686f8ed2d60476f19a2921abcc");
        _addresses.put("5777", "0xf6f01cb4829aeda88a8a2b212b1ae23228e75119");
    }

    protected Lottery(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Lottery(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static RemoteCall<Lottery> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Lottery.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Lottery> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Lottery.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public RemoteCall<TransactionReceipt> runLottery(String _advertiser, BigInteger _pool, List<String> _entrances) {
        final Function function = new Function(
                FUNC_RUNLOTTERY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_advertiser), 
                new org.web3j.abi.datatypes.generated.Uint256(_pool), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.Utils.typeMap(_entrances, org.web3j.abi.datatypes.Address.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getRandomNumber(String _advertiser) {
        final Function function = new Function(FUNC_GETRANDOMNUMBER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_advertiser)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> getLotteryWinner(String _advertiser) {
        final Function function = new Function(FUNC_GETLOTTERYWINNER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_advertiser)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> getLotteryPool(String _advertiser) {
        final Function function = new Function(FUNC_GETLOTTERYPOOL, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_advertiser)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<List> getLotteryEntrances(String _advertiser) {
        final Function function = new Function(FUNC_GETLOTTERYENTRANCES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_advertiser)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteCall<List>(
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public static Lottery load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Lottery(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static Lottery load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Lottery(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }
}
