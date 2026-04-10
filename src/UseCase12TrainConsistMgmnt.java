import java.util.ArrayList;
import java.util.List;

public class UseCase12TrainConsistMgmnt {

    static class GoodsBogie {
        String type;
        String cargo;

        GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return String.format("Bogie Type: %s, Cargo: %s", type, cargo);
        }
    }

    public static void main(String[] args) {
        System.out.println("===============================================");
        System.out.println(" UC12 - Safety Compliance Check for Goods Bogies ");
        System.out.println("===============================================\n");

        List<GoodsBogie> goodsBogies = new ArrayList<>();
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Rectangular", "Coal"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));

        System.out.println("Checking Goods Bogies for Safety:");
        goodsBogies.forEach(System.out::println);

        // --- ENFORCE SAFETY RULES USING allMatch ---
        // Rule: If the type is Cylindrical, cargo must be Petroleum.
        // Logic: (Not Cylindrical) OR (Cargo is Petroleum)
        boolean isTrainSafe = goodsBogies.stream()
                .allMatch(b -> !b.type.equalsIgnoreCase("Cylindrical") ||
                        b.cargo.equalsIgnoreCase("Petroleum"));

        System.out.println("\n-----------------------------------------------");
        if (isTrainSafe) {
            System.out.println("RESULT: Train is SAFETY COMPLIANT.");
        } else {
            System.out.println("RESULT: SAFETY VIOLATION DETECTED! Unsafe cargo configuration.");
        }
        System.out.println("-----------------------------------------------");
    }
}