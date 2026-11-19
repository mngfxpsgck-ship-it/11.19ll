public class Main {
    static void main(String[] args){
        Barista barista = new Barista(3000, 1);

        Customer customer1 = new Customer("[손님1]", 10000, false);
        customer1.order(barista, "아메리카노");
        System.out.println("-------------------------------");
        customer1.order(barista, "아메리카노");
    }
}