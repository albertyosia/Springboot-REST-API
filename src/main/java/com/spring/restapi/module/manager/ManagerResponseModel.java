package com.spring.restapi.module.manager;

import com.spring.restapi.models.GetResponseModel;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ManagerResponseModel extends GetResponseModel {
  private List<Manager> managers;
}
