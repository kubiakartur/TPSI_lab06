/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wizut.tpsi.springlab1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Moya
 */
@Controller
public class CalculatorController {
    @RequestMapping("/zad1")
    public String Zad1(Model model, Integer x, Integer y) {
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        Integer wynik = x + y;
        model.addAttribute("wynik", wynik);

        return "zad1";
    }
    
    @RequestMapping("/zad2")
    public String Zad2(Model model, Integer x, Integer y, String z) {
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        Integer wynik = null;
        
        switch(z){
            case "dodawanie":
                wynik = x + y;
                z = "+";
                break;
            case "odejmowanie":
                wynik = x - y;
                z = "-";
                break;
            case "mnozenie":
                wynik = x * y;
                z = "*";
                break;
        }
        
        model.addAttribute("z", z);
        model.addAttribute("wynik", wynik);
        return "zad2";
    }
    
    @RequestMapping("/zad3")
    public String Zad3(Model model, CalculatorForm form) {
        Integer wynik = 0;
        Integer x = form.getX();
        Integer y = form.getY();
        String z = form.getZ();
        
        switch(z){
            case "dodawanie":
                wynik = x + y;
                form.setZ("+");
                break;
            case "odejmowanie":
                wynik = x - y;
                form.setZ("-");
                break;
            case "mnozenie":
                wynik = x * y;
                form.setZ("*");
                break;
        }
        
        form.setWynik(wynik);
        model.addAttribute("form", form);
        return "zad3";
    }
}
