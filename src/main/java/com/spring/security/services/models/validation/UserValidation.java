package com.spring.security.services.models.validation;

import com.spring.security.persistence.entities.UserEntity;
import com.spring.security.services.models.dtos.ResponseDTO;

public class UserValidation {

    public ResponseDTO validate(UserEntity user) {
        ResponseDTO responseDTO = new ResponseDTO();

        responseDTO.setNumOfErrors(0);

        if(user.getFirstName() == null || user.getFirstName().length() < 3 || user.getFirstName().length() > 15) {
            responseDTO.setNumOfErrors(responseDTO.getNumOfErrors() + 1);
            responseDTO.setMessage("FirstName can't be null, also it must contain between 3 and 15 characters");
        }

        if(user.getLastName() == null || user.getLastName().length() < 3 || user.getLastName().length() > 30) {
            responseDTO.setNumOfErrors(responseDTO.getNumOfErrors() + 1);
            responseDTO.setMessage("LastName can't be null, also it must contain between 3 and 30 characters");
        }

        if(user.getEmail() == null || !user.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            responseDTO.setNumOfErrors(responseDTO.getNumOfErrors() + 1);
            responseDTO.setMessage("Email is not valid");
        }

        if(user.getPassword() == null || !user.getPassword() .matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,16}$")) {
            responseDTO.setNumOfErrors(responseDTO.getNumOfErrors() + 1);
            responseDTO.setMessage("Password must contain between 8 and 16 characters, at least a number, a lower case and a capital letter");
        }
        return responseDTO;
    }
}
