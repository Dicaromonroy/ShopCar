/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package shopcar.util;

/**
 *
 * @author info1
 * @param <T>
 * @param <I>
 */
public class MyTuple<T, I>
{
    private final T t;
    private final I i;
    
    public MyTuple(T t, I i)
    {
        this.t = t;
        this.i = i;
    }

    /**
     * @return the t
     */
    public T getT()
    {
        return t;
    }

    /**
     * @return the i
     */
    public I getI()
    {
        return i;
    }
}
