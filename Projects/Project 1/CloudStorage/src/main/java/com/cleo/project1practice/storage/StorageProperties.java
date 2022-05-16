package com.cleo.project1practice.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
public class StorageProperties {

    /**
     * Folder location for storing files
     */
    private String location = "/Users/deven/storage";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public StorageProperties() {
    }
}
