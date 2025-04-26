package src.DynamicProxyExample;

public class Man implements Person {
    private String name;
    private String city;
    private String country;
    private int age;

    public Man(String name, String city, String country, int age) {
        this.name = name;
        this.city = city;
        this.country = country;
        this.age = age;
    }

    @Override
    public void introduce(String name) {
        System.out.println("Привіт, мене звати " + this.name);
    }

    @Override
    public void sayAge(int age) {
        System.out.println("Привіт, мені " + this.age + " років");
    }

    @Override
    public void sayFrom(String city, String country) {
        System.out.println("Привіт, я з міста " + this.city + ", яке знаходиться в " + this.country);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}