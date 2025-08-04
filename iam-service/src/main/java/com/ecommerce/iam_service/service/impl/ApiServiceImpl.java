package com.ecommerce.iam_service.service.impl;

import com.ecommerce.iam_service.constant.ErrorCode;
import com.ecommerce.iam_service.dto.response.StandardApiErrorResponse;
import com.ecommerce.iam_service.dto.response.FieldValidationErrorDto;
import com.ecommerce.iam_service.dto.response.StandardApiResponse;
import com.ecommerce.iam_service.exception.DataMappingException;
import com.ecommerce.iam_service.service.ApiService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
@Log4j2
public class ApiServiceImpl implements ApiService {
    @Override
    public <T> StandardApiResponse<T> buildStandardApiResponse(Integer status, String message, T data) {
        try {
            return StandardApiResponse.<T>builder()
                    .status(status)
                    .message(message)
                    .timeStamp(LocalDateTime.now())
                    .data(data)
                    .build();
        }catch (Exception e) {
            throw new DataMappingException(e, Map.of("message", "Error while building StandardApiResponse"));
        }
    }

    @Override
    public StandardApiResponse<StandardApiErrorResponse> buildStandardApiErrorResponse(ErrorCode errorCode, String message, String path, List<FieldValidationErrorDto> errors){

        LocalDateTime now = LocalDateTime.now();

        StandardApiErrorResponse errorResponse = StandardApiErrorResponse.builder()
                .errorCode(errorCode.getCode())
                .message(message)
                .status(errorCode.getHttpStatus().value())
                .path(path)
                .timestamp(now)
                .errors(errors)
                .build();

        return StandardApiResponse.<StandardApiErrorResponse>builder()
                .status(errorCode.getHttpStatus().value())
                .message(message)
                .timeStamp(now)
                .data(errorResponse)
                .build();
    }
}
