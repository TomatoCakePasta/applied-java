package ch10;

// compile
// javac -d . Bank.java
// making jar file command
// jar cf atm.jar ch10/Bank.class
// run
// java -cp atm.jar ch10.Bank

/**
 * Bank class
 */
public class Bank {
    /** 銀行名 */
    String name;
    /** 銀行住所 */
    String address;

    /**
     * 口座追加メソッド
     * 
     * @param owner       口座所有者名
     * @param initZandaka 口座残高初期値
     */
    public void addAccount(String owner, int initZandaka) {
    }

    void main() {
        IO.println("This is main method");
    }
}
