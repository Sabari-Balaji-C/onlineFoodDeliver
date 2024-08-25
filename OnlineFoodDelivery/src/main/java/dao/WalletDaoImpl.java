package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Wallet;
import util.DBConnection;

public class WalletDaoImpl implements WalletDao{

	 private Connection connection;

	    public  WalletDaoImpl() {
	        try {
				connection = DBConnection.getConnection();
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }

	    @Override
	    public void addWallet(Wallet wallet) {
	        String query = "INSERT INTO wallet (CUS_ID, WAL_AMOUNT, WAL_SOURCE) VALUES (?, ?, ?)";
	        try (PreparedStatement ps = connection.prepareStatement(query)) {
	            ps.setInt(1, wallet.getCustomerId());
	            ps.setDouble(2, wallet.getAmount());
	            ps.setString(3, wallet.getSource());
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public Wallet getWalletById(int id) {
	        Wallet wallet = null;
	        String query = "SELECT * FROM wallet WHERE WAL_ID = ?";
	        try (PreparedStatement ps = connection.prepareStatement(query)) {
	            ps.setInt(1, id);
	            ResultSet rs = ps.executeQuery();
	            if (rs.next()) {
	                wallet = new Wallet();
	                wallet.setWalletId(rs.getInt("WAL_ID"));
	                wallet.setCustomerId(rs.getInt("CUS_ID"));
	                wallet.setAmount(rs.getDouble("WAL_AMOUNT"));
	                wallet.setSource(rs.getString("WAL_SOURCE"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return wallet;
	    }

	    @Override
	    public void updateWallet(Wallet wallet) {
	        String query = "UPDATE wallet SET CUS_ID = ?, WAL_AMOUNT = ?, WAL_SOURCE = ? WHERE WAL_ID = ?";
	        try (PreparedStatement ps = connection.prepareStatement(query)) {
	            ps.setInt(1, wallet.getCustomerId());
	            ps.setDouble(2, wallet.getAmount());
	            ps.setString(3, wallet.getSource());
	            ps.setInt(4, wallet.getWalletId());
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public void deleteWallet(int id) {
	        String query = "DELETE FROM wallet WHERE WAL_ID = ?";
	        try (PreparedStatement ps = connection.prepareStatement(query)) {
	            ps.setInt(1, id);
	            ps.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    @Override
	    public List<Wallet> getAllWallets() {
	        List<Wallet> wallets = new ArrayList<>();
	        String query = "SELECT * FROM wallet";
	        try (PreparedStatement ps = connection.prepareStatement(query)) {
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                Wallet wallet = new Wallet();
	                wallet.setWalletId(rs.getInt("WAL_ID"));
	                wallet.setCustomerId(rs.getInt("CUS_ID"));
	                wallet.setAmount(rs.getDouble("WAL_AMOUNT"));
	                wallet.setSource(rs.getString("WAL_SOURCE"));
	                wallets.add(wallet);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return wallets;
	    }

	    @Override
	    public List<Wallet>getWalletsByCustomerId(int customerId) {
	        List<Wallet> wallets = new ArrayList<>();
	        String query = "SELECT * FROM wallet WHERE CUS_ID = ?";
	        try (PreparedStatement ps = connection.prepareStatement(query)) {
	            ps.setInt(1, customerId);
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()) {
	                Wallet wallet = new Wallet();
	                wallet.setWalletId(rs.getInt("WAL_ID"));
	                wallet.setCustomerId(rs.getInt("CUS_ID"));
	                wallet.setAmount(rs.getDouble("WAL_AMOUNT"));
	                wallet.setSource(rs.getString("WAL_SOURCE"));
	                wallets.add(wallet);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return wallets;
	    }
	}
