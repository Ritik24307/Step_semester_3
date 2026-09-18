class GymMember {
    protected String memberId;
    protected int monthlyFee;

    private int[] lateFeeHistory;
    private int lateFeeCount;

    public GymMember(String memberId, int monthlyFee) {
        if (memberId == null ||
            memberId.trim().isEmpty() ||
            memberId.length() < 4) {
            throw new IllegalArgumentException("Invalid member ID");
        }

        this.memberId = memberId;
        this.monthlyFee = monthlyFee;
        this.lateFeeHistory = new int[10];
        this.lateFeeCount = 0;
    }

    protected void chargeLateFee(int amount) {

        if (lateFeeCount < lateFeeHistory.length) {
            lateFeeHistory[lateFeeCount] = amount;
            lateFeeCount++;
        }
    }

    public int[] getLateFeeHistory() {

        int[] result = new int[lateFeeCount];

        for (int i = 0; i < lateFeeCount; i++) {
            result[i] = lateFeeHistory[i];
        }

        return result;
    }

    public int getTotalLateFees() {

        int total = 0;

        for (int i = 0; i < lateFeeCount; i++) {
            total += lateFeeHistory[i];
        }

        return total;
    }
}

class PremiumMember extends GymMember {

    private String trainerName;

    public PremiumMember(String memberId, int monthlyFee,
                         String trainerName) {
        super(memberId, monthlyFee);
        this.trainerName = trainerName;
    }

    @Override
    protected void chargeLateFee(int amount) {
        super.chargeLateFee(amount / 2);
    }
}

public class LateFeeLedger {

    public static void main(String[] args) {

        PremiumMember p =
            new PremiumMember(
                "MEM5", 2000, "Coach Riya"
            );

        p.chargeLateFee(200);

        System.out.println(
            p.getTotalLateFees()
        );

        int[] history = p.getLateFeeHistory();

        history[0] = 999;

        System.out.println(
            java.util.Arrays.toString(
                p.getLateFeeHistory()
            )
        );
    }
}