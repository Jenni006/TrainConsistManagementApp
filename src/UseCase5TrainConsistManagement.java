import java.util.LinkedHashSet;
import java.util.Set;

public class UseCase5TrainConsistManagement {

    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println(" UC5 Preserve Insertion Order of Bogies ");
        System.out.println("==================================");

        Set<String> formation = new LinkedHashSet<>();

        formation.add("Engine");
        formation.add("Bogie1");
        formation.add("Bogie2");
        formation.add("Bogie3");
        formation.add("Bogie2");
        formation.add("PantryCar");
        formation.add("Bogie1");

        System.out.println(formation);
    }
}