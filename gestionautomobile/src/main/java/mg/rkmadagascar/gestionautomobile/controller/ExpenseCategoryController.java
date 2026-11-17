package mg.rkmadagascar.gestionautomobile.controller;

import mg.rkmadagascar.gestionautomobile.entity.ExpenseCategory;
import mg.rkmadagascar.gestionautomobile.service.ExpenseCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expense-categories")
@RequiredArgsConstructor
public class ExpenseCategoryController {

    private final ExpenseCategoryService service;

    @GetMapping
    public List<ExpenseCategory> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ExpenseCategory getById(@PathVariable String id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<ExpenseCategory> create(@RequestBody ExpenseCategory entity) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(entity));
    }

    @PutMapping("/{id}")
    public ExpenseCategory update(@PathVariable String id, @RequestBody ExpenseCategory entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
