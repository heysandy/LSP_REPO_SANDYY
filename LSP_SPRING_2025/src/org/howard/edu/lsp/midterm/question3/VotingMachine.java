package org.howard.edu.lsp.midterm.question3;

import java.util.HashMap;
import java.util.Map;

/**
 * Class representing a simple electronic voting machine.
 */
public class VotingMachine {
    private Map<String, Integer> candidates;

    /**
     * Constructor to initialize the VotingMachine with no candidates.
     */
    public VotingMachine() {
        candidates = new HashMap<>();
    }

    /**
     * Adds a candidate to the election.
     *
     * @param name Name of the candidate.
     */
    public void addCandidate(String name) {
        candidates.putIfAbsent(name, 0);
    }

    /**
     * Casts a vote for a candidate.
     *
     * @param name Candidate's name to vote for.
     * @return true if vote was successfully cast, false if candidate does not exist.
     */
    public boolean castVote(String name) {
        if (!candidates.containsKey(name)) {
            return false;
        }
        candidates.put(name, candidates.get(name) + 1);
        return true;
    }

    /**
     * Determines the candidate with the highest votes.
     *
     * @return String announcing the winner.
     */
    public String getWinner() {
        String winner = null;
        int maxVotes = -1;
        for (Map.Entry<String, Integer> entry : candidates.entrySet()) {
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }
        return winner + " WINS with " + maxVotes + " votes!!";
    }
}
