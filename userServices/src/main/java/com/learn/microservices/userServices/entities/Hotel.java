package com.learn.microservices.userServices.entities;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Hotel {
    private  String id;
    private String name;
    private String location;
    private String about;
}
