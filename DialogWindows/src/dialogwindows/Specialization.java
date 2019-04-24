package dialogwindows;

public class Specialization {
    private String name;
    private int scores;

    public Specialization(String name, String scores) {
        this.name = name;
        this.scores =  Integer.parseInt(scores);
    }

    public String getName() {
        return name;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(String scores) {
        this.scores = Integer.parseInt(scores);
    }
    
    
}
