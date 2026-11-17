package mg.rkmadagascar.gestionautomobile.service;

import mg.rkmadagascar.gestionautomobile.entity.Payment;
import mg.rkmadagascar.gestionautomobile.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository repository;

    @Transactional(readOnly = true)
    public List<Payment> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Payment findById(String id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Payment introuvable : " + id));
    }

    @Transactional
    public Payment create(Payment entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    @Transactional
    public Payment update(String id, Payment entity) {
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
