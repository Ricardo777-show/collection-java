package PetShop;

public class Cat extends Animal{
    public Cat(String name, int age, String gender) {
        super(name, age, gender, 200.0);
    }

    @Override
    public String toString() {
        return "è{" +
                "����='" + name + '\'' +
                ", ����=" + age +
                ", �Ա�='" + gender + '\'' +
                ", �۸�=" + price + "Ԫ}";
    }
}
