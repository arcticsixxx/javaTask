package ru.brusnika.NauJava.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import ru.brusnika.NauJava.model.TreeNode;
import ru.brusnika.NauJava.repository.TreeNodeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TreeNodeService {
    private final TreeNodeRepository repository;

    public TreeNodeService(TreeNodeRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public List<TreeNode> findAll() {
        return repository.findAll();
    }

    @Transactional
    public Optional<TreeNode> findById(Integer id) {
        return repository.findById(id);
    }

    @Transactional
    public TreeNode save(TreeNode treeNode) {
        return repository.save(treeNode);
    }

    @Transactional
    public TreeNode update(Integer id, TreeNode updatedTreeNode) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setName(updatedTreeNode.getName());
                    existing.setDescription(updatedTreeNode.getDescription());
                    existing.setType(updatedTreeNode.getType());
                    existing.setParent(updatedTreeNode.getParent());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new IllegalArgumentException("TreeNode with id " + id + " not found"));
    }

    @Transactional
    public void delete(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
        } else {
            throw new IllegalArgumentException("TreeNode with id " + id + " not found");
        }
    }
}
