class GymMember {
    protected String memberId;
    protected int monthlyFee;
    private int sessionsAttended;

    public GymMember(String memberId, int monthlyFee) {
        if (memberId == null ||
            memberId.trim().isEmpty() ||
            memberId.length() < 4) {
            throw new IllegalArgumentException("Invalid member ID");
        }

        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        this.sessionsAttended = 0;
    }

    public void attendSession() {
        sessionsAttended++;
    }

    public int getSessionsAttended() {
        return sessionsAttended;
    }

    public void displayInfo() {
        System.out.println(
            "Standard | Sessions: " +
            sessionsAttended
        );
    }
}

class PremiumMember extends GymMember {

    private String trainerName;

    public PremiumMember(String memberId, int monthlyFee,
                         String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    public String getTrainerName() {
        return trainerName;
    }

    @Override
    public void displayInfo() {
        System.out.println(
            "Premium | Trainer: " +
            trainerName +
            " | Sessions: " +
            getSessionsAttended()
        );
    }
}

public class AttendanceAnnouncer {

    static String batchPrint(GymMember[] members) {

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < members.length; i++) {

            if (members[i] instanceof PremiumMember) {

                PremiumMember premium =
                    (PremiumMember) members[i];

                result.append(
                    "Premium | Trainer: " +
                    premium.getTrainerName() +
                    " | Sessions: " +
                    premium.getSessionsAttended()
                );

                result.append(
                    " [Trainer via downcast: " +
                    premium.getTrainerName() +
                    "] | "
                );

            } else {

                result.append(
                    "Standard | Sessions: " +
                    members[i].getSessionsAttended() +
                    " | "
                );
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        GymMember[] members = {
            new GymMember("MEM6", 1000),
            new PremiumMember(
                "MEM7", 2000, "Coach Riya"
            )
        };

        System.out.println(
            batchPrint(members)
        );
    }
}