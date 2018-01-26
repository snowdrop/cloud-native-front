package me.snowdrop.cloudnative.front;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "service.backend")
public class BackendProperties {

    @NotBlank
    private String name;
    private String apiPath = "api";
    private String notesPath = "notes";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApiPath() {
        return apiPath;
    }

    public void setApiPath(String apiPath) {
        this.apiPath = apiPath;
    }

    public String getNotesPath() {
        return notesPath;
    }

    public void setNotesPath(String notesPath) {
        this.notesPath = notesPath;
    }

    public String getNotesFullPath() {
        return String.format("http://%s/%s/%s", name, apiPath, notesPath);
    }
}
