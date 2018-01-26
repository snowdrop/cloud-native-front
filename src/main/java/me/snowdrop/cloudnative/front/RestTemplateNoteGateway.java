package me.snowdrop.cloudnative.front;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Component
public class RestTemplateNoteGateway implements NoteGateway {

    private final BackendProperties backendProperties;
    private final RestTemplate restTemplate;

    public RestTemplateNoteGateway(BackendProperties backendProperties, RestTemplate restTemplate) {
        this.backendProperties = backendProperties;
        this.restTemplate = restTemplate;
    }

    @Override
    public List<Note> allNotes() {
        return restTemplate.exchange(URI.create(backendProperties.getNotesFullPath()),
                 HttpMethod.GET, null, new ParameterizedTypeReference<List<Note>>() {
        }).getBody();
    }

    @Override
    public Note addNote(Note note) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        final HttpEntity<Note> entity = new HttpEntity<Note>(note, headers);
        return restTemplate.postForEntity(
                URI.create(backendProperties.getNotesFullPath()), entity, Note.class
        ).getBody();
    }
}