<!DOCTYPE html>
<html lang="en">
<head>
  <title>Online Banking</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
 
</head>
<body>
        <nav class="navbar navbar-inverse">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="#"><b>HDFC BANK</b></a>
                    </div>
                <ul class=" nav navbar-nav">
                        <li class="navbar-item"><a  href="index.jsp"></a></li>
                        <li class="navbar-item"><a  href="new account.jsp">New account</a></li>
                        <li class="navbar-item"><a href="withdraw.jsp" >Withdraw</a></li>
                        <li class="navbar-item"><a href="deposit.jsp" >Deposit</a></li>
                        <li  class="navbar-item"><a href="fundTransfer.jsp" >fundTransfer</a></li>
                        <li  class="navbar-item"><a href="searchAccount1.jsp" >SearchAccount</a></li>
                        <li  class="navbar-item"><a href="checkbalance.jsp" >Check balance</a></li>
                        <li class="navbar-item"><a href="all accounts.jsp" href="#">All accounts</a></li>
                        <li  class="navbar-item"><a href="deleteAccount.jsp" >DeleteAccount </a></li>
                        <li  class="navbar-item"><a href="updateBankAccountDetails1.jsp" >UpdateBankAccountDetails </a></li>
                    </ul>
                    </div>
            </nav>


       
    <div class="dropdown">
     <form action="addFundTransfer/" method = "post">
     <lable class="dropdown-item">sender AccountId </lable>
      <input type="number" name="from account "><br><br>
      <lable class="dropdown-item" >Receiver AccountId </lable>
      <input type="number" name="to account "><br><br>
            <lable class="dropdown-item" >amount</lable>
            <input type="number" name="amount"><br><br>
            <br><br> <input type="submit" value="Transfer"><br>
      
    </div>
  </div>
</div>

</body>
</html>
