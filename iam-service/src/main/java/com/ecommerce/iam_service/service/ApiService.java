package com.ecommerce.iam_service.service;

import com.ecommerce.iam_service.constant.ErrorCode;
import com.ecommerce.iam_service.dto.response.StandardApiErrorResponse;
import com.ecommerce.iam_service.dto.response.FieldValidationErrorDto;
import com.ecommerce.iam_service.dto.response.StandardApiResponse;

import java.util.List;

public interface ApiService {

    <T> StandardApiResponse<T> buildStandardApiResponse(Integer status, String message, T data);
    StandardApiResponse<StandardApiErrorResponse> buildStandardApiErrorResponse(ErrorCode errorCode, String message, String path, List<FieldValidationErrorDto> errors);

}
