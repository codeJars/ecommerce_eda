package com.ecommerce.iam_service.entity;


import com.ecommerce.iam_service.constant.Authority;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@Table("users")
public class User {

    @Id
    @Column("user_id")
    private UUID userId;

    private String email;

    @Column("password_hash")
    private String passwordHash;

    private String authorities;

    @Column("is_enabled")
    private Boolean isEnabled;

    @Column("is_account_non_expired")
    private Boolean isAccountNonExpired;

    @Column("is_account_non_locked")
    private Boolean isAccountNonLocked;

    @Column("is_credentials_non_expired")
    private Boolean isCredentialsNonExpired;

    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("updated_at")
    private LocalDateTime updatedAt;

    public static User getUserWithDefaults(){
        return User.builder()
                .authorities(Authority.USER.name())
                .isEnabled(true)
                .isAccountNonExpired(true)
                .isAccountNonLocked(true)
                .isCredentialsNonExpired(true)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        return getRoles().stream()
                .map(authority -> new SimpleGrantedAuthority(authority.name()))
                .collect(Collectors.toSet());
    }
    public List<Authority> getRoles() {
        return Arrays.stream(authorities.split(",")).map( Authority::valueOf)
                .collect(Collectors.toList());
    }

    public String getScope(){
        return authorities.replaceAll(",", " ");
    }

}
