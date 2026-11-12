package mg.rkmadagascar.gestionautomobile.service;

import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import mg.rkmadagascar.gestionautomobile.entity.Role;
import mg.rkmadagascar.gestionautomobile.repository.RoleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RoleService {

    private final RoleRepository roleRepository;

    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    public Role findById(String id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Role introuvable : " + id));
    }

    @Transactional
    public Role creer(Role role) {
        return roleRepository.save(role);
    }

    @Transactional
    public Role modifier(String id, Role role) {
        findById(id);
        role.setIdRole(id);
        return roleRepository.save(role);
    }

    @Transactional
    public void supprimer(String id) {
        roleRepository.delete(findById(id));
    }
}
