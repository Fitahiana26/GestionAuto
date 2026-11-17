package mg.rkmadagascar.gestionautomobile.service;

import mg.rkmadagascar.gestionautomobile.entity.Media;
import mg.rkmadagascar.gestionautomobile.repository.MediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MediaService {

    private final MediaRepository repository;

    @Transactional(readOnly = true)
    public List<Media> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Media findById(String id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Media introuvable : " + id));
    }

    @Transactional
    public Media create(Media entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    @Transactional
    public Media update(String id, Media entity) {
        findById(id);
        entity.setId(id);
        return repository.save(entity);
    }

    @Transactional
    public void delete(String id) {
        findById(id);
        repository.deleteById(id);
    }
}
