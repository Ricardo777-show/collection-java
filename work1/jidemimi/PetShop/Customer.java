package PetShop;

import java.time.LocalDate;

public class Customer {
    private String name;
    private int visitCount;
    private LocalDate lastVisitTime;

    public Customer(String name, LocalDate lastVisitTime) {
        this.name = name;
        this.visitCount = 1;
        this.lastVisitTime = lastVisitTime;
    }

    public void incrementVisit() {
        this.visitCount++;
    }

    @Override
    public String toString() {
        return "�˿�{" +
                "����='" + name + '\'' +
                ", �������=" + visitCount +
                ", ���µ���ʱ��=" + lastVisitTime +
                '}';
    }

    // getter ����
    public String getName() { return name; }
    public LocalDate getLastVisitTime() { return lastVisitTime; }
}
