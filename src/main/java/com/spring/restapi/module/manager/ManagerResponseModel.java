package com.spring.restapi.module.manager;

import com.spring.restapi.models.SuccessResponseModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ManagerResponseModel extends SuccessResponseModel {
  private List<Manager> managers;
}
