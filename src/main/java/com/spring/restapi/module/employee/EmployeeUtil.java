package com.spring.restapi.module.employee;

import com.spring.restapi.exceptions.AddressLengthException;
import com.spring.restapi.exceptions.AttributeContainScriptException;
import com.spring.restapi.exceptions.EmailLengthException;
import com.spring.restapi.exceptions.EmailPatternException;
import com.spring.restapi.exceptions.NameLengthException;
import com.spring.restapi.module.common.CommonUtil;
import org.springframework.stereotype.Component;

@Component
public class EmployeeUtil {

  private CommonUtil commonUtil;

  public EmployeeUtil(CommonUtil commonUtil) {
    this.commonUtil = commonUtil;
  }

  public boolean validateEmailPattern(String email) {
    String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
    return email.matches(regex);
  }

  /**
   * This method is used to validate attribute of Employee.
   * @param employee Employee object.
   * @return true.
   */
  public boolean validateAttribute(Employee employee) {
    final int maxNameLength = 10;
    final int maxEmailLength = 15;
    final int maxAddressLength = 30;

    boolean getValidateName = commonUtil.validateScript(employee.getEmployeeName());
    if (getValidateName) {
      throw new AttributeContainScriptException("Name must not contain script");
    }

    boolean getValidateEmail = commonUtil.validateScript(employee.getEmployeeEmail());
    if (getValidateEmail) {
      throw new AttributeContainScriptException("Email must not contain script");
    }

    boolean getValidateAddress = commonUtil.validateScript(employee.getEmployeeAddress());
    if (getValidateAddress) {
      throw new AttributeContainScriptException("Address must not contain script");
    }

    boolean getValidateEmailPattern = validateEmailPattern(employee.getEmployeeEmail());
    if (!getValidateEmailPattern) {
      throw new EmailPatternException("Email pattern does not match");
    }

    int nameLength = employee.getEmployeeName().length();
    if (maxNameLength < nameLength) {
      throw new NameLengthException("Name cannot be more than 10 characters");
    }

    int emailLength = employee.getEmployeeEmail().length();
    if (maxEmailLength < emailLength) {
      throw new EmailLengthException("Email cannot be more than 15 characters");
    }

    int addressLength = employee.getEmployeeAddress().length();
    if (maxAddressLength < addressLength) {
      throw new AddressLengthException("Address cannot be more than 30 characters");
    }
    return true;
  }
}
