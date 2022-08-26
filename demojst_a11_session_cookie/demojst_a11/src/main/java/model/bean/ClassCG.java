package model.bean;

public class ClassCG {
    private int id;
    private String name;
    private int classTypeId;

    public ClassCG() {
    }

    public ClassCG(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public ClassCG(int id, String name, int classTypeId) {
        this.id = id;
        this.name = name;
        this.classTypeId = classTypeId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassTypeId() {
        return classTypeId;
    }

    public void setClassTypeId(int classTypeId) {
        this.classTypeId = classTypeId;
    }
}
