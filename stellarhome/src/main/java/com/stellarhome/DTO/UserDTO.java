package com.stellarhome.DTO;

import lombok.*;

@Data
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO  {
    private Integer id;
    private String name;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String phone; 
}
