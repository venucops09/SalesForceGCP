package com.example.salesforcegcp.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@ToString
public class SalesforceTokenResponse {

    private String access_token;
    private String instance_url;
    private String id;
    private String token_type;
    private String issued_at;
    private String signature;

}
