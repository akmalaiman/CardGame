package com.cardgame.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

}
