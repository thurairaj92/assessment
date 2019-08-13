package com.thurairaj.moneylion.model.permission;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity(name = "permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="feature_name")
    @NotNull @NotEmpty
    String featureName;

    @NotNull @NotEmpty
    String email;

    boolean enable;

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enabled) {
        this.enable = enabled;
    }

    public static PermissionBuilder builder() {
        return new PermissionBuilder();
    }

    public Permission(){ }

    private Permission(PermissionBuilder builder) {
        this.id = builder.id;
        this.featureName = builder.featureName;
        this.email = builder.email;
        this.enable = builder.enabled;
    }

    public static class PermissionBuilder {
        private long id;
        private String featureName;
        private String email;
        private boolean enabled;

        public long getId() {
            return id;
        }

        public PermissionBuilder setId(long id) {
            this.id = id;
            return this;
        }

        public String getFeatureName() {
            return featureName;
        }

        public PermissionBuilder setFeatureName(String featureName) {
            this.featureName = featureName;
            return this;
        }

        public String getEmail() {
            return email;
        }

        public PermissionBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public boolean isEnabled() {
            return enabled;
        }

        public PermissionBuilder setEnabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        public Permission build() {
            return new Permission(this);
        }
    }
}
