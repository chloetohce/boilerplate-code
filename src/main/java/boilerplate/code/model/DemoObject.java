package boilerplate.code.model;

public class DemoObject {
    private String name;
    private String email;
    private long num;

    public DemoObject(String name, String email, long num) {
        this.name = name;
        this.email = email;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getNum() {
        return num;
    }

    public void setNum(long num) {
        this.num = num;
    }

        
}
