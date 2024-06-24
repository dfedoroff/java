package ru.gb.myspringdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.myspringdemo.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
