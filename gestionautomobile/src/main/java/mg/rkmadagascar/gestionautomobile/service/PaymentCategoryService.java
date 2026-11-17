package mg.rkmadagascar.gestionautomobile.service;

import mg.rkmadagascar.gestionautomobile.entity.PaymentCategory;
import mg.rkmadagascar.gestionautomobile.repository.PaymentCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentCategoryService {

    private final PaymentCategoryRepository repository;

    @Transactional(readOnly = true)
    public List<PaymentCategory> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public PaymentCategory findById(String id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "PaymentCategory introuvable : " + id));
    }

    @Transactional
    public PaymentCategory create(PaymentCategory entity) {
        entity.setId(null);
        return repository.save(entity);
    }

    @Transactional
    public PaymentCategory update(String id, PaymentCategory entity) {
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
