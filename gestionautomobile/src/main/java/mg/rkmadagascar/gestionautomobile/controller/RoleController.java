package mg.rkmadagascar.gestionautomobile.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.Role;
import mg.rkmadagascar.gestionautomobile.service.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping
    public List<Role> findAll() {
        return roleService.findAll();
    }

    @GetMapping("/{id}")
    public Role findById(@PathVariable String id) {
        return roleService.findById(id);
    }

    @PostMapping
    public ResponseEntity<Role> creer(@RequestBody Role role) {
        return ResponseEntity.status(HttpStatus.CREATED).body(roleService.creer(role));
    }

    @PutMapping("/{id}")
    public Role modifier(@PathVariable String id, @RequestBody Role role) {
        return roleService.modifier(id, role);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable String id) {
        roleService.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}
