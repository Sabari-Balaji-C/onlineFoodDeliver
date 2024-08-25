package model;

public class Wallet {

	private int walletId;
    private int customerId;
    private double amount;
    private String source;
    
	public Wallet(int walletId, int customerId, double amount, String source) {
		super();
		this.walletId = walletId;
		this.customerId = customerId;
		this.amount = amount;
		this.source = source;
	}

	public Wallet() {
		// TODO Auto-generated constructor stub
	}

	public int getWalletId() {
		return walletId;
	}

	public void setWalletId(int walletId) {
		this.walletId = walletId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@Override
	public String toString() {
		return "Wallet [walletId=" + walletId + ", customerId=" + customerId + ", amount=" + amount + ", source="
				+ source + "]";
	}

	
    
    
}
