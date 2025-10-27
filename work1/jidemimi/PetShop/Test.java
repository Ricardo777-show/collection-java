package PetShop;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        MyAnimalShop shop = new MyAnimalShop(1000.0);

        try {
            // ������
            shop.buyAnimal(new ChineseRuralDog("С��", 2, "��", true));
            shop.buyAnimal(new Cat("С��", 1, "ĸ"));
            shop.buyAnimal(new Rabbit("С��", 6, "ĸ", "��ɫ"));

            // �д��˿�
            Customer c1 = new Customer("����", LocalDate.now());
            Customer c2 = new Customer("����", LocalDate.now());
            shop.serveCustomer(c1);
            shop.serveCustomer(c2);
            shop.serveCustomer(c1); // �ٴη���

            // �رյ���
            shop.close();

        } catch (InsufficientBalanceException | AnimalNotFoundException e) {
            System.err.println("�쳣��" + e.getMessage());
        }
    }
}
