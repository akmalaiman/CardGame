package com.cardgame.controller;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;

@Controller
public class HomeController {

        @GetMapping("/")
        public String showHomePage(Model model) {

                ArrayList result = new ArrayList();

                String[] cardDetails = {"2@", "2#", "2^", "2*", "3@", "3#", "3^", "3*", "4@", "4#", "4^", "4*", "5@", "5#", "5^", "5*", "6@", "6#", "6^", "6*", "7@", "7#", "7^", "7*", "8@", "8#", "8^", "8*", "9@", "9#", "9^", "9*", "10@", "10#", "10^", "10*", "J@", "J#", "J^", "J*", "Q@", "Q#", "Q^", "Q*", "K@", "K#", "K^", "K*", "A@", "A#", "A^", "A*"};

                String row1[] = new String[12];
                String row2[] = new String[12];
                String row3[] = new String[12];
                String row4[] = new String[12];
                String row5[] = new String[4];

                for (int i = 0; i < 12; i++) {
                        row1[i] = cardDetails[i];
                        row2[i] = cardDetails[i + 12];
                        row3[i] = cardDetails[i + 24];
                        row4[i] = cardDetails[i + 36];
                }

                for (int i = 0; i < 4; i++) {
                        row5[i] = cardDetails[i + 48];
                }

                result.add(Arrays.asList(row1));
                result.add(Arrays.asList(row2));
                result.add(Arrays.asList(row3));
                result.add(Arrays.asList(row4));
                result.add(Arrays.asList(row5));

                model.addAttribute("cardDetails", result);

                return "index";
        }

}
