package com.urise.webapp.model;

import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.Collection;

public class Organization {
    public URL homePage;
    public Collection<Period> periods;
    public LocalDate startTime;
    public LocalDate endTime;
    public String title;
    public String description;

    public Organization(URL homePage, Collection<Period> periods, LocalDate startTime, LocalDate endTime, String title, String description) {
        this.homePage = homePage;
        this.periods = periods;
        this.startTime = startTime;
        this.endTime = endTime;
        this.title = title;
        this.description = description;
    }

    public URL getHomePage() {
        return homePage;
    }

    public Collection<Period> getPeriods() {
        return periods;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
