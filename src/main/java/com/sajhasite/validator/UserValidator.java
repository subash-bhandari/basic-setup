package com.sajhasite.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sajhasite.domain.entity.User;

public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> klass) {
		return User.class.isAssignableFrom(klass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "username", "user.username");
		ValidationUtils.rejectIfEmpty(errors, "password", "user.password");
		ValidationUtils.rejectIfEmpty(errors, "displayName", "user.displayName");
		ValidationUtils.rejectIfEmpty(errors, "email", "user.email");
	}
}
