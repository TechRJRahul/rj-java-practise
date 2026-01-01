public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        coreJava();
        customeException();
    }

    private static void customeException() {
        BankAccount account = new BankAccount(5000);
        try {
            account.withdraw(7000);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void coreJava() {
        Integer a = 100;
        Integer b = 100;

        Integer c = 200;
        Integer d = 200;
        System.out.println(a == b);
        System.out.println(c == d);
    }
}
