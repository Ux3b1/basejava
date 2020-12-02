package com.urise.webapp.model;

import java.util.List;

public class OrganizationSection implements Section{
    List<Organization> organizations;

    public OrganizationSection(List<Organization> organizations) {
        this.organizations = organizations;
    }

    public List<Organization> getOrganizations() {
        return organizations;
    }

    @Override
    public String getContent() {
        return null;
    }
}
