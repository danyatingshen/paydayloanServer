package com.example.chinmakoto.paydayloanserver;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.EventEncoder;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Event;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameter;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.Log;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import rx.Observable;
import rx.functions.Func1;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.5.0.
 */
public class DAO extends Contract {
    private static final String BINARY = "0x608060405234801561001057600080fd5b50604051604080612dd08339810180604052810190808051906020019092919080519060200190929190505050336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555081600460006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16636637b882306040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050600060405180830381600087803b1580156101bc57600080fd5b505af11580156101d0573d6000803e3d6000fd5b505050506000600281905550600060068190555060006007819055505050612bd3806101fd6000396000f3006080604052600436106100c5576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680630a135c17146100ca5780630c2b3d65146100f55780633aecd0e3146101a55780638da5cb5b146101fc5780638dd8c56d14610253578063ab57900914610280578063affed0e0146102d7578063b9ad86ab14610302578063ba13a57214610385578063bec3fa17146103dc578063c428a59314610429578063e6a2d24814610490578063fc0c546a14610537575b600080fd5b3480156100d657600080fd5b506100df61058e565b6040518082815260200191505060405180910390f35b34801561010157600080fd5b506101636004803603810190808035906020019092919080359060200190820180359060200190808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050509192919290505050610594565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156101b157600080fd5b506101e6600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610981565b6040518082815260200191505060405180910390f35b34801561020857600080fd5b50610211610a82565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561025f57600080fd5b5061027e60048036038101908080359060200190929190505050610aa7565b005b34801561028c57600080fd5b506102c1600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610bb8565b6040518082815260200191505060405180910390f35b3480156102e357600080fd5b506102ec610cb9565b6040518082815260200191505060405180910390f35b34801561030e57600080fd5b50610343600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610cbf565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561039157600080fd5b5061039a610dc0565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156103e857600080fd5b50610427600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919080359060200190929190505050610de6565b005b34801561043557600080fd5b50610476600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803515159060200190929190505050610f25565b604051808215151515815260200191505060405180910390f35b34801561049c57600080fd5b506104bb60048036038101908080359060200190929190505050612489565b604051808481526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001935050505060405180910390f35b34801561054357600080fd5b5061054c6124f3565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b60025481565b6000803390506020604051908101604052806000815250600560008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060008201518160000155905050600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16638debd12b8286866040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200183815260200180602001828103825283818151815260200191508051906020019060200280838360005b838110156106de5780820151818401526020810190506106c3565b50505050905001945050505050600060405180830381600087803b15801561070557600080fd5b505af1158015610719573d6000803e3d6000fd5b50505050600760008154809291906001019190505550600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663b9ad86ab826040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b1580156107ec57600080fd5b505af1158015610800573d6000803e3d6000fd5b505050506040513d602081101561081657600080fd5b810190808051906020019092919050505073ffffffffffffffffffffffffffffffffffffffff168173ffffffffffffffffffffffffffffffffffffffff167ff422f60174ba7df807ca9eb58ec26f237febc51973a3267df692f568512be0e160405160405180910390a3600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663b9ad86ab826040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b15801561093d57600080fd5b505af1158015610951573d6000803e3d6000fd5b505050506040513d602081101561096757600080fd5b810190808051906020019092919050505091505092915050565b6000600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166370a08231836040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b158015610a4057600080fd5b505af1158015610a54573d6000803e3d6000fd5b505050506040513d6020811015610a6a57600080fd5b81019080805190602001909291905050509050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600080600d600a84811515610ab857fe5b0402915081610ac633610981565b10151515610ad357600080fd5b339050600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166312e382b482846040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050600060405180830381600087803b158015610b9b57600080fd5b505af1158015610baf573d6000803e3d6000fd5b50505050505050565b6000600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663ab579009836040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b158015610c7757600080fd5b505af1158015610c8b573d6000803e3d6000fd5b505050506040513d6020811015610ca157600080fd5b81019080805190602001909291905050509050919050565b60075481565b6000600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663b9ad86ab836040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b158015610d7e57600080fd5b505af1158015610d92573d6000803e3d6000fd5b505050506040513d6020811015610da857600080fd5b81019080805190602001909291905050509050919050565b600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6000339050600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166323b872dd8285856040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b158015610ee457600080fd5b505af1158015610ef8573d6000803e3d6000fd5b505050506040513d6020811015610f0e57600080fd5b810190808051906020019092919050505050505050565b6000806000806000806000339550600a600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663ab5790098b6040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b158015610ff257600080fd5b505af1158015611006573d6000803e3d6000fd5b505050506040513d602081101561101c57600080fd5b810190808051906020019092919050505081151561103657fe5b049450600560008a73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600101600080815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169350600560008a73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060010160006001815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff169250600560008a73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060010160006002815260200190815260200160002060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1691508373ffffffffffffffffffffffffffffffffffffffff168673ffffffffffffffffffffffffffffffffffffffff161415801561120557508273ffffffffffffffffffffffffffffffffffffffff168673ffffffffffffffffffffffffffffffffffffffff1614155b151561121057600080fd5b8461121a87610981565b1015151561122757600080fd5b600560008a73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000154905060028110151561232d5785600560008b73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600101600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555087600560008b73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600201600083815260200190815260200160002060006101000a81548160ff021916908315150217905550600560008a73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160008154809291906001019190505550600560008a73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020160006001815260200190815260200160002060009054906101000a900460ff161515600560008b73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600201600080815260200190815260200160002060009054906101000a900460ff161515141515611a6f57600560008a73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020160006002815260200190815260200160002060009054906101000a900460ff161515600560008b73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600201600080815260200190815260200160002060009054906101000a900460ff16151514156117e757600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166323b872dd84866002898115156115ac57fe5b046040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b15801561166557600080fd5b505af1158015611679573d6000803e3d6000fd5b505050506040513d602081101561168f57600080fd5b810190808051906020019092919050505050600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166323b872dd84846002898115156116ed57fe5b046040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b1580156117a657600080fd5b505af11580156117ba573d6000803e3d6000fd5b505050506040513d60208110156117d057600080fd5b810190808051906020019092919050505050611a6a565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166323b872dd858560028981151561183357fe5b046040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b1580156118ec57600080fd5b505af1158015611900573d6000803e3d6000fd5b505050506040513d602081101561191657600080fd5b810190808051906020019092919050505050600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166323b872dd858460028981151561197457fe5b046040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b158015611a2d57600080fd5b505af1158015611a41573d6000803e3d6000fd5b505050506040513d6020811015611a5757600080fd5b8101908080519060200190929190505050505b61216d565b600560008a73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020160006002815260200190815260200160002060009054906101000a900460ff161515600560008b73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600201600080815260200190815260200160002060009054906101000a900460ff1615151415611ee957611b4589612519565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166323b872dd8a86886040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b158015611c3e57600080fd5b505af1158015611c52573d6000803e3d6000fd5b505050506040513d6020811015611c6857600080fd5b810190808051906020019092919050505050600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166323b872dd8a85886040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b158015611d7357600080fd5b505af1158015611d87573d6000803e3d6000fd5b505050506040513d6020811015611d9d57600080fd5b810190808051906020019092919050505050600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166323b872dd8a84886040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b158015611ea857600080fd5b505af1158015611ebc573d6000803e3d6000fd5b505050506040513d6020811015611ed257600080fd5b81019080805190602001909291905050505061216c565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166323b872dd8385600289811515611f3557fe5b046040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b158015611fee57600080fd5b505af1158015612002573d6000803e3d6000fd5b505050506040513d602081101561201857600080fd5b810190808051906020019092919050505050600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166323b872dd838660028981151561207657fe5b046040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b15801561212f57600080fd5b505af1158015612143573d6000803e3d6000fd5b505050506040513d602081101561215957600080fd5b8101908080519060200190929190505050505b5b6000600560008b73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600101600080815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600560008b73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060010160006001815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600560008b73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060010160006002815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555061247d565b85600560008b73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600101600083815260200190815260200160002060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555087600560008b73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600201600083815260200190815260200160002060006101000a81548160ff021916908315150217905550600560008a73ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600001600081548092919060010191905055505b50505050505092915050565b60016020528060005260406000206000915090508060000154908060010160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16908060020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905083565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600080600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663b9ad86ab846040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b1580156125d957600080fd5b505af11580156125ed573d6000803e3d6000fd5b505050506040513d602081101561260357600080fd5b81019080805190602001909291905050509150600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663ab579009846040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b1580156126d357600080fd5b505af11580156126e7573d6000803e3d6000fd5b505050506040513d60208110156126fd57600080fd5b81019080805190602001909291905050509050600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166323b872dd8484846040518463ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b15801561280957600080fd5b505af115801561281d573d6000803e3d6000fd5b505050506040513d602081101561283357600080fd5b8101908080519060200190929190505050506002600081548092919060010191905055506060604051908101604052808281526020018473ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff168152506001600060025481526020019081526020016000206000820151816000015560208201518160010160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060408201518160020160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550905050600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663b9ad86ab846040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b158015612a0c57600080fd5b505af1158015612a20573d6000803e3d6000fd5b505050506040513d6020811015612a3657600080fd5b810190808051906020019092919050505073ffffffffffffffffffffffffffffffffffffffff168373ffffffffffffffffffffffffffffffffffffffff167f9f21639fe8fab66c54783f0f43b568f18dc26d470f00729a015caafb4c479910600460009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663ab579009876040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b158015612b5257600080fd5b505af1158015612b66573d6000803e3d6000fd5b505050506040513d6020811015612b7c57600080fd5b81019080805190602001909291905050506040518082815260200191505060405180910390a35050505600a165627a7a72305820df54ea95ed4aaf04104fc183d582ecc757154822b9d1bed7bfbb1fbdfe5b0a750029";

    public static final String FUNC_NUMOFTOKENTRANSACTIONS = "numOfTokenTransactions";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_NONCE = "nonce";

    public static final String FUNC_LOTTERY = "lottery";

    public static final String FUNC_TOKENTRANSACTIONHISTORY = "tokenTransactionHistory";

    public static final String FUNC_TOKEN = "token";

    public static final String FUNC_CREATELOTTERY = "createLottery";

    public static final String FUNC_RUNLOTTERY = "runLottery";

    public static final String FUNC_VALIDATEWINNER = "validateWinner";

    public static final String FUNC_TRANSFERTOKENS = "transferTokens";

    public static final String FUNC_GETTOKENBALANCE = "getTokenBalance";

    public static final String FUNC_GETLOTTERYPOOL = "getLotteryPool";

    public static final String FUNC_GETLOTTERYWINNER = "getLotteryWinner";

    public static final Event LOTTERYWIN_EVENT = new Event("LotteryWin", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}, new TypeReference<Uint256>() {}));
    ;

    public static final Event DRAWWIN_EVENT = new Event("DrawWin", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>(true) {}, new TypeReference<Address>(true) {}));
    ;

    protected static final HashMap<String, String> _addresses;

    static {
        _addresses = new HashMap<String, String>();
        _addresses.put("5777", "0xc351e1fd2fabd74b140e23f878567f4704005e91");
    }

    protected DAO(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected DAO(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public RemoteCall<BigInteger> numOfTokenTransactions() {
        final Function function = new Function(FUNC_NUMOFTOKENTRANSACTIONS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> owner() {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<BigInteger> nonce() {
        final Function function = new Function(FUNC_NONCE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> lottery() {
        final Function function = new Function(FUNC_LOTTERY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Tuple3<BigInteger, String, String>> tokenTransactionHistory(BigInteger param0) {
        final Function function = new Function(FUNC_TOKENTRANSACTIONHISTORY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Address>() {}, new TypeReference<Address>() {}));
        return new RemoteCall<Tuple3<BigInteger, String, String>>(
                new Callable<Tuple3<BigInteger, String, String>>() {
                    @Override
                    public Tuple3<BigInteger, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<BigInteger, String, String>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue());
                    }
                });
    }

    public RemoteCall<String> token() {
        final Function function = new Function(FUNC_TOKEN, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public static RemoteCall<DAO> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _lottery, String _token) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_lottery), 
                new org.web3j.abi.datatypes.Address(_token)));
        return deployRemoteCall(DAO.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static RemoteCall<DAO> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _lottery, String _token) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_lottery), 
                new org.web3j.abi.datatypes.Address(_token)));
        return deployRemoteCall(DAO.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public List<LotteryWinEventResponse> getLotteryWinEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(LOTTERYWIN_EVENT, transactionReceipt);
        ArrayList<LotteryWinEventResponse> responses = new ArrayList<LotteryWinEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            LotteryWinEventResponse typedResponse = new LotteryWinEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._advertiser = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._winner = (String) eventValues.getIndexedValues().get(1).getValue();
            typedResponse.pool = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<LotteryWinEventResponse> lotteryWinEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, LotteryWinEventResponse>() {
            @Override
            public LotteryWinEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(LOTTERYWIN_EVENT, log);
                LotteryWinEventResponse typedResponse = new LotteryWinEventResponse();
                typedResponse.log = log;
                typedResponse._advertiser = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._winner = (String) eventValues.getIndexedValues().get(1).getValue();
                typedResponse.pool = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<LotteryWinEventResponse> lotteryWinEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(LOTTERYWIN_EVENT));
        return lotteryWinEventObservable(filter);
    }

    public List<DrawWinEventResponse> getDrawWinEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(DRAWWIN_EVENT, transactionReceipt);
        ArrayList<DrawWinEventResponse> responses = new ArrayList<DrawWinEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            DrawWinEventResponse typedResponse = new DrawWinEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._advertiser = (String) eventValues.getIndexedValues().get(0).getValue();
            typedResponse._winner = (String) eventValues.getIndexedValues().get(1).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public Observable<DrawWinEventResponse> drawWinEventObservable(EthFilter filter) {
        return web3j.ethLogObservable(filter).map(new Func1<Log, DrawWinEventResponse>() {
            @Override
            public DrawWinEventResponse call(Log log) {
                Contract.EventValuesWithLog eventValues = extractEventParametersWithLog(DRAWWIN_EVENT, log);
                DrawWinEventResponse typedResponse = new DrawWinEventResponse();
                typedResponse.log = log;
                typedResponse._advertiser = (String) eventValues.getIndexedValues().get(0).getValue();
                typedResponse._winner = (String) eventValues.getIndexedValues().get(1).getValue();
                return typedResponse;
            }
        });
    }

    public Observable<DrawWinEventResponse> drawWinEventObservable(DefaultBlockParameter startBlock, DefaultBlockParameter endBlock) {
        EthFilter filter = new EthFilter(startBlock, endBlock, getContractAddress());
        filter.addSingleTopic(EventEncoder.encode(DRAWWIN_EVENT));
        return drawWinEventObservable(filter);
    }

    public RemoteCall<TransactionReceipt> createLottery(BigInteger _pool) {
        final Function function = new Function(
                FUNC_CREATELOTTERY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_pool)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> runLottery(BigInteger _pool, List<String> _entrances) {
        final Function function = new Function(
                FUNC_RUNLOTTERY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_pool), 
                new org.web3j.abi.datatypes.DynamicArray<org.web3j.abi.datatypes.Address>(
                        org.web3j.abi.Utils.typeMap(_entrances, org.web3j.abi.datatypes.Address.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> validateWinner(String _advertiser, Boolean _approval) {
        final Function function = new Function(
                FUNC_VALIDATEWINNER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_advertiser), 
                new org.web3j.abi.datatypes.Bool(_approval)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> transferTokens(String _to, BigInteger _amount) {
        final Function function = new Function(
                FUNC_TRANSFERTOKENS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_to), 
                new org.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<BigInteger> getTokenBalance(String _of) {
        final Function function = new Function(FUNC_GETTOKENBALANCE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Address(_of)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getLotteryPool(String _advertiser) {
        final Function function = new Function(FUNC_GETLOTTERYPOOL, 
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

    public static DAO load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new DAO(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    public static DAO load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new DAO(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected String getStaticDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static String getPreviouslyDeployedAddress(String networkId) {
        return _addresses.get(networkId);
    }

    public static class LotteryWinEventResponse {
        public Log log;

        public String _advertiser;

        public String _winner;

        public BigInteger pool;
    }

    public static class DrawWinEventResponse {
        public Log log;

        public String _advertiser;

        public String _winner;
    }
}
