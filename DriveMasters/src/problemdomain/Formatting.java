package problemdomain;

public final class Formatting {
    private Formatting(){}

    public static String trunkSizeFull(String code) {
        if (code == null) return "";
        switch(code.toUpperCase()) {
            case "L": return "Large/spacious Trunk";
            case "M": return "Moderate Trunk";
            case "S": return "Small Trunk";
            default: return code;
        }
    }

    public static String hatchTypeFull(String code) {
        if (code == null) return "";
        switch(code.toUpperCase()) {
            case "S": return "Standard Liftgate";
            case "T": return "Split Liftgate";
            case "P": return "Power Liftgate";
            default: return code;
        }
    }

    public static String powerTrainFull(String code) {
        if (code == null) return "";
        switch(code.toUpperCase()) {
            case "E": return "Series Hybrid";
            case "A": return "Parallel Hybrid";
            case "PHEV": return "Plug-in Hybrid";
            default: return code;
        }
    }

    public static String cargoBedsFull(String code) {
        if (code == null) return "";
        switch(code.toUpperCase()) {
            case "SB": return "Short Bed";
            case "EB": return "Extended Bed";
            case "DB": return "Dump Bed";
            default: return code;
        }
    }
}
