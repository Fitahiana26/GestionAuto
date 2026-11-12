package mg.rkmadagascar.gestionautomobile.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.Contact;
import mg.rkmadagascar.gestionautomobile.service.ContactService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactService contactService;

    @GetMapping
    public List<Contact> findAll() {
        return contactService.findAll();
    }

    @GetMapping("/{id}")
    public Contact findById(@PathVariable String id) {
        return contactService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Contact> creer(@RequestBody Contact contact) {
        return ResponseEntity.status(HttpStatus.CREATED).body(contactService.creer(contact));
    }

    @PutMapping("/{id}")
    public Contact modifier(@PathVariable String id, @RequestBody Contact contact) {
        return contactService.modifier(id, contact);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable String id) {
        contactService.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}
