package com.rekik.jbcpalindrometester2018;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class MainController {

    @RequestMapping("/")
    public String showPalindrome(){
        return "stringinput";
    }

    @PostMapping("/savephrase")
    public String saveRandom(@RequestParam("original") String original, Model model) {

        String phrase = original.toLowerCase();

        String backwards = "";

        //loop through the string backwards, starting with the last
        for(int i=phrase.length()-1; i>=0; i--){
            //Extract each letter as the next character and build the backwards string
            String letter = phrase.substring(i,i+1);
            backwards += letter;
        }

        // A palindrome is a word or phrase that is the same forward and backward
        // This is where we check that

        if(phrase.equals(backwards)){
            model.addAttribute("palindrome", original + " is a palindrome!");
        }else {
            model.addAttribute("palindrome",original + " is not a palindrome!");
        }
        return "index";
    }


}
