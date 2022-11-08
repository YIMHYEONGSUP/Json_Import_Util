package com.example.demo.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CredentialInfo {


    String client_id;
    String client_secret;
    String quota_project_id;
    String refresh_token;
    String type;
}
