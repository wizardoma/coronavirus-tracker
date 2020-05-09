package com.techbek.coronavirus.controllers;

import com.techbek.coronavirus.services.CoronavirusDataService;
import models.LocationStats;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Locale;

@Controller
public class HomeController {
    @Autowired
    CoronavirusDataService coronavirusDataService;

    @GetMapping
    public String home(Model model){
        List<LocationStats> allStats = coronavirusDataService.getAllStats();
        int totalCases = allStats.stream().mapToInt(LocationStats::getLatestTotalCases).sum();
        int newCases= allStats.stream().mapToInt(LocationStats::getNewCases).sum();;

        model.addAttribute("virusData", allStats);
        model.addAttribute("totalCases", totalCases);
        model.addAttribute("newCases", newCases);


        return "home";
    }
}
