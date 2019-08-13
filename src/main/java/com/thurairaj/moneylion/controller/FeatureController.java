package com.thurairaj.moneylion.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import com.thurairaj.moneylion.exception.feature.PermissionUpdateFailed;
import com.thurairaj.moneylion.exception.feature.PermissionUpdateMissingInformation;
import com.thurairaj.moneylion.model.permission.Permission;
import com.thurairaj.moneylion.model.permission.PermissionEnabledResponse;
import com.thurairaj.moneylion.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class FeatureController {

    @Autowired
    PermissionService permissionService;

    @ExceptionHandler({JsonMappingException.class,
            MismatchedInputException.class,
            PermissionUpdateMissingInformation.class,
            PermissionUpdateFailed.class})
    @ResponseStatus(value = HttpStatus.NOT_MODIFIED)
    public void handleConverterErrors(JsonMappingException ex) {}


    @RequestMapping(value = "/feature", method = RequestMethod.GET)
    @ResponseBody
    public PermissionEnabledResponse isFeatureEnabled1(@ModelAttribute Permission permission) {
        permission.setEnable(false);
        return new PermissionEnabledResponse(permissionService.getPermission(permission));
    }


    @RequestMapping(value = "/feature", method = RequestMethod.POST)
    public void permissionUpdate(@Valid @RequestBody Permission permission, BindingResult result) {
        if (result.hasErrors()) {
            throw new PermissionUpdateMissingInformation();
        }

        Permission storedPermission = permissionService.getPermission(permission);
        storedPermission.setEnable(permission.isEnable());
        permissionService.save(storedPermission);
    }

}
