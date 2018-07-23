Financial Transactions Processor:
The following transaction file content is the CSV file that contains financial transactions, where each line is either a debit or a credit transaction on a specific account number.

00001500205568600,D,1520.15
00001500205568600,D,12500.00
00001500205568600,C,44.00
00001300220978215,C,59800.13
00001300220978215,C,80000.00
00001300220978215,C,15850.23
00001300220978215,D,85.60
00002200540006410,D,595550.03
00002200540006410,C,1200.00
00002200540006410,D,3250.00
00001300220978215,C,12.55
00009650025500020,C,290050.00
00009650025500020,D,96.00

As you can see, each line has the following format: <account number>,<D or C; D for debit and C for credit>,<amount>.
The file contains transactions for multiple account numbers, but more than one for each account number.

Write a Java program that reads the transactions.txt file line by line and calculates the final balance of each account number.

Assume that each account will start with 0 balance, the amount of each debit (D) transaction will be subtracted from the balance and the amount of each credit (C) transaction will be added to the balance.

The program should print each account number with its final balance.