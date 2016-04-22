package com.apl.sha.ers.struts.validator;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.Field;
import org.apache.commons.validator.GenericValidator;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.commons.validator.util.ValidatorUtils;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.Resources;

public class FieldChecks implements Serializable {
	public static boolean validateIdentical(Object bean, ValidatorAction va,
			Field field, ActionMessages errors, Validator validator,
			HttpServletRequest request) {

		String value = ValidatorUtils.getValueAsString(bean, field.getProperty());
		String sField2 = field.getVarValue("fieldJoin");
		String value2 = ValidatorUtils.getValueAsString(bean, sField2);
		if (!GenericValidator.isBlankOrNull(value)) {
			if(!value.equals(value2)) {
				errors.add(field.getKey(), Resources.getActionMessage(validator,
						request, va, field));
				return false;
			}
		} else {
			return true;
		}
		return true;
	}
}
