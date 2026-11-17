package mg.rkmadagascar.gestionautomobile.service;

import mg.rkmadagascar.gestionautomobile.entity.PaymentStatus;
import mg.rkmadagascar.gestionautomobile.repository.PaymentStatusRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentStatusService {

    private final PaymentStatusRepository repository;

    @Transactional(readOnly = true)
    public List<PaymentStatus> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public PaymentStatus findById(String id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "PaymentStatus introuvable : " + id));
    }

    @Transactional
    public PaymentStatus create(PaymentStatus entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    @Transactional
    public PaymentStatus update(String id, PaymentStatus entity) {
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
