package mg.rkmadagascar.gestionautomobile.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.Faq;
import mg.rkmadagascar.gestionautomobile.service.FaqService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/faqs")
@RequiredArgsConstructor
public class FaqController {

    private final FaqService faqService;

    @GetMapping
    public List<Faq> findAll() {
        return faqService.findAll();
    }

    @GetMapping("/{id}")
    public Faq findById(@PathVariable String id) {
        return faqService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Faq> creer(@RequestBody Faq faq) {
        return ResponseEntity.status(HttpStatus.CREATED).body(faqService.creer(faq));
    }

    @PutMapping("/{id}")
    public Faq modifier(@PathVariable String id, @RequestBody Faq faq) {
        return faqService.modifier(id, faq);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable String id) {
        faqService.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}
