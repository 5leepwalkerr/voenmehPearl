package com.voenmeh.voenmehpearl.dao.request;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SignInRequest {
    private String username;
    private String password;
}
