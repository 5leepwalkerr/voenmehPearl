package com.voenmeh.voenmehpearl.dao.request;


import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TokenRefreshRequest {
    private String refreshToken;
}
