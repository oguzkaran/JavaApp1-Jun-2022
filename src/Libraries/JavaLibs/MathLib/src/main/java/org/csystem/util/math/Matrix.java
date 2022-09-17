/*----------------------------------------------------------------
	FILE		: Matrix.java
	AUTHOR		: JavaApp1-Jun-2022 Group
	LAST UPDATE	: 17.09.2022

	Matrix class that represents a generic matrix

	Copyleft (c) 1993 C and System Programmers Association
	All Rights Free
----------------------------------------------------------------*/
package org.csystem.util.math;

public class Matrix<T extends IOperative<T>> {
    private final T [][] m_matrix;

    public Matrix(T [][] other)
    {
        throw new UnsupportedOperationException("TODO: Copy other matrix");
    }

    @SuppressWarnings("unchecked")
    public Matrix(int row, int col)
    {
        if (row <= 0 || col <= 0)
            throw new IllegalArgumentException(String.format("row and columns must be positive->row:%d, col:%d", row, col));

        m_matrix = (T[][])new Object[row][col];
    }

    public int getRow()
    {
        return m_matrix.length;
    }

    public int getColumn()
    {
        return m_matrix[0].length;
    }

    public void flipVertical()
    {
        throw new UnsupportedOperationException("TODO: Optional");
    }

    public void flipHorizontal()
    {
        throw new UnsupportedOperationException("TODO: Optional");
    }

    public boolean isSquareMatrix()
    {
        throw new UnsupportedOperationException("TODO");
    }

    public void transpose()
    {
        throw new UnsupportedOperationException("TODO");
    }

    public Matrix<T> add(Matrix<T> other)
    {
        var row = m_matrix.length;
        var col = m_matrix[0].length;
        var result = new Matrix<T>(row, col);

        for (var i = 0; i < row; ++i)
            for (var j = 0; j < col; ++j)
                result.m_matrix[i][j] = m_matrix[i][j].add(other.m_matrix[i][j]);

        return result;
    }

    public Matrix<T> subtract(Matrix<T> other)
    {
        throw new UnsupportedOperationException("TODO");
    }

    public Matrix<T> multiply(Matrix<T> other)
    {
        throw new UnsupportedOperationException("TODO: Optional");
    }

    @Override
    public String toString()
    {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public boolean equals(Object obj)
    {
        throw new UnsupportedOperationException("TODO");
    }
}
