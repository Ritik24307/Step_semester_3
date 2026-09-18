class Participant {
    String name;
    String teamName;
    boolean registered;

    // Constructor for participants who already have a team
    public Participant(String name, String teamName) {
        this.name = name;
        this.teamName = teamName;
        this.registered = true;
    }

    // Constructor for solo participants
    public Participant(String name) {
        this(name, "Unassigned");
    }

    // Method to print participant status
    public void printStatus() {
        System.out.println(name + " | " + teamName + " | Registered: " + registered);
    }
}

public class HackathonRegistration {
    public static void main(String[] args) {

        String[] names = {"Ravi", "Meera", "Karthik", "Divya"};
        String[] teamNames = {"ByteBusters", "", "CodeCrafters", ""};

        // Process every participant
        for (int i = 0; i < names.length; i++) {

            Participant participant;

            // Check whether team name is empty
            if (teamNames[i].isEmpty()) {
                participant = new Participant(names[i]);
            } else {
                participant = new Participant(names[i], teamNames[i]);
            }

            // Print participant status
            participant.printStatus();
        }
    }
}