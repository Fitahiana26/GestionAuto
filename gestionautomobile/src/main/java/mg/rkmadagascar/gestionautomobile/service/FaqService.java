package mg.rkmadagascar.gestionautomobile.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.Faq;
import mg.rkmadagascar.gestionautomobile.repository.FaqRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FaqService {

    private final FaqRepository faqRepository;

    public List<Faq> findAll() {
        return faqRepository.findAll();
    }

    public Faq findById(String id) {
        return faqRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Faq introuvable : " + id));
    }

    @Transactional
    public Faq creer(Faq faq) {
        return faqRepository.save(faq);
    }

    @Transactional
    public Faq modifier(String id, Faq faq) {
        findById(id);
        faq.setIdFaq(id);
        return faqRepository.save(faq);
    }

    @Transactional
    public void supprimer(String id) {
        faqRepository.delete(findById(id));
    }
}
