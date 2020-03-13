
public class LottoResource {
	private int money;
	private int balance;
	private int[][] myNumber;
	public LottoResource() {
		this.money = 0;
		this.balance = 0;
	}
	public int getMoney() {
		return money;
	}
	public int[][] getMyNumber() {
		return myNumber;
	}
	public void setMyNumber(int[][] myNumber) {
		this.myNumber = myNumber;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

	
}
