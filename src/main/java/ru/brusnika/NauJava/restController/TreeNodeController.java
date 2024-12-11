package ru.brusnika.NauJava.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.brusnika.NauJava.model.TreeNode;
import ru.brusnika.NauJava.service.TreeNodeService;

import java.util.List;

@RestController
@RequestMapping("/api/tree-nodes")
public class TreeNodeController {

    @Autowired
    private final TreeNodeService service;

    @Autowired
    public TreeNodeController(TreeNodeService service) {
        this.service = service;
    }

    @GetMapping
    public List<TreeNode> getAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public TreeNode getById(@PathVariable Integer id) {
        return service.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("TreeNode with id " + id + " not found"));
    }

    @PostMapping
    public TreeNode create(@RequestBody TreeNode treeNode) {
        return service.save(treeNode);
    }

    @PutMapping("/{id}")
    public TreeNode update(@PathVariable Integer id, @RequestBody TreeNode treeNode) {
        return service.update(id, treeNode);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }
}
