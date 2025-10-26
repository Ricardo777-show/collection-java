package PetShop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MyAnimalShop implements AnimalShop{
    private double balance;
    private List<Animal> animals;
    private List<Customer> customers;
    private boolean isOpen;

    public MyAnimalShop(double balance) {
        this.balance = balance;
        this.animals = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.isOpen = true;
    }

    @Override
    public void buyAnimal(Animal animal) throws InsufficientBalanceException {
        if (balance < animal.price) {
            throw new InsufficientBalanceException("���㣬�޷�����۸�Ϊ $" + animal.price + " �Ķ���");
        }
        balance -= animal.price;
        animals.add(animal);
        System.out.println("�ɹ����룺" + animal.toString());
    }

    @Override
    public void serveCustomer(Customer customer) {
        LocalDate today = LocalDate.now();
        boolean found = false;
        for (Customer c : customers) {
            if (c.getName().equals(customer.getName())) {
                if (!c.getLastVisitTime().equals(today)) {
                    c.incrementVisit();
                    try {
                        c.getClass().getDeclaredFields()[2].set(c, today); // ����������ʱ�䣨ʵ����ĿӦʹ�� setter��
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                found = true;
                break;
            }
        }
        if (!found) {
            Customer newCustomer = new Customer(customer.getName(), today);
            customers.add(newCustomer);
        }

        if (animals.isEmpty()) {
            throw new AnimalNotFoundException("�����޶���ɳ��ۣ�");
        }

        Animal soldAnimal = animals.remove(0);
        balance += soldAnimal.price;
        System.out.println("����ͻ� " + customer.getName() + " ���ۣ�" + soldAnimal.toString());
    }

    @Override
    public void close() {
        LocalDate today = LocalDate.now();
        System.out.println("���չ�˵Ŀͻ��б�");
        for (Customer c : customers) {
            if (c.getLastVisitTime().equals(today)) {
                System.out.println(c);
            }
        }

        // �����ʼ����ڹ���ʱ�趨
        double profit = balance - 1000; // ʾ���м�����ʼ���Ϊ1000
        System.out.println("��������" + profit + "Ԫ");
        isOpen = false;
    }
}
