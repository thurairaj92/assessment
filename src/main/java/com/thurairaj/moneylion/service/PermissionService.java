package com.thurairaj.moneylion.service;

import com.thurairaj.moneylion.exception.feature.PermissionUpdateFailed;
import com.thurairaj.moneylion.model.permission.Permission;
import com.thurairaj.moneylion.repositories.PermissionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionService {

    @Autowired
    private PermissionRepo permissionRepo;

    public Permission save(Permission permission) {
        try {
            return permissionRepo.saveAndFlush(permission);
        } catch (DataAccessException exception) {
            throw new PermissionUpdateFailed();
        }
    }

    public Permission getPermission(Permission permission) {
        return permissionRepo.findByFeatureNameAndEmail(permission).orElse(permission);
    }
}
