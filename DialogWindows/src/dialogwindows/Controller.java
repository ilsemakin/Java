package dialogwindows;

import java.util.ArrayList;
import javafx.stage.Stage;

public class Controller {
    
    public static void init(Stage primaryStage, ArrayList<Specialization> spec){
        View.showMainStage(primaryStage, spec);
    }
    
    public static ArrayList<String> editAbitur(ArrayList<Specialization> spec) {
        Student student = View.editAbiturDialog();
        return results(student, spec);
    }

    public static void editSpec(ArrayList<Specialization> spec) {
        ArrayList<String> results = View.editSpecDialog(spec);
        for (int i = 0; i < spec.size(); i++){
            spec.get(i).setScores(results.get(i));
        }
        
        for (Specialization sp : spec)
            System.out.println(sp.getScores());
    }
    
    private static ArrayList<String> results(Student std, ArrayList<Specialization> spec){
        ArrayList<String> result = new ArrayList<>();
        result.add(std.getName());
        for (Specialization sp : spec){
            if (std.getS_mat() + std.getS_och() + std.getS_pykh() >= sp.getScores())
                result.add(sp.getName());
        }
        
        return result;
    }
}
