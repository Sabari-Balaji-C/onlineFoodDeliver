package main;

import java.util.Scanner;

import dao.WalletDao;
import dao.WalletDaoImpl;
import model.Wallet;

public class UpdateWalletMain {

	 public static void main(String[] args) {
	        WalletDao walletDAO = new WalletDaoImpl();
	        Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter wallet ID to update: ");
	        int id = scanner.nextInt();
	        System.out.print("Enter new amount: ");
	        double newAmount = scanner.nextDouble();
	        scanner.nextLine();  
	        System.out.print("Enter new wallet source (PAYTM, CREDIT_CARD, DEBIT_CARD): ");
	        String newSource = scanner.nextLine();

	        Wallet wallet = walletDAO.getWalletById(id);
	        if (wallet != null) {
	            wallet.setAmount(newAmount);
	            wallet.setSource(newSource);
	            walletDAO.updateWallet(wallet);
	            System.out.println("Wallet updated: " + wallet);
	        } else {
	            System.out.println("Wallet not found.");
	        }
	    }
	}