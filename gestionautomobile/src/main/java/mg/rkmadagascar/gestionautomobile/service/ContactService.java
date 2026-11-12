package mg.rkmadagascar.gestionautomobile.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.Contact;
import mg.rkmadagascar.gestionautomobile.repository.ContactRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ContactService {

    private final ContactRepository contactRepository;

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Contact findById(String id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contact introuvable : " + id));
    }

    @Transactional
    public Contact creer(Contact contact) {
        return contactRepository.save(contact);
    }

    @Transactional
    public Contact modifier(String id, Contact contact) {
        findById(id);
        contact.setIdContact(id);
        return contactRepository.save(contact);
    }

    @Transactional
    public void supprimer(String id) {
        contactRepository.delete(findById(id));
    }
}
