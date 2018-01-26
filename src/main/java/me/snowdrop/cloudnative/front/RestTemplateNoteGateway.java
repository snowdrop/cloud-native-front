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
    public List<Note> all() {
        return restTemplate.exchange(URI.create(backendProperties.getNotesFullPath()),
                HttpMethod.GET, null, new ParameterizedTypeReference<List<Note>>() {
        }).getBody();
    }

    @Override
    public Note add(Note note) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        final HttpEntity<Note> entity = new HttpEntity<>(note, headers);
        return restTemplate.postForEntity(
                URI.create(backendProperties.getNotesFullPath()), entity, Note.class
        ).getBody();
    }

    @Override
    public Note update(Note note) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        final HttpEntity<Note> entity = new HttpEntity<>(note, headers);
        return restTemplate.exchange(
                URI.create(backendProperties.getNotesFullPath(note.getId())), HttpMethod.PUT, entity, Note.class
        ).getBody();
    }

    @Override
    public void delete(long id) {
        restTemplate.delete(URI.create(backendProperties.getNotesFullPath(id)));
    }
}
