package com.teckstudy.book.domain.resource;

import com.teckstudy.book.domain.role.Role;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "RESOURCES")
//@ToString(exclude = {"roleSet"})
@EntityListeners(value = { AuditingEntityListener.class })
@EqualsAndHashCode(of = "id")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Resources implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "resource_id")
    private Long id;

    @Column(name = "resource_name")
    private String resourceName;

    @Column(name = "http_method")
    private String httpMethod;

    @Column(name = "order_num")
    private int orderNum;

    @Column(name = "resource_type")
    private String resourceType;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "role_resources", joinColumns = {
            @JoinColumn(name = "resource_id") }, inverseJoinColumns = { @JoinColumn(name = "role_id") })
    private Set<Role> roleSet = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public String getResourceType() {
        return resourceType;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }
}