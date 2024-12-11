package ru.brusnika.NauJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.brusnika.NauJava.model.TreeNode;

@Repository
public interface TreeNodeRepository extends JpaRepository<TreeNode, Integer> {

}
