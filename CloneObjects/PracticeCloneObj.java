package CloneObjects;

class PracticeCloneObj {
    public static void main(String[] args) throws CloneNotSupportedException {
        FamilyName familyName = new FamilyName("Marian");
        FamilyLastName familyLastName = new FamilyLastName("Zinkevych");
        familyName.setFamilyLastName(familyLastName);
        System.out.println(familyName.getName() + " " + familyLastName.getLastName());
        FamilyName familyName1 = familyName.clone();
        System.out.println(familyName1.toString());
        familyName1.setName("David");
        System.out.println(familyName1.getName() + " " + familyName1.getFamilyLastName().getLastName());
        familyName1.getFamilyLastName().setLastName("Avetisov");
        System.out.println(familyName1.getName() + " " + familyName1.getFamilyLastName().getLastName());
    }
}

class FamilyName implements Cloneable {
    private String name;
    private FamilyLastName familyLastName;

    public FamilyName(String name) {
        this.name = name;
    }

    public FamilyLastName getFamilyLastName() {
        return familyLastName;
    }

    public void setFamilyLastName(FamilyLastName familyLastName) {
        this.familyLastName = familyLastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected FamilyName clone() throws CloneNotSupportedException {
        FamilyName familyName = new FamilyName(name);
        familyName.familyLastName = familyLastName.clone();
        return familyName;
    }

    @Override
    public String toString() {
        return name + " " + familyLastName.getLastName();
    }
}

class FamilyLastName implements Cloneable {
    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public FamilyLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    protected FamilyLastName clone() throws CloneNotSupportedException {
        return (FamilyLastName) super.clone();
    }
}