package PetShop;

public class Rabbit extends Animal{
    private String furColor;

    public Rabbit(String name, int age, String gender, String furColor) {
        super(name, age, gender, 50.0);
        this.furColor = furColor;
    }

    @Override
    public String toString() {
        return "����{" +
                "����='" + name + '\'' +
                ", ����=" + age +
                ", �Ա�='" + gender + '\'' +
                ", ëɫ='" + furColor + '\'' +
                ", �۸�=" + price + "Ԫ}";
    }
}
