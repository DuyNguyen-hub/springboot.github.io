package com.spring.student_jpa.model.role;

import com.spring.student_jpa.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
     private String name;

    @Column(name = "parent")
    private long parent;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;
}
