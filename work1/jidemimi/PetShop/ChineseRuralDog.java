package PetShop;

public class ChineseRuralDog extends Animal{
    private boolean isVaccineInjected;

    public ChineseRuralDog(String name, int age, String gender, boolean isVaccineInjected) {
        super(name, age, gender, 100.0);
        this.isVaccineInjected = isVaccineInjected;
    }

    @Override
    public String toString() {
        return "�л���԰Ȯ{" +
                "����='" + name + '\'' +
                ", ����=" + age +
                ", �Ա�='" + gender + '\'' +
                ", �Ƿ��������=" + isVaccineInjected +
                ", �۸�=" + price + "Ԫ}";
    }
}
