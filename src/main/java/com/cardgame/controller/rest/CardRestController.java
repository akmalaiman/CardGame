package com.cardgame.controller.rest;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class CardRestController {

        @GetMapping("/shuffleCard")
        public ArrayList shuffleCard() {

                ArrayList result = new ArrayList();

                String[] cardDetails = {"2@", "2#", "2^", "2*", "3@", "3#", "3^", "3*", "4@", "4#", "4^", "4*", "5@", "5#", "5^", "5*", "6@", "6#", "6^", "6*", "7@", "7#", "7^", "7*", "8@", "8#", "8^", "8*", "9@", "9#", "9^", "9*", "10@", "10#", "10^", "10*", "J@", "J#", "J^", "J*", "Q@", "Q#", "Q^", "Q*", "K@", "K#", "K^", "K*", "A@", "A#", "A^", "A*"};

                String row1[] = new String[12];
                String row2[] = new String[12];
                String row3[] = new String[12];
                String row4[] = new String[12];
                String row5[] = new String[4];

                // Shuffle the array
                Collections.shuffle(Arrays.asList(cardDetails));

                // Create a new array to store shuffled elements
                String[] shuffledCardDetails = new String[cardDetails.length];

                // Copy shuffled elements to shuffledCardDetails
                System.arraycopy(cardDetails, 0, shuffledCardDetails, 0, cardDetails.length);

                // Define the size of each row
                int rowSize = 12;

                // Split shuffled cards into rows
                for (int i = 0; i < 5; i++) {
                        int startIndex = i * rowSize;
                        int endIndex = Math.min(startIndex + rowSize, cardDetails.length);
                        List<String> row = Arrays.asList(Arrays.copyOfRange(cardDetails, startIndex, endIndex));
                        result.add(row);
                }

                return result;
        }

        @PostMapping("/distributeCard")
        public List<List<String>> distributeCards(@RequestBody List<List<String>> data) {

                List<String> allCards = new ArrayList<>();
                for (List<String> row : data) {
                        allCards.addAll(row);
                }

                List<List<String>> players = new ArrayList<>();
                int numPlayers = 4;
                int cardsPerPlayer = allCards.size() / numPlayers;

                for (int i = 0; i < numPlayers; i++) {
                        List<String> playerHand = new ArrayList<>();

                        for (int j = 0; j < cardsPerPlayer; j++) {
                                playerHand.add(allCards.get(i + j * numPlayers));
                        }

                        players.add(playerHand);
                }

                return players;

        }

        @PostMapping("/findWinner")
        public String findWinner(@RequestBody List<List<String>> data) {

                String winner = "No winner";

                if (!data.isEmpty()) {
                        Map<String, Integer> playerCardCounts = new HashMap<>();

                        for (List<String> playerHand : data) {
                                Map<Character, Integer> cardCounts = new HashMap<>();

                                // Count occurrences of each card number in the player's hand
                                for (String card : playerHand) {
                                        char cardNumber = card.charAt(0);
                                        cardCounts.put(cardNumber, cardCounts.getOrDefault(cardNumber, 0) + 1);
                                }

                                // Find the maximum count of cards of the same number for the player
                                int maxCount = 0;
                                for (int count : cardCounts.values()) {
                                        maxCount = Math.max(maxCount, count);
                                }

                                // Update the maximum count for the player
                                playerCardCounts.put(playerHand.get(0), maxCount);
                        }

                        // Find the player with the maximum count of cards of the same number
                        int maxCount = 0;
                        for (int count : playerCardCounts.values()) {
                                maxCount = Math.max(maxCount, count);
                        }

                        // Determine the winner(s)
                        StringBuilder winners = new StringBuilder();
                        for (Map.Entry<String, Integer> entry : playerCardCounts.entrySet()) {
                                if (entry.getValue() == maxCount) {
                                        if (winners.length() > 0) {
                                                winners.append(", ");
                                        }

                                        String player = entry.getKey();
                                        player = player.substring(0, player.length() - 2);

                                        winners.append(player);
                                }
                        }

                        winner = (winners.length() > 0) ? winners.toString() : "No winner";
                }

                return "Winner: " + winner;
        }

}
