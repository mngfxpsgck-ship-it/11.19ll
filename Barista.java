public class Barista {
    private final int coffeePrice;
    private int beanCount;
    private int cashBox;

    public Barista(){
        coffeePrice = 3000;
        beanCount = 1;
        cashBox = 0;
    }

    public Barista(int coffeePrice, int beanCount){
        this.coffeePrice = coffeePrice;
        this.beanCount = beanCount;
        cashBox = 0;
    }

    public int getCoffeePrice(){
        return coffeePrice;
    }

    public int checkCoffee() {
        if (beanCount > 0) {
            return 0;
        }
        else if(beanCount < 0) {
            return -1;
        }
        return -9;
    }

    public String makeCoffee(String menuName){
        beanCount--;

        System.out.println("현재 원두는 " + beanCount + "입니다.");
        return "아메리카노";
    }

    public int returnMoney(int coffeePrice){
        cashBox -= coffeePrice;
        return coffeePrice;
    }

    public String takeOrder(String menuName, int payment){
        System.out.println("[바리스타] 주문을 확인했습니다.");

        if(checkCoffee() != 0){
            System.out.println("[바리스타] 원두가 없어서 주문이 불가능합니다.");

            return "0";
        }

        cashBox += payment;

        System.out.println("[바리스타] 잔고는 " + cashBox + "원 입니다. ");

        String madeCoffee = makeCoffee(menuName);
        return madeCoffee;
    }
}
