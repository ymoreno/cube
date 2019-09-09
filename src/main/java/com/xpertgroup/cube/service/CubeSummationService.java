package com.xpertgroup.cube.service;

import com.xpertgroup.cube.input.InputQuery;
import com.xpertgroup.cube.input.InputUpdate;

public interface CubeSummationService {

    String calculateCubeSummatory();

    String updateSum();

    void assignNumberOfTestCases(Integer numberOfTestCases);

    String defineSizeOfCubeAndNumberOfOperations(Integer size, Integer numberOfOperations);

    String update(InputUpdate inputUpdate);

    Long query(InputQuery inputQuery);
}
