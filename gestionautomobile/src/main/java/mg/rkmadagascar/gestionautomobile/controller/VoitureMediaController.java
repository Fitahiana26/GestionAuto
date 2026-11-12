package mg.rkmadagascar.gestionautomobile.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.VoitureMedia;
import mg.rkmadagascar.gestionautomobile.service.VoitureMediaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/voiture-medias")
@RequiredArgsConstructor
public class VoitureMediaController {

    private final VoitureMediaService voitureMediaService;

    @GetMapping
    public List<VoitureMedia> findAll() {
        return voitureMediaService.findAll();
    }

    @GetMapping("/{id}")
    public VoitureMedia findById(@PathVariable String id) {
        return voitureMediaService.findById(id);
    }

    @PostMapping
    public ResponseEntity<VoitureMedia> creer(@RequestBody VoitureMedia voitureMedia) {
        return ResponseEntity.status(HttpStatus.CREATED).body(voitureMediaService.creer(voitureMedia));
    }

    @PutMapping("/{id}")
    public VoitureMedia modifier(@PathVariable String id, @RequestBody VoitureMedia voitureMedia) {
        return voitureMediaService.modifier(id, voitureMedia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable String id) {
        voitureMediaService.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}
