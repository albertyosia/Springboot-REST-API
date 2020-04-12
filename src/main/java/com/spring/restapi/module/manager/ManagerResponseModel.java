package com.spring.restapi.module.manager;

import com.spring.restapi.models.GetResponseModel;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class ManagerResponseModel extends GetResponseModel {
  private List<Manager> managers;
}
