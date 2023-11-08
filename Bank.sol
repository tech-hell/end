//BCT Practical 3: Smart contract for Bank 
pragma solidity ^0.4.13;

contract SimpleBank{

    mapping (address => uint) private balances;

    address public owner;

    event LogDepositMade(address accountAddress, uint amount);

    function Bank() public{
        /* set the owner to the creator of this contract */
        owner = msg.sender;
    }

    function enroll() public returns (uint){
        address user = msg.sender;

        balances[user] = 1000;
        return  user.balance;
    }

    function deposit() public payable returns(uint){
        address user = msg.sender;

        balances[user] += msg.value;
        emit LogDepositMade(user, msg.value);
        return balances[user];
    }

    function withdraw(uint withdrawAmount) public returns(uint remainingBal){
        address user = msg.sender;
        require(balances[user] >= withdrawAmount);
        balances[user] -= withdrawAmount;
        user.transfer(withdrawAmount);
        return balances[user];
    }

    function balance() public view returns(uint){
        address user = msg.sender;
        return balances[user];
    }

    function () public {
        revert();
    }
}
