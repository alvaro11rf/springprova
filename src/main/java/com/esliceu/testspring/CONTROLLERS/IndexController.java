package com.esliceu.testspring.CONTROLLERS;

import com.esliceu.testspring.Dto.OperationDTO;
import com.esliceu.testspring.Entities.Operation;
import com.esliceu.testspring.Services.OperationService;
import com.esliceu.testspring.Services.TestService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.net.http.HttpRequest;
import java.util.List;

@Controller
public class IndexController {
    @Autowired//TestService será instanciado por el propio Spring
    HttpSession session;
    TestService testService;
    OperationService operationService;

// Aquest constructor es obligatori si volem que spring
// gestioni les dependencies de aquest controlador
    IndexController (TestService testService, OperationService operationService){
        this.testService = testService;
        this.operationService = operationService;
    }
    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("nom", "B<b>i</b>ll");
        model.addAttribute("numeros", new Integer[]{1, 2, 3, 4, 5, 6});
        return "test";
    }

    @GetMapping("/calc")
    public String calc(){
        return "calc";
    }

    @PostMapping("/suma")
    public String sumaPost(Model model,
                           @RequestParam int n1,
                           @RequestParam int n2,
                           @RequestParam String top ) {

        int r = n1 + n2;
        operationService.newOperation(n1, n2, top);
        model.addAttribute("resultat", r);
        return "suma";
    }
    @GetMapping("/historial")
    public String historial(Model model){
        List<OperationDTO> operationList = operationService.findallOperations();
        model.addAttribute("operacions",operationList);
        return "historial";
    }
}
