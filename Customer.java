public class Customer {
    private String name;
    private int money;
    private boolean hasCoffee;

    public Customer(){
        money = 0;
        hasCoffee = false;
    }

    public Customer(String name, int money){
        this.name = name;
        this.money = money;
        hasCoffee = false;
    }

    public Customer(String name, int money, boolean hasCoffee){
        this.name = name;
        this.money = money;
        this.hasCoffee = hasCoffee;
    }

    // 잔액이 부족 할 경우 -9 반환.
    // 잔약이 정상일 경우 0 반환.
    public int pay(int coffeePrice){
        if(money < coffeePrice){
            System.out.println(name + "잔액이 부족합니다.");
            return -9;
        }
        money -= coffeePrice;
        return 0;
    }

    public void order(Barista barista, String menuName){
        System.out.println(name + " " + menuName + "를 한 잔 주세요.");
        int price = barista.getCoffeePrice();

        System.out.println("[바리스타] 커피 가격은 " + price + "원 입니다.");

        int paymentCheck = pay(price);

        if(paymentCheck == -9){
            return;
        }

        System.out.println(name + " " + price + "원을 지불했습니다.");
        String coffee = barista.takeOrder(menuName, price);
        takeCoffee(barista, coffee);
    }

    public  void takeCoffee(Barista barista, String coffee){
        if(coffee.equals("0")){
            int coffeePrice = barista.returnMoney(barista.getCoffeePrice());
            money += coffeePrice;
            System.out.println(name + "현재 남은 잔고: " + money + "원");
        }

        else {
            hasCoffee = true;
            System.out.println(name + " " + coffee + "를 받았습니다.");
            System.out.println(name + "현재 남은 잔고: " + money + "원");
        }
    }
}