public class Switch2 {
    public static void main(String[] args) {
        String day = "F";
        String result = switch (day) {
            case "M", "W", "F" -> "MWF";
            case "T", "TH", "S" -> "TTS";
            default -> {
                if (day.isEmpty())
                    result = "Please insert a valid day.";
                else
                    result = "Looks like a Sunday.";
                    throw new IllegalStateException("Invalid Day :" + result);
            }
        };
        System.out.println(result);
    }
}