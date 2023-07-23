package pl.javastart.voting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Voting {
    private static final String FOR_DECISION = "z";
    private static final String AGAINST_DECISION = "p";
    private static final String NO_DECISION = "w";

    public static void main(String[] args) {
        List<String> voters = new ArrayList<>();

        voters.add("Jan Kowalski");
        voters.add("Zigniew Siobro");
        voters.add("Zbyszek Stonoga");

        Voting voting = new Voting();

        VotingResult votingResult = voting.executeVoting(voters, new Scanner(System.in));
        votingResult.printResults();
        votingResult.printVoteForVoter("Zigniew Siobro");
        votingResult.printVoteForVoter("Jan Kowalski");
        votingResult.printVoteForVoter("Zbyszek Stonoga");
    }

    /**
     * Uzupełnij metodę metodę, ale nie zmieniaj jej sygnatury! (typu tego, co przyjmuje i zwraca).
     * do wczytywania danych od użytkownika użyj scannera z parametru
     * Metoda powinna pobrać głos dla każdego przekazanego głosującego i zapisać wyniki głosowania do VotingResult
     */
    VotingResult executeVoting(List<String> voters, Scanner scanner) {
        String decision;
        boolean isVoteCorrect = false;
        VotingResult votingResult = new VotingResult();
        for (int i = 0; i < voters.size();) {
            while (!isVoteCorrect) {
                System.out.printf("Jak głosuje %s? (z - za, p - przeciw, w - wstrzymanie się)%n",
                        voters.get(i));
                decision = scanner.nextLine();
                if (decision.equals(FOR_DECISION) || decision.equals(AGAINST_DECISION)
                        || decision.equals(NO_DECISION)) {
                    Vote vote = new Vote(voters.get(i), convertVote(decision));
                    votingResult.addVote(vote);
                    i++;
                    isVoteCorrect = true;
                }
            }
            isVoteCorrect = false;
        }
        return votingResult;
    }

    private static Boolean convertVote(String vote) {
        return switch(vote) {
            case FOR_DECISION -> true;
            case AGAINST_DECISION -> false;
            default -> null;
        };
    }

}
