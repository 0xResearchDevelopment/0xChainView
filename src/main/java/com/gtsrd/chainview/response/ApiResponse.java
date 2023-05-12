package com.gtsrd.chainview.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse {
    private int status = HttpStatus.OK.value();
    private String message = "Call Success";

}
