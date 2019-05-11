package dialogwindows;

public class Student {
    private String name;
    private int s_mat;
    private int s_pykh;
    private int s_och;

    public Student(String name, String s_mat, String s_pykh, String s_och) {
        this.name = name;
        this.s_mat = Integer.parseInt(s_mat);
        this.s_pykh = Integer.parseInt(s_pykh);
        this.s_och = Integer.parseInt(s_och);
    }
    
    public String getName(){
        return name;
    }

    public int getS_mat() {
        return s_mat;
    }

    public int getS_och() {
        return s_och;
    }

    public int getS_pykh() {
        return s_pykh;
    }
}
