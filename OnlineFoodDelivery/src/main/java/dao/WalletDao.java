package dao;

import java.util.List;

import model.Wallet;

public interface WalletDao {
	 void addWallet(Wallet wallet);
	    Wallet getWalletById(int id);
	    void updateWallet(Wallet wallet);
	    void deleteWallet(int id);
	    List<Wallet> getAllWallets();
	    List<Wallet> getWalletsByCustomerId(int customerId);
	
}
