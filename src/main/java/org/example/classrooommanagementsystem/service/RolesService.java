package org.example.classrooommanagementsystem.service;

import org.example.classrooommanagementsystem.entity.Roles;
import org.example.classrooommanagementsystem.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolesService {
    private final RolesRepository roleRepository;

    @Autowired
    public RolesService(RolesRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Roles> getAllRoles() {
        return roleRepository.findAll();
    }

    public Optional<Roles> getRoleById(Long roleId) {
        return roleRepository.findById(roleId);
    }

    public Roles createRole(Roles role) {
        return roleRepository.save(role);
    }
}
