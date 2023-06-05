package com.ncr.test.pyramid.solver.impl;

import com.ncr.test.pyramid.data.Pyramid;
import com.ncr.test.pyramid.solver.PyramidSolver;

/**
 * TASK: This is your 3rd task.
 * Please implement the class to satisfy the interface. *
 */
public class YourSolver implements PyramidSolver {

    @Override
    public long pyramidMaximumTotal(Pyramid pyramid) {
        return getTotalAbove(pyramid.getRows(), 0, pyramid);
    }

    /**
     * @param row needs to be subtracted by 1 after the conditional case, if (row == 0).
     * As a result, in recursion we get a row number in the same order as the row index.
     */
    private long getTotalAbove(int row, int column, Pyramid pyramid) {
        if (row-- == 0) return 0;

        return pyramid.get(row, column) +
                Math.max(getTotalAbove(row, column, pyramid),
                        getTotalAbove(row, column + 1, pyramid));
    }

}
