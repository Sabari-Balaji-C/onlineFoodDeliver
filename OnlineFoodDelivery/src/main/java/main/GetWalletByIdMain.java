package main;

import java.util.Scanner;

import dao.WalletDao;
import dao.WalletDaoImpl;
import model.Wallet;

public class GetWalletByIdMain {

	    public static void main(String[] args) {
	        WalletDao walletDAO = new WalletDaoImpl();
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("Enter wallet ID to retrieve: ");
	        int id = scanner.nextInt();
	        Wallet wallet = walletDAO.getWalletById(id);
	        if (wallet != null) {
	            System.out.println("Retrieved Wallet: " + wallet);
	        } else {
	            System.out.println("Wallet not found.");
	        }
	    }
	}
