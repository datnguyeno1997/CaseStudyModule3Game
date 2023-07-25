package model;

public enum ESize {
    S(1, "S"), M(2, "M"), L(3, "L");
    private int id;
    private String name;

    ESize() {
    }

    ESize(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public static ESize findESize(int id){
        for (ESize e : ESize.values()){
            if (e.getId() == id){
                return e;
            }
        }
        return null;
    }
    public static ESize findESize(String name){
        for (ESize e : ESize.values()){
            if (e.getName().equals(name)){
                return e;
            }
        }
        return null;
    }

    public long getId() {
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
}
