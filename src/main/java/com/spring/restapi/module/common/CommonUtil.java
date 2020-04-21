package com.spring.restapi.module.common;

import org.springframework.stereotype.Component;

@Component
public class CommonUtil {
  /**
   * This method is used to validate attribute that contain script .
   * @param str attribute.
   * @return true if str match with regex.
   */
  public boolean validateScript(String str) {
    String regex = "^<script>.</script>$|^<script>.$|^.</script>|"
                    + "^<html>.</html>]$|^<html>.$|^.</html>$";
    return str.matches(regex);
  }
}
