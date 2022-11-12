package com.peaksoft.springboot_security.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
public class Role {


//    @GeneratedValue(strategy = GenerationType.SEQUENCE,
//            generator = "role_sequence")
//    @SequenceGenerator(name = "role_sequence", sequenceName = "role_seq",
//            allocationSize = 1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
