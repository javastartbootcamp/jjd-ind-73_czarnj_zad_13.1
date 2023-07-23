package pl.javastart.voting;

import java.util.ArrayList;
import java.util.List;

/**
 * Możesz dodać kolejne metody i pola do klasy. Nie zmieniaj istniejących metod.
 */
public class VotingResult {
    private static final String FOR_DECISION = "ZA";
    private static final String AGAINST_DECISION = "PRZECIW";
    private static final String NO_DECISION = "WSTRZYMAŁ SIĘ";
    private static final int FOR_PERCENTAGE_100 = 100;
    private List<Vote> votes = new ArrayList<>();

    void addVote(Vote vote) {
        votes.add(vote);
    }

    /**
     * Metoda powinna drukować wyniki głosowania w takiej postaci:
     * Głosów za: 56.53%
     * Głosów przeciw: 35.00%
     * Wstrzymało się: 8.47%
     */
    public void printResults() {
        int forSum = 0;
        int againstSum = 0;
        int noDecisionSum = 0;
        for (Vote vote : votes) {
            if (vote.getVote() == null) {
                noDecisionSum++;
            } else if (vote.getVote()) {
                forSum++;
            } else {
                againstSum++;
            }
        }
        System.out.printf("Wstrzymało się: %.2f%%%n",
                (double) FOR_PERCENTAGE_100 * noDecisionSum / votes.size());
        System.out.printf("Głosów za: %.2f%%%n",
                (double) FOR_PERCENTAGE_100 * forSum / votes.size());
        System.out.printf("Głosów przeciw: %.2f%%%n",
                (double) FOR_PERCENTAGE_100 * againstSum / votes.size());
    }

    /**
     * Metoda przyjmuje imię i nazwisko głosującego, np "Zigniew Siobro".
     * Uzupełnij tę metodę, żeby drukowała informację w formie:
     * Zigniew Siobro: ZA
     * Nie zmieniaj sygnatury tej metody!
     */
    public void printVoteForVoter(String voterName) {
        boolean containVoter = false;
        for (Vote vote : votes) {
            if (vote.getVoter().equals(voterName)) {
                System.out.printf("%s: %s%n", vote.getVoter(), convertVoteToString(vote.getVote()));
                containVoter = true;
            }
        }
        if (!containVoter) {
            System.out.println("Nie ma takiego posła");
        }
    }

    private static String convertVoteToString(Boolean vote) {
        if (vote == null) {
            return NO_DECISION;
        } else if (vote) {
            return FOR_DECISION;
        } else {
            return AGAINST_DECISION;
        }
    }
}
