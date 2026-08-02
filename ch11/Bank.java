package ch11;

public class Bank {
    /**
     * Bank name
     * 3文字以上
     */
    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String newName) throws Exception {
        if (newName.length() < 3) {
            throw new IllegalAccessException("名前が不正です");
        }
        this.name = newName;
    }
}
