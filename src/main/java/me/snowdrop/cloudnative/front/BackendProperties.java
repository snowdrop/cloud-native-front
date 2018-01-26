package me.snowdrop.cloudnative.front;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "service.backend")
public class BackendProperties {

    private static final String NOTE_PATH_FORMAT = "http://%s/%s/%s";
    private static final String NOTE_PATH_FORMAT_WITH_ID = NOTE_PATH_FORMAT + "/%d";

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
        return String.format(NOTE_PATH_FORMAT, name, apiPath, notesPath);
    }

    public String getNotesFullPath(int id) {
        return String.format(NOTE_PATH_FORMAT_WITH_ID, name, apiPath, notesPath, id);
    }
}
