package com.thurairaj.moneylion.repositories;

import com.thurairaj.moneylion.model.permission.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PermissionRepo extends JpaRepository<Permission, Long> {

    Optional<Permission> findByFeatureNameAndEmail(String feature, String user);

    default Optional<Permission> findByFeatureNameAndEmail(Permission permission) {
        return permission == null ? Optional.empty() : findByFeatureNameAndEmail(permission.getFeatureName(), permission.getEmail());
    }
}
