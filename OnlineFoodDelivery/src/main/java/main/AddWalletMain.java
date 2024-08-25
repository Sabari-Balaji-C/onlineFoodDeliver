package main;

import java.util.Scanner;

import dao.WalletDao;
import dao.WalletDaoImpl;
import model.Wallet;

public class AddWalletMain {

	public static void main(String[] args) {
        WalletDao walletDAO = new WalletDaoImpl();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter customer ID: ");
        int customerId = scanner.nextInt();
        System.out.print("Enter wallet amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter wallet source (PAYTM, CREDIT_CARD, DEBIT_CARD): ");
        String source = scanner.nextLine();

        Wallet newWallet = new Wallet(0, customerId, amount, source);
        walletDAO.addWallet(newWallet);

        System.out.println("New wallet added.");
    }
}