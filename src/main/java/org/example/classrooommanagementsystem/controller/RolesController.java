package org.example.classrooommanagementsystem.controller;

import org.example.classrooommanagementsystem.entity.Roles;
import org.example.classrooommanagementsystem.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RolesController {
    private final RolesService roleService;

    @Autowired
    public RolesController(RolesService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<Roles>> getAllRoles() {
        List<Roles> roles = roleService.getAllRoles();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Roles> getRoleById(@PathVariable Long id) {
        Optional<Roles> role = roleService.getRoleById(id);
        return role.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Roles> createRole(@RequestBody Roles role) {
        Roles savedRole = roleService.createRole(role);
        return ResponseEntity.ok(savedRole);
    }
}
