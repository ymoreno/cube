package com.xpertgroup.cube.service.impl;

import com.xpertgroup.cube.Bean.Matrix;
import com.xpertgroup.cube.input.InputQuery;
import com.xpertgroup.cube.input.InputUpdate;
import com.xpertgroup.cube.service.CubeSummationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CubeSummationServiceImpl implements CubeSummationService {

    @Autowired
    Matrix matrix;

    @Override
    public String calculateCubeSummatory() {


        return "va por buen camino";
    }

    @Override
    public String updateSum() {
        return "sigue yendo por buen camino";
    }

    @Override
    public void assignNumberOfTestCases(Integer numberOfTestCases) {

    }

    @Override
    public String defineSizeOfCubeAndNumberOfOperations(Integer size, Integer numberOfOperations) {
        if (size.equals(0)) return "error";
        matrix.setDimensions(size.intValue());
        matrix.setTree(new long[size + 1][size + 1][size + 1]);
        matrix.setNums(new long[size][size][size]);

        return String.format("Tamaño %s", matrix.getDimensions());
    }

    @Override
    public String update(InputUpdate inputUpdate) {
        long[][][] updateValues = matrix.getNums();
        long[][][] updateTree = matrix.getTree();

        long delta = inputUpdate.getValue() - updateValues[inputUpdate.getxCoordinate()][inputUpdate.getyCoordinate()][inputUpdate.getzCoordinate()];
        updateValues[inputUpdate.getxCoordinate()][inputUpdate.getyCoordinate()][inputUpdate.getzCoordinate()] = inputUpdate.getValue();
        for (int i = inputUpdate.getxCoordinate() + 1; i <= matrix.getDimensions(); i += i & (-i)) {
            for (int j = inputUpdate.getyCoordinate() + 1; j <= matrix.getDimensions(); j += j & (-j)) {
                for (int k = inputUpdate.getzCoordinate() + 1; k <= matrix.getDimensions(); k += k & (-k)) {
                    updateTree[i][j][k] += delta;
                }
            }
        }
        matrix.setNums(updateValues);
        matrix.setTree(updateTree);
        return String.format("Tamaño updated %s", matrix.getDimensions());
    }

    @Override
    public Long query(InputQuery inputQuery) {

        long result = sum(inputQuery.getX2Coordinate() + 1, inputQuery.getY2Coordinate() + 1, inputQuery.getZ2Coordinate() + 1) - sum(inputQuery.getX1Coordinate(), inputQuery.getY1Coordinate(), inputQuery.getZ1Coordinate()) - sum(inputQuery.getX1Coordinate(), inputQuery.getY2Coordinate() + 1, inputQuery.getZ2Coordinate() + 1) - sum(inputQuery.getX2Coordinate() + 1, inputQuery.getY1Coordinate(), inputQuery.getZ2Coordinate() + 1) - sum(inputQuery.getX2Coordinate() + 1, inputQuery.getY2Coordinate() + 1, inputQuery.getZ1Coordinate()) + sum(inputQuery.getX1Coordinate(), inputQuery.getY1Coordinate(), inputQuery.getZ2Coordinate() + 1) + sum(inputQuery.getX1Coordinate(), inputQuery.getY2Coordinate() + 1, inputQuery.getZ1Coordinate()) + sum(inputQuery.getX2Coordinate() + 1, inputQuery.getY1Coordinate(), inputQuery.getZ1Coordinate());
        System.out.println(result);


        return result;
    }

    public long sum(int x, int y, int z) {
        long sum = 0l;
        long[][][] values = matrix.getTree();
        for (int i = x; i > 0; i -= i & (-i)) {
            for (int j = y; j > 0; j -= j & (-j)) {
                for (int k = z; k > 0; k -= k & (-k)) {
                    sum += values[i][j][k];
                }
            }
        }
        return sum;
    }
}
