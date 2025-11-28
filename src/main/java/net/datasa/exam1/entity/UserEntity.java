package net.datasa.exam1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="user")
public class UserEntity {

    @Id
    @Column(name="id", nullable = false, length = 30)
    private String id;

    @Column(name="pwd", nullable = false, length = 200)
    private String pwd;

    @Column(name="name", nullable = false, length = 20)
    private String name;

    @Column(name="phone", nullable = false, length = 20)
    private String phone;

}
