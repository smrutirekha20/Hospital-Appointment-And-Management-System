package com.hams.hamsvc.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserNameNotFoundException {
    private final String message;
}
