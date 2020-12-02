package com.urise.webapp.storage;

import com.urise.webapp.model.*;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public class ResumeTestData {
    public static void main(String[] args) throws MalformedURLException {
        Resume testResume = new Resume("Test Resume");

        testResume.contacts.put(ContactType.E_MAIL,"test@email.com");
        testResume.contacts.put(ContactType.TELEGRAM,"@testTelegram");
        testResume.contacts.put(ContactType.SKYPE,"testSkype");

        testResume.sections.put(SectionType.OBJECTIVE,new TextSection("разработчик"));
        testResume.sections.put(SectionType.PERSONAL,new TextSection("Личные качества"));

        List<String> archievement = new ArrayList<>();
        archievement.add("достижение 1");
        archievement.add("достижение 2");
        archievement.add("достижение 3");
        archievement.add("достижение 4");
        archievement.add("достижение 5");
        testResume.sections.put(SectionType.ACHIEVEMENT,new ListSection(archievement));

        List<String> qualifications = new ArrayList<>();
        archievement.add("квалификация 1");
        archievement.add("квалификация 2");
        archievement.add("квалификация 3");
        archievement.add("квалификация 4");
        archievement.add("квалификация 5");
        testResume.sections.put(SectionType.QUALIFICATIONS, new ListSection(qualifications));


    }
}
